package com.zetcode;

import java.awt.EventQueue;
// import javax.swing.JFrame;
import javax.swing.*; 
public class client {
    public static void main(String[] args) {
        JFrame f = new JFrame();//creating instance of JFrame  
        f.setDefaultCloseOperation(3);
        f.setSize(1000,1000);
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
    }
}
