package core;

import tileengine.TETile;
import tileengine.Tileset;



public class AutograderBuddy {

    /**
     * Simulates a game, but doesn't render anything or call any StdDraw
     * methods. Instead, returns the world that would result if the input string
     * had been typed on the keyboard.
     *
     * Recall that strings ending in ":q" should cause the game to quit and
     * save. To "quit" in this method, save the game to a file, then just return
     * the TETile[][]. Do not call System.exit(0) in this method.
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public static TETile[][] getWorldFromInput(String input) {
        int width = 80;
        int height = 50;
        World gameWorld;

        StringBuilder buf = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                buf.append(Character.toLowerCase(c));

            } else {
                buf.append(c);
            }

        }
        input = buf.toString();
        int len = input.length();
        int fin = input.indexOf('s');

        if (input.charAt(0) == 'n') {
            try {
                // checking valid integer using parseInt()
                // method
                String parsed = input.substring(1, fin);
                long seed = Long.parseLong(parsed);
                System.out.println(parsed + " is a valid integer number");
                gameWorld = new World(seed, width, height);
            } catch (NumberFormatException e) {
                String parsed = input.substring(1, fin);
                System.out.println(
                        parsed + " is not a valid integer number");
                gameWorld = new World(width, height);
            }
            if (len > 3 && input.substring(len - 2).equals(":q")) {
                SaveAndLoad.saveGame(gameWorld.getTiles(), width, height, gameWorld.getScore());
            }
        } else if (input.charAt(0) == 'l') {
            System.out.println(input + " will load the saved game");
            gameWorld = SaveAndLoad.loadGame();

        } else {
            gameWorld = new World(width, height);
        }

        assert gameWorld != null;
        return gameWorld.getTiles();
    }


    /**
     * Used to tell the autograder which tiles are the floor/ground (including
     * any lights/items resting on the ground). Change this
     * method if you add additional tiles.
     */
    public static boolean isGroundTile(TETile t) {
        return t.character() == Tileset.FLOOR.character()
                || t.character() == Tileset.AVATAR.character()
                || t.character() == Tileset.FLOWER.character();
    }

    /**
     * Used to tell the autograder while tiles are the walls/boundaries. Change
     * this method if you add additional tiles.
     */
    public static boolean isBoundaryTile(TETile t) {
        return t.character() == Tileset.WALL.character()
                || t.character() == Tileset.LOCKED_DOOR.character()
                || t.character() == Tileset.UNLOCKED_DOOR.character();
    }


}
