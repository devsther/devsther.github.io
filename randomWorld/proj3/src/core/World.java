package core;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import tileengine.TERenderer;
import tileengine.TETile;
import tileengine.Tileset;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;

public class World {
    private TERenderer ter;
    private TETile[][] tiles;
    private int height;
    private int width;
    private WeightedQuickUnionUF uf;
    private Random random;
    private Point startPoint;
    private HashMap<Integer, Point> roomCenters;
    private int size;
    private final int minHeight = 5;
    private World world;
    private Point avatarPos;
    private boolean[][] visited;
    private int score;
    private int coin;
    private boolean rerender;
    ////// 프라이머리
    private boolean vision = true;
    private double sightRange = 3;

    //constructor with given seed
    public World(long seed, int width, int height) {
        System.out.println("Entering World constructor with seed.");
        this.tiles = new TETile[width][height];
        this.uf = new WeightedQuickUnionUF(width * height);
        this.roomCenters = new HashMap<>();
        this.height = height;
        this.width = width;
        this.size = width * height;
        this.random = new Random(seed);
        this.visited = new boolean[width][height];
        this.score = score;
        generateRoom();
        generateHallways();
        selectStartPoint();

        fillEmptyTile();
    }
    // Constructor with a String seed
    public World(String seedString, int width, int height) {
        System.out.println("Entering World constructor with String seed.");
        long seed = convertStringToLong(seedString);
        System.out.println("this is a seed " + seed);
        this.tiles = new TETile[width][height];
        this.uf = new WeightedQuickUnionUF(width * height);
        this.roomCenters = new HashMap<>();
        this.height = height;
        this.width = width;
        this.size = width * height;
        this.random = new Random(seed);
        this.visited = new boolean[width][height];
        generateRoom();
        generateHallways();
        selectStartPoint();
        fillEmptyTile();
    }
    //helper changing string to long
    private long convertStringToLong(String seedString) {
        String numericPart = seedString.replaceAll("[^0-9]", "");
        try {
            return Long.parseLong(numericPart);
        } catch (NumberFormatException e) {
            System.err.println("Invalid seed format: " + seedString);
            return 0;
        }
    }
    //constructor where seed is not given
    public World(int width, int height) {
        this(System.currentTimeMillis(), width, height);
        this.visited = new boolean[width][height];
        System.out.println("Entering World constructor without seed.");
    }
    //constructor where takes predifined tiles and startPoint. 저장뒤 세이브 포인트
    public World(TETile[][] tiles, Point startPoint, int score) {
        this.tiles = tiles;
        this.startPoint = startPoint;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.size = this.width * this.height;
        this.uf = new WeightedQuickUnionUF(this.size);
        this.random = new Random(System.currentTimeMillis());
        this.roomCenters = new HashMap<>();
        this.visited = new boolean[width][height];
        this.score = score;
    }


    //constructor to create a new world when level is cleared
    //    public World(long seed, int width, int height, int initialScore) {
    //        this.tiles = new TETile[width][height];
    //        this.uf = new WeightedQuickUnionUF(width * height);
    //        this.roomCenters = new HashMap<>();
    //        this.height = height;
    //        this.width = width;
    //        this.size = width * height;
    //        this.random = new Random(seed);
    //        this.visited = new boolean[width][height];
    //        this.score = score;
    //        generateRoom();
    //        generateHallways();
    //        selectStartPoint();
    //        fillEmptyTile();
    //        // Set the initial score
    //        this.score = initialScore;
    //    }
    public static void main() {
        World newWorld = new World(100, 100);
    }

