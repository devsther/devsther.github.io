package core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdDraw;
import tileengine.TERenderer;
import tileengine.TETile;

import java.awt.*;
import java.util.function.Consumer;

//* MainMenuKey class is used to let user start game with random world or specific world
// by using specific seed *//

public class MainMenuKey extends Main {
    private Scanner scanner;
    private long seed;
    private TERenderer ter;
    private World currentWorld;
    private boolean vision = true;
    private boolean rerender = false;
    private boolean createWorld = false;
    private boolean mayEnd;
    private boolean continueGame;
    private boolean gameOver;
    private double sightRange = 3;
    private boolean first;
    private Point mousePos, prevMousePos;
    private boolean hover;



    public MainMenuKey(TERenderer ter) {
        this.scanner = new Scanner(System.in);
        this.ter = ter;
        mousePos = new Point(0, 0);
        prevMousePos = new Point(0, 0);
    }

    public boolean processMainMenuOption() {
        char key = getMainMenuOption();
        if (key == 'N' || key == 'n') {
            first = true;
            // Start a new world
            seedChecker();
            rerender = true;
            newGame();
            return true; // Continue the game
        } else if (key == 'L' || key == 'l') {
            // Load a previously saved world
            World loadedWorld = SaveAndLoad.loadGame();
            if (loadedWorld != null) {
                currentWorld = loadedWorld;
                gameRunner();
                System.out.println("Game Loaded!");
            } else {
                System.out.println("No saved game to load.");
            }
            return true; // Continue the game
        } else if (key == 'Q' || key == 'q') {
            // Quit the game
            return false; // Signal to quit the game
        }
        return true; // Default to continue the game
    }

    private char getMainMenuOption() {
        if (StdDraw.hasNextKeyTyped()) {
            return StdDraw.nextKeyTyped();
        }
        return ' '; // Return a space if no key is typed
    }

