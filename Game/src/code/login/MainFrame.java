package code.login;

// import Controller.UserController;
// import Model.Database;
// import Model.User;

import javax.swing.*;

import code.Commons;
import code.handleframes;
import code.database.Database;
import code.homepage.*;

public class MainFrame {//extends JFrame {

    // Card layout for switching view
    // private CardLayout cardLayout;
    private Database database;
    

    public MainFrame() {
        // size of our application frame
        handleframes.setSize(Commons.GameWindow);
        Commons.GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        handleframes.showWindow(Commons.GameWindow);

        // super("Java Swing MVC");
        // cardLayout = new CardLayout();
        Form form = new Form();
        // UserDetails userDetails = new UserDetails();
        this.database = new Database();

        // sets our layout as a card layout
        Commons.GameWindow.setLayout(Commons.cardLayout);

        // initialize user controller
        // new UserController(form, userDetails);

        // adds view to card layout with unique constraints
        Commons.GameWindow.add(form, "form");
        // Commons.GameWindow.add(userDetails, "user details");
        // form.submitUsers(e -> userDetails.getUsers(this.database.loadUsers()));
        // switch view according to its constraints on click
        form.login(e -> {
            String name = form.getFirstname().trim();
            String password = form.getLastname().trim();

            // simple validations
            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(form, "First Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(form, "Last Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            if (this.database.addUser(new User(name, password))) {
                // System.out.println("Hello");
                String[][] users = this.database.loadUsers();
                for (String[] row : users) {
                    if (row[0].compareTo(name) == 0) {

                        if (row[1].compareTo(password) == 0) {
                            JOptionPane.showMessageDialog(form, "Successfully logged in!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        //    JOptionPane.showMessageDialog(this.form, "Login successfull.", "Sucess", JOptionPane.ERROR_MESSAGE);

                            //Commons.cardLayout.show(Commons.GameWindow.getContentPane(), "user details");
                            // Commons.GameWindow.setVisible(false);
                            handleframes.closeWindow(Commons.GameWindow);
                            // new StartGame().play();
                            new HomePage(name);
                            return;

                        } 
                        else {
                            JOptionPane.showMessageDialog(form, "Invalid password.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
            } else {
                // System.out.println("hello in else");
                JOptionPane.showMessageDialog(form, "Successfully registered!", "Registered", JOptionPane.INFORMATION_MESSAGE);
                this.database.saveUser();
                
            }

            form.reset(true);
        });

        //form.viewUsers(new Leaderboard());
        //form.viewUsers(Commons.GameWindow.setVisible(false));
        // form.viewUsers(e -> Commons.cardLayout.show(MainFrame.this.getContentPane(), "user details"));
    }
}