    private void fillEmptyTile() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tiles[x][y] == null) {
                    tiles[x][y] = Tileset.NOTHING;
                }
            }
        }
    }

    private void selectStartPoint() {
        System.out.println("Entering selectStartPoint method.");
        if (roomCenters.isEmpty()) {
            throw new IllegalStateException("No rooms have been generated to choose a start point from.");
        }
        // Convert the room centers into a list for easy random access
        List<Point> centersList = new ArrayList<>(roomCenters.values());

        // Select a random room center as the start point
        startPoint = centersList.get(random.nextInt(centersList.size()));
        avatarPos = startPoint;

        //will mark the start point
        tiles[startPoint.x][startPoint.y] = Tileset.AVATAR; // or any other specific tile you use to mark the start
        System.out.println(startPoint);
        System.out.println(tiles[startPoint.x][startPoint.y]);
    }

    private void generateHallways() {
        List<Point> roomCenCord = new ArrayList<Point>(roomCenters.values());
        for (int i = 0; i < roomCenCord.size(); i++) {
            double minDis = 10000;
            int targetIndex = 0;
            for (int j = i + 1; j < roomCenCord.size() - 1; j++) {
                double dist = roomCenCord.get(i).distance(roomCenCord.get(j));
                if (dist < minDis && !uf.connected(xyTo1d(roomCenCord.get(i)), xyTo1d(roomCenCord.get(j)))) {
                    minDis = dist;
                    targetIndex = j;
                }
            }
            //union two rooms found using uf
            Point pos1 = roomCenCord.get(i);
            Point pos2 = roomCenCord.get(targetIndex);
            uf.union(xyTo1d(pos1), xyTo1d(pos2));

            //x axis
            int temp = pos1.x < pos2.x ? 1 : -1;
            for (int x = pos1.x; pos1.x < pos2.x ? (x < pos2.x) : (x > pos2.x); x += temp) {
                if (tiles[x][pos1.y] == null || tiles[x][pos1.y] == Tileset.WALL
                        || tiles[x][pos1.y] == Tileset.GRASS) {
                    tiles[x][pos1.y] = Tileset.FLOOR;
                    coin++;

                    if ((tiles[x][pos1.y + 1] == Tileset.FLOOR && tiles[x][pos1.y + 2] == Tileset.WALL)
                            || (tiles[x][pos1.y - 1] == Tileset.FLOOR) && tiles[x][pos1.y - 2] == Tileset.WALL) {
                        tiles[x][pos1.y] = Tileset.WALL;
                    }

                }
                //surrounding the hallway with walls
                for (int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        if (tiles[x + a][pos1.y + b] == null) {
                            tiles[x + a][pos1.y + b] = Tileset.WALL;
                        }
                    }
                }
            }
            //y axis
            temp = pos1.y < pos2.y ? 1 : -1;
            for (int y = pos1.y; pos1.y < pos2.y ? (y < pos2.y) : (y > pos2.y); y += temp) {
                if (tiles[pos2.x][y] == null || tiles[pos2.x][y] == Tileset.WALL
                        || tiles[pos2.x][y] == Tileset.GRASS) {
                    tiles[pos2.x][y] = Tileset.FLOOR;
                    coin++;

                }
                //surrounding the hallway with walls
                for (int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        if (tiles[pos2.x + a][y + b] == null) {
                            tiles[pos2.x + a][y + b] = Tileset.WALL;
                        }
                    }
                }
            }

        }
        System.out.println("Current coint is :" + coin);
    }


    private void generateRoom() {
        int roomLimit = (int) (this.size * 0.1 + random.nextFloat() * 0.15);
        int currSpace = 0;
        while (currSpace < roomLimit) {
            //minimum size of the room is 6x6
            int roomWidth = (int) (minHeight + random.nextFloat() * 5);
            int roomHeight = (int) (minHeight + random.nextFloat() * 5);

            Point pos = new Point((int) (random.nextFloat() * width), (int) (random.nextFloat() * height));
            if (roomGenerator(pos, roomWidth, roomHeight)) {
                currSpace += roomWidth * roomHeight;
            }
        }
    }
    //helper for generateRoom
    private boolean roomGenerator(Point pos, int roomWidth, int roomHeight) {
        //checking condition
        if (outOfBoundRoom(pos, roomWidth, roomHeight)) {
            System.out.println(roomWidth + "out of bound" + roomHeight);
            return false;
        }
        if (checkOverlap(pos, roomWidth, roomHeight)) {
            System.out.println("overlap");
            return false;
        }
        System.out.println("passed validation test");
        //generating room, thickness of wall is 1
        for (int x = -1; x < roomWidth + 1; x++) {
            for (int y = -1; y < roomHeight + 1; y++) {
                //filling room by wall / floor
                if (x < 0 || y < 0 || x > roomWidth - 1 || y > roomHeight - 1) {
                    tiles[pos.x + x][pos.y + y] = Tileset.WALL;
                } else {
                    uf.union(xyTo1d(pos), xyTo1d(pos.x + x, pos.y + y));
                    tiles[pos.x + x][pos.y + y] = Tileset.FLOOR;
                    coin++;
                }
            }
        }
        Point center = new Point(pos.x + (roomWidth / 2), pos.y + (roomHeight / 2));

        // 유니온 인덱스를 키값으로 방 중심 저장
        roomCenters.put(uf.find(xyTo1d(pos)), center);
        System.out.println("key" + roomCenters.keySet() + "this is a center value" + roomCenters.values());
        return true;
    }

    private int xyTo1d(Point pos) {
        return xyTo1d(pos.x, pos.y);
    }

    private int xyTo1d(int x, int y) {
        return y * width + x;
    }

    private boolean outOfBoundRoom(Point pos, int roomWidth, int roomHeight) {
        Boolean check;
        check = roomWidth < minHeight
                || roomHeight < minHeight
                || pos.x < 1
                || pos.y < 1
                || pos.x + roomWidth > width - 1
                || pos.y + roomHeight > height - 1;
        return check;
    }

    private boolean checkOverlap(Point pos, int roomWidth, int roomHeight) {
        int minDist = 2;
        boolean check;
        for (int x = -minDist; x < roomWidth + minDist; x++) {
            for (int y = -minDist; y < roomHeight + minDist; y++) {
                if (pos.x + x < 0 || pos.x + x > width - 1 || pos.y + y < 0 || pos.y + y > height - 1) {
                    continue;
                }
                if (tiles[pos.x + x][pos.y + y] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public TETile[][] getTiles() {
        return tiles;
    }

    //    public TETile[][] setTiles(TETile[][] tiles) {
    //        return this.tiles = tiles;
    //    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Point getStartPoint() {
        return startPoint;
    }

    public void movePlayer(char key) {
        int newX = startPoint.x;
        int newY = startPoint.y;

        avatarPos = startPoint;
        //        if (StdDraw.hasNextKeyTyped()) {
        rerender = false;
        //            char key = StdDraw.nextKeyTyped();
        //            char lowerCasedKey = Character.toLowerCase(key);
        switch (key) {
            case 'w': // move up
                newY++;
                break;
            case 'a': // move left
                newX--;
                break;
            case 's': // move down
                newY--;
                break;
            case 'd': // move right
                newX++;
                break;
            case 'v':
                vision = !vision;
                rerender = true;
                break;
            default:
                break;
        }
        //벽이면 안 움직이게
        if (canMove(newX, newY)) {
            updatePositionAndScore(newX, newY);
        }

    }
    public boolean canMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && tiles[x][y] != Tileset.WALL;
    }

    public void updatePositionAndScore(int newX, int newY) {
        if (!visited[newX][newY]) {

            score += 10; // Increment score by 10, or any other value you deem appropriate
            coin--;
            visited[newX][newY] = true;
        }

        // Update avatar position
        tiles[startPoint.x][startPoint.y] = Tileset.NOTHING; // Clear old position
        System.out.println("Current coint is :" + coin);
        startPoint.setLocation(newX, newY);
        avatarPos = startPoint;
        // Update to new position
        tiles[newX][newY] = Tileset.AVATAR;
    }

    private void loadWorld() {
        world = SaveAndLoad.loadGame();
        avatarPos = new Point(world.startPoint);
    }

    public int getScore() {
        return this.score;
    }

    public int getCoin() {
        return coin;
    }

    public void vision(World currWorld) {
        if (vision) {
            ter.renderFrame(currWorld.getTiles());
        } else {
            ter.renderFrame(currWorld.getTiles(), startPoint, sightRange);
        }
    }
}
