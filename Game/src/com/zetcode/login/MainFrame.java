package com.zetcode.login;

// import Controller.UserController;
// import Model.Database;
// import Model.User;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;
    private Database database;


    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();
        Form form = new Form();
        UserDetails userDetails = new UserDetails();
        this.database = new Database();

        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        // new UserController(form, userDetails);

        // adds view to card layout with unique constraints
        add(form, "form");
        add(userDetails, "user details");
        form.submitUsers(e -> userDetails.getUsers(this.database.loadUsers()));
        // switch view according to its constraints on click
        form.submitUsers(e -> {
            String name = form.getFirstname().trim();
            String password = form.getLastname().trim();

            // simple validations
            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(form, "First Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(form, "Last Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }


            if (this.database.addUser(new User(name, password))) {
                System.out.println("Hello");
                String[][] users = this.database.loadUsers();
                for (String[] row : users) {
                    if (row[0].compareTo(name) == 0) {
                        if (row[0].compareTo(password) == 0) {
//                            JOptionPane.showMessageDialog(this.form, "Login successfull.", "Sucess",
//                                    JOptionPane.ERROR_MESSAGE);

                            cardLayout.show(MainFrame.this.getContentPane(), "user details");
                            return;

                        } else {
                            JOptionPane.showMessageDialog(form, "Invalid password.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
            } {
                System.out.println("hello in else");
                this.database.saveUser();
                form.reset(true);
            }
        });




        form.viewUsers(e -> cardLayout.show(MainFrame.this.getContentPane(), "user details"));

        userDetails.backButton(e -> cardLayout.show(MainFrame.this.getContentPane(), "form"));

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
