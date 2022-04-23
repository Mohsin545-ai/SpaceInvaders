package code.homepage;


import javax.swing.*;

import code.Commons;
import code.database.Database;
import code.spaceinvaders.*;
import code.leaderboard.*;
import code.login.App;

public class HomePage {
    private static String playerName;

    public HomePage(String gamerName) {
        playerName = gamerName;
        // size of our application frame
        Commons.HomeWindow.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        Commons.HomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Commons.HomeWindow.setVisible(true);

        HomeForm form = new HomeForm();

        // sets our layout as a card layout
        Commons.HomeWindow.setLayout(Commons.cardLayout);
        Commons.HomeWindow.add(form, "form");

        form.viewLeaderboard(new Leaderboard());
        form.playGame(new StartGame());
        form.Logout(new App());
    }
    public static void increaseScore(){
        Database.updateScore(playerName);
    }
}
