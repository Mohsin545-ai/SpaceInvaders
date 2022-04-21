package com.zetcode.spaceinvaders;
import javax.swing.*;

import com.zetcode.Commons;
import com.zetcode.handleframes;

import java.awt.event.*;

public class StartGame implements ActionListener{
    public void play(){
        SwingUtilities.invokeLater(() -> {
            // var ex = new SpaceInvaders();
            // ex.setVisible(true);
            // Commons.spaceInvadersWindow = new SpaceInvaders();
            handleframes.showWindow(Commons.spaceInvadersWindow);
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Commons.spaceInvadersWindow = new JFrame();
        // Commons.GameWindow.setVisible(false);
        handleframes.closeWindow(Commons.HomeWindow);
        play();
       // Commons.GameWindow.setVisible(true);
    }
}