    private void seedChecker() {
        // Set up the font and color for the text
        StdDraw.setFont(new Font("Arial", Font.BOLD, 20));
        StdDraw.setPenColor(StdDraw.WHITE);
        // Clear the screen, 시드 입력창으로 바뀜
        Consumer<String> redrawScreen = (input) -> {
            StdDraw.clear(StdDraw.BLACK);
            StdDraw.text(WIDTH * 0.5, HEIGHT * 0.7,
                    "Enter a seed. Seed format should start with [n] and end with [s]. "
                            + "If you don't have seed, just press S ");
            StdDraw.text(WIDTH * 0.5, HEIGHT * 0.6, input);
            StdDraw.show();
        };
        redrawScreen.accept("");

        String input = "";
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                // Check for the Enter key to finish input
                if (key == 's' || key == 'S') { //enter key
                    break;
                }
                // Backspace to remove a character
                if (key == '\b' && input.length() > 0) { //backspace key
                    input = input.substring(0, input.length() - 1);
                } else if (key != '\b') {
                    input += key;
                }
                // Redraw the screen with the updated input
                redrawScreen.accept(input);
            }
        }

        if (input.isEmpty()) {
            StdDraw.clear(StdDraw.BLACK);
            StdDraw.text(WIDTH * .5, HEIGHT * .5, "Please wait! We are generating world");
            StdDraw.show(3000);
            StdDraw.clear();
            seed = 0;
        } else {
            try {
                int len = input.length();
                String parsed = input.substring(1, len);

                if (input.charAt(0) == 'n') {
                    try {
                        seed = Long.parseLong(parsed);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("invalid seed");
                    }
                } else {
                    throw new NumberFormatException("invalid seed");
                }

            } catch (NumberFormatException e) {
                // If the input is not a valid long, display a message and return
                StdDraw.clear(StdDraw.BLACK);
                StdDraw.text(WIDTH * .5, HEIGHT * .5, "Not a valid seed. Using a random seed instead.");
                StdDraw.show();
                StdDraw.pause(2000); // Pause for 2 seconds to allow the user to read the message
                StdDraw.clear(StdDraw.BLACK);
                StdDraw.text(WIDTH * .5, HEIGHT * .5, "Get Ready!");
                StdDraw.show(2000);
                StdDraw.clear(StdDraw.BLACK);
                seed = 0;
            }
        }
    }

    private void newGame() {
        if (seed == 0) {
            currentWorld = new World(WIDTH, HEIGHT); // Create world without seed
        } else {
            currentWorld = new World(seed, WIDTH, HEIGHT);
        }
        rerender = true;
        gameRunner();
    }

    public void gameKey(char key) {
        rerender = true;
        int width = currentWorld.getWidth();
        int height = currentWorld.getHeight();
        TETile[][] tiles = currentWorld.getTiles();
        Point startPoint = currentWorld.getStartPoint();
        int newX = startPoint.x;
        int newY = startPoint.y;

        char lowerCasedKey = Character.toLowerCase(key);
        System.out.println(lowerCasedKey);

        if (lowerCasedKey == 'v') {
            vision = !vision;
            rerender = true;
        } else if (lowerCasedKey == 'w') {
            newY++;
        } else if (lowerCasedKey == 'a') {
            newX--;
        } else if (lowerCasedKey == 's') {
            if (currentWorld == null && createWorld) {
                newGame();
            }
            newY--;
        } else if (lowerCasedKey == 'd') {
            newX++;
        } else if (lowerCasedKey == ':') {
            mayEnd = true;
        } else if (lowerCasedKey == 'q') {
            if (mayEnd || currentWorld == null) {
                SaveAndLoad.saveGame(tiles, width, height, currentWorld.getScore());
                continueGame = false;
                System.exit(0);
            }
        }
        if (currentWorld.canMove(newX, newY)) {
            currentWorld.updatePositionAndScore(newX, newY);
        }
    }

    private void rerenderWorld() {
        if (vision) {
            ter.renderFrame(currentWorld.getTiles());
        } else {
            ter.renderFrame(currentWorld.getTiles(), currentWorld.getStartPoint(), 4.0);
        }

    }

    private void gameRunner() {
        continueGame = true;
        while (continueGame) {
            // Render the world
            rerenderWorld();
            getMouse();

            // Render the score and time
            renderScore(currentWorld.getScore());
            renderTime();
            renderHoveringInfo();

            // Check for player movement and update the world
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                gameKey(key);
            }

            // Show the updated frame
            StdDraw.show();
            StdDraw.pause(20); // Control the frame rate
        }
    }

    private static void mainMenuOptions() {
        //adding imagefile as a background
        String imagePath = "core/Background image .jpg";
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.picture(WIDTH / 2, HEIGHT / 2, imagePath, WIDTH, HEIGHT);

        //setting the font of the game(title)
        Font titleFont = new Font("Arial", Font.BOLD, 40);
        StdDraw.setFont(titleFont);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(WIDTH / 2, HEIGHT * 0.65, "CS61 BEE : The Game"); //change this for title

        Font menuFont = new Font("Arial", Font.BOLD, 30);
        // Draw the menu options
        // 글자의 간격 바꾸고 싶으면 height 옆에 비율 바꾸면 됨
        StdDraw.setFont(menuFont);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(WIDTH / 2, HEIGHT * 0.50, "New World (N)");
        StdDraw.text(WIDTH / 2, HEIGHT * 0.40, "Load World (L)");
        StdDraw.text(WIDTH / 2, HEIGHT * 0.30, "Quit (Q)");
        //Made by : Esther Moon and Sehoon Byun
        Font creditFont = new Font("Lato", Font.PLAIN, 15);
        StdDraw.setFont(creditFont);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.text(WIDTH * 0.84, HEIGHT * 0.05, "Created By : Esther Moon and Sehoon Byun");

        // Show the screen
        StdDraw.show();
    }

    public World getWorld() {
        return currentWorld;
    }

    public void vision(boolean vis, Point startPos) {
        if (vis) {
            ter.renderFrame(currentWorld.getTiles());
        } else {
            ter.renderFrame(currentWorld.getTiles(), startPos, sightRange);
        }
    }

    private void renderScore(int score) {
        //location where score is going to be shown
        //Includes time as well
        int scoreX = WIDTH - 5; //top right
        int scoreY = HEIGHT - 2; //top
        StdDraw.setFont(new Font("Arial", Font.BOLD, 15));
        StdDraw.setPenColor(Color.pink);
        StdDraw.text(scoreX, scoreY, "Score : " + score);

    }

    private void renderTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        int timeX = 9;
        int timeY = HEIGHT - 2;
        StdDraw.text(timeX, timeY, "Date & Time: " + formattedDateTime);
    }


    private void getMouse() {
        mousePos = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        // Adjust the mouse position based on your game's specifics
        if (!mousePos.equals(prevMousePos)) {
            prevMousePos = new Point(mousePos);
            rerender = true;
        }
    }
    private void renderHoveringInfo() {
        boolean withinRange = mousePos.x >= 0 && mousePos.x < currentWorld.getWidth()
                && mousePos.y >= 0 && mousePos.y < currentWorld.getHeight();

        if (currentWorld != null) {
            // Check whether the mouse is on the game screen
            if (withinRange) {
                TETile tile = currentWorld.getTiles()[mousePos.x][mousePos.y];

                // Display tile type at a specific position on the screen
                // the text set to pink
                StdDraw.setPenColor(StdDraw.PINK);
                StdDraw.textLeft(40, HEIGHT - 2, "Tile: " + tile.description());
            } else {
                // Mouse is outside the bounds of the world, display default message
                StdDraw.setPenColor(StdDraw.PINK);
                StdDraw.textLeft(40, HEIGHT - 2, "Tile: Out of Bounds");
            }
        }

    }
}


