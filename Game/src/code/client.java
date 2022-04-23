package code;

import code.database.Database;
import code.leaderboard.Leaderboard;
import code.login.*;
import code.spaceinvaders.*;


// import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class client extends JFrame{

    // private CardLayout cardLayout;

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
        //f = new JFrame();//creating instance of JFrame  
        // Commons.GameWindow.setDefaultCloseOperation(3);
        // Commons.GameWindow.setSize(Commons.BOARD_WIDTH,Commons.BOARD_HEIGHT);
        // Commons.GameWindow.setLayout(null);
        // Commons.GameWindow.setVisible(true);
              
        // JButton leader = new JButton("Show Leaderboard");
        // leader.setBounds(200,200,400, 40);
        // Commons.GameWindow.add(leader);
        // leader.addActionListener(new Leaderboard());
                
        
        // JButton play = new JButton("Play");
        // play.setBounds(200,250,400, 40);
        // Commons.GameWindow.add(play);
        // play.addActionListener(new StartGame());

        // JButton login = new JButton("Login");
        // login.setBounds(200,300,400,40);
        // Commons.GameWindow.add(login);
        // login.addActionListener(new App());
        new App().startLogin();
    }
}
