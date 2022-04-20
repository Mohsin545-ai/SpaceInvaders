package com.zetcode.homepage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class HomeForm extends JPanel {

    private JButton playgame;
    private JButton leaderboard;

    public HomeForm() {

        playgame = new JButton("Play Game");
        playgame.setPreferredSize(new Dimension(278, 40));
        leaderboard = new JButton("View Leaderboard");
        leaderboard.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(playgame, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;

        add(leaderboard, gridBagConstraints);
    }

    public void playGame(ActionListener actionListener) {
        playgame.addActionListener(actionListener);
    }

    public void viewLeaderboard(ActionListener actionListener) {
        leaderboard.addActionListener(actionListener);
    }
}
