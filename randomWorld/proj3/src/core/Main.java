package core;

import tileengine.TERenderer;
import java.awt.*;
import edu.princeton.cs.algs4.StdDraw;

public class Main {
    //Inital size of the window
    static final int WIDTH = 80;
    static final int HEIGHT = 50;
    static TERenderer window;
    public static void main(String[] args) {
        // to create the main menu window
        window = new TERenderer();
        window.initialize(WIDTH, HEIGHT, 0, 0);
        // main menu options
        mainMenuOptions();
        MainMenuKey menuKey = new MainMenuKey(window);
        boolean continueGame = true;
        while (continueGame) {
            continueGame = menuKey.processMainMenuOption();
        }
        // Quitting the game
        System.out.println("Thanks for playing!");
        System.exit(0);
    }


    // mainMenuOption is a method for the starting page. Use if want to change name or font settings
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
}




