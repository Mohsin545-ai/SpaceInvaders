package com.zetcode.login;

// import MainFrame;
import java.awt.event.*;
import javax.swing.*;

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
        startLogin();
    }
}