package com.zetcode;

import com.zetcode.leaderboard.Leaderboard;
import com.zetcode.leaderboard.SpaceInvaders;
import com.zetcode.login.App;

// import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
public class client extends JFrame{

    private CardLayout cardLayout;

    // public client() {
    //     super("Java Swing MVC");
    //     cardLayout = new CardLayout();

    //     Leaderboard leaderboard = new Leaderboard();

    //     // sets our layout as a card layout
    //     setLayout(cardLayout);

    //     add(leaderboard,"leader");
    //     // size of our application frame
    //     setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
    //     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     setVisible(true);
    // }

    public static void main(String[] args) {
        JFrame f = new JFrame();//creating instance of JFrame  
        f.setDefaultCloseOperation(3);
        f.setSize(Commons.BOARD_WIDTH,Commons.BOARD_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
              
        JButton leader = new JButton("Show Leaderboard");
        leader.setBounds(200,200,400, 40);
        f.add(leader);
        leader.addActionListener(new Leaderboard());
                
        
        JButton play = new JButton("Play");
        play.setBounds(200,250,400, 40);
        f.add(play);
        play.addActionListener(new SpaceInvaders());

        JButton login = new JButton("Login");
        login.setBounds(200,300,400,40);
        f.add(login);
        login.addActionListener(new App());
    }
}
