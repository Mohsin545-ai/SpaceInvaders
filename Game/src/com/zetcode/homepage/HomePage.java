package com.zetcode.homepage;


import javax.swing.*;

import com.zetcode.Commons;
import com.zetcode.database.Database;
import com.zetcode.spaceinvaders.*;
import com.zetcode.leaderboard.*;
import com.zetcode.homepage.*;

import java.awt.*;

public class HomePage {
    

    public HomePage() {
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
    }
}
