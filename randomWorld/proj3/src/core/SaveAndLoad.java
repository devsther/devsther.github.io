package core;

import tileengine.TETile;
import tileengine.Tileset;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad {
    private static final String FILE_NAME = "save_file.txt";
    private final File FILE = new File(FILE_NAME);

    private final ArrayList<TETile> TILEARR;
    {
        TILEARR = new ArrayList<>();
        TILEARR.add(Tileset.AVATAR);
        TILEARR.add(Tileset.FLOOR);
        TILEARR.add(Tileset.FLOWER);
        TILEARR.add(Tileset.GRASS);
        TILEARR.add(Tileset.LOCKED_DOOR);
        TILEARR.add(Tileset.MOUNTAIN);
        TILEARR.add(Tileset.NOTHING);
        TILEARR.add(Tileset.SAND);
        TILEARR.add(Tileset.TREE);
        TILEARR.add(Tileset.UNLOCKED_DOOR);
        TILEARR.add(Tileset.WALL);
        TILEARR.add(Tileset.WATER);
    }

    public static void saveGame(TETile[][] tiles, int width, int height, int score) {
        SaveAndLoad saveAndLoad = new SaveAndLoad();
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                //the first line in save_file.txt will be width and height
                bufferedWriter.write(width + " " + height);
                bufferedWriter.newLine();
                for (int y = 0; y < height; y++) {
                    StringBuilder str = new StringBuilder();
                    for (int x = 0; x < width; x++) {
                        //saving the type of tile at index x and y into txt
                        int tileIndex = saveAndLoad.TILEARR.indexOf(tiles[x][y]);
                        if (tileIndex < 0) {
                            throw new IOException("tile map error");
                        }
                        str.append(" ").append(tileIndex);
                    }
                    str = new StringBuilder(str.toString().trim());
                    bufferedWriter.write(str.toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("score " + score);
                bufferedWriter.newLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static World loadGame() {
        int score = 0;
        SaveAndLoad saveAndLoad = new SaveAndLoad();
        if (saveAndLoad.FILE.exists()) {
            try {
                FileReader fileReader = new FileReader(FILE_NAME);
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    String row;
                    String[] temp = bufferedReader.readLine().split(" ");
                    int x = Integer.parseInt(temp[0]);
                    int y = Integer.parseInt(temp[1]);
                    TETile[][] tiles = new TETile[x][y];
                    Point point = null;
                    y = 0;
                    while ((row = bufferedReader.readLine()) != null) {
                        String[] data = row.split(" ");
                        if (data[0].equals("score")) {
                            score = Integer.parseInt(data[1]);
                            continue;
                        }
                        try {
                            for (int i = 0; i < x; i++) {
                                tiles[i][y] = saveAndLoad.TILEARR.get(Integer.parseInt(data[i]));
                                if (tiles[i][y] == Tileset.AVATAR) {
                                    point = new Point(i, y);
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            throw new RuntimeException("Save data is broken!", e);
                        }
                        y++;
                    }
                    if (point == null) {
                        throw new RuntimeException("Save data is broken!");
                    }
                    World world = new World(tiles, point, score);
                    bufferedReader.close();
                    return world;
                } catch (IOException e) {
                    throw new RuntimeException("Save data is broken!", e);
                }
            } catch (IOException e) {
                throw new RuntimeException("Save data is broken!", e);
            }
        }
        return null;
    }

}




