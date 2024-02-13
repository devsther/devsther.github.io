import core.AutograderBuddy;
import core.World;
import edu.princeton.cs.algs4.StdDraw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tileengine.TERenderer;
import tileengine.TETile;

import static com.google.common.truth.Truth.assertThat;

public class WorldGenTests {
    @Test
    public void basicTest() {
        // put different seeds here to test different worlds
        TETile[][] tiles = AutograderBuddy.getWorldFromInput("n1234567890123456789s");

        TERenderer ter = new TERenderer();
        ter.initialize(tiles.length, tiles[0].length);
        ter.renderFrame(tiles);
        StdDraw.pause(5000); // pause for 5 seconds so you can see the output
    }

    @Test
    public void basicInteractivityTest() {
        // put different seeds here to test different worlds

        TETile[][] tiles = AutograderBuddy.getWorldFromInput("n123swasdwasd");
        TERenderer ter = new TERenderer();
        ter.initialize(tiles.length, tiles[0].length);
        ter.renderFrame(tiles);
        StdDraw.pause(5000); // pause for 5 seconds so you can see the output

    }

    @Test
    public void interactivityTest() {
        TETile[][] tiles = AutograderBuddy.getWorldFromInput("N999SDDD:Q");
        TERenderer ter = new TERenderer();
        ter.initialize(tiles.length, tiles[0].length);
        ter.renderFrame(tiles);
        StdDraw.pause(5000); // pause for 5 seconds so you can see the output
    }

    @Test
    public void testDifferentInputsLeadToDifferentTileArrays() {
        // Generate world with first input
        World world1 = new World("inputString1", 80, 50);
        TETile[][] tiles1 = world1.getTiles();

        // Generate world with second input
        World world2 = new World("inputString2", 80, 50);
        TETile[][] tiles2 = world2.getTiles();

        // Assert that the two tile arrays are not equal
        assertThat(tiles1).isNotEqualTo(tiles2);
    }

    @Test
    public void testGetWorldFromInput() {
        // Define the input string for the test
        String input = "l";

        // Call the getWorldFromInput method with the test input
        TETile[][] tiles = AutograderBuddy.getWorldFromInput(input);

        Assertions.assertNotNull(tiles, "Resulting world should not be null");


    }
}
