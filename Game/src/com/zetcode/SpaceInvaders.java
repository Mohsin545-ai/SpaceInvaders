package com.zetcode;

import java.awt.EventQueue;
// import javax.swing.JFrame;
import javax.swing.*;  
import java.awt.event.*;

public class SpaceInvaders extends JFrame implements ActionListener {

    public SpaceInvaders() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        
        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    //public static void main(String[] args) { 
        public void play(){
        EventQueue.invokeLater(() -> {
            var ex = new SpaceInvaders();
            ex.setVisible(true);
        });
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            play();
        }
}