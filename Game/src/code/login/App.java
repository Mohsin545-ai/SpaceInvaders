package code.login;

// import MainFrame;
import java.awt.event.*;
import javax.swing.*;

import code.Commons;
import code.handleframes;

// public class App {
//     public static void main(String[] args) {
//         // runs in AWT thread
//         SwingUtilities.invokeLater(MainFrame::new);
//     }

// }
public class App implements ActionListener{
    public void startLogin() {
        // runs in AWT thread
        SwingUtilities.invokeLater(MainFrame::new);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Commons.HomeWindow.isVisible()){
            handleframes.closeWindow(Commons.HomeWindow);
        }
        startLogin();
    }
}