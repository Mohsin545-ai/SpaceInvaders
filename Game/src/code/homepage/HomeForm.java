package code.homepage;

import javax.swing.*;

import code.Commons;
import code.handleframes;

import java.awt.*;
import java.awt.event.ActionListener;

public class HomeForm extends JPanel {

    private JButton playgame;
    private JButton leaderboard;
    private JButton logout;

    public HomeForm() {

        playgame = new JButton("Play Game");
        playgame.setPreferredSize(new Dimension(278, 40));
        leaderboard = new JButton("View Leaderboard");
        leaderboard.setPreferredSize(new Dimension(278, 40));
        logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(278, 40));

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

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;

        add(logout, gridBagConstraints);
    }

    public void playGame(ActionListener actionListener) {
        playgame.addActionListener(actionListener);
    }

    public void viewLeaderboard(ActionListener actionListener) {
        leaderboard.addActionListener(actionListener);
    }

    public void Logout(ActionListener actionListener) {
        logout.addActionListener(actionListener);
    }
}
