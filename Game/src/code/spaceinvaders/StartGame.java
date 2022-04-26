package code.spaceinvaders;
import javax.swing.*;

import code.Commons;
import code.handleframes;
import code.login.User;

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
        UserInput.getnum(); 
        // Commons.spaceInvadersWindow = new JFrame();
        // Commons.GameWindow.setVisible(false);
        Commons.spaceInvadersWindow = new SpaceInvaders();
        handleframes.closeWindow(Commons.HomeWindow);
        play();
       // Commons.GameWindow.setVisible(true);
    }
}

class UserInput{
    public static void getnum(){
        String dims; 

        dims = JOptionPane.showInputDialog("Enter number of rowsxcols");

        String[] parts = dims.split("x");

        Commons.NUMBER_OF_ALIENS_ROWS = Integer.parseInt(parts[0]);
        Commons.NUMBER_OF_ALIENS_COLS = Integer.parseInt(parts[1]);
    }

}