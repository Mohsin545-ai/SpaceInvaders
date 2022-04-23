package code.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {

    private JTextField name;
    private JTextField password;

    private JButton Login;

    public Form() {

        JLabel firstnameLabel = new JLabel("email: ");
        JLabel lastnameLabel = new JLabel("password: ");

        name = new JTextField(25);
        password = new JTextField(25);

        Login = new JButton("Login");
        Login.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        // uses Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firstnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(name, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastnameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(password, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(Login, gridBagConstraints);
    }

    // getters
    public String getFirstname() {
        return name.getText();
    }

    public String getLastname() {
        return password.getText();
    }

    public void login(ActionListener actionListener) {
        Login.addActionListener(actionListener);
    }

    // public void viewUsers(ActionListener actionListener) {
    //     viewButton.addActionListener(actionListener);
    // }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            name.setText("");
            password.setText("");
        }
    }
}
