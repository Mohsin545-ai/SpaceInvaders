package com.zetcode;

import com.zetcode.login.App;

// import javax.swing.JFrame;
import javax.swing.*; 
public class client {
    public static void main(String[] args) {
        JFrame f = new JFrame();//creating instance of JFrame  
        f.setDefaultCloseOperation(3);
        f.setSize(700,700);
        f.setLayout(null);
        f.setVisible(true);
              
        JButton leader = new JButton("Show Leaderboard");
        leader.setBounds(400,400,400, 40);
        f.add(leader);
        leader.addActionListener(new Leaderboard());
                
        
        JButton play = new JButton("Play");
        play.setBounds(400,600,400, 40);
        f.add(play);
        play.addActionListener(new SpaceInvaders());

        JButton login = new JButton("Login");
        login.setBounds(400,700,400,40);
        f.add(login);
        login.addActionListener(new App());
    }
}
