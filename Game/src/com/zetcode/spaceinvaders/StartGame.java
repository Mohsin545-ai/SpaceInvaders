package com.zetcode.spaceinvaders;
import javax.swing.*;

import com.zetcode.Commons;

import java.awt.event.*;

public class StartGame implements ActionListener{
    public void play(){
        SwingUtilities.invokeLater(() -> {
            var ex = new SpaceInvaders();
            ex.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Commons.GameWindow.setVisible(false);
        play();
        Commons.GameWindow.setVisible(true);
    }
}
