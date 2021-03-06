package code.spaceinvaders;

// import javax.swing.JFrame;
import javax.swing.*;

import code.Commons;

import java.awt.*;

public class SpaceInvaders extends JFrame {

    public SpaceInvaders() {
        super("Java Swing MVC");
        initUI();
    }

    private void initUI() {
        setTitle("Space Invaders");
        setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);
        
        Board board = new Board();
        // Form form = new Form();
        // add(form,"form");
        add(board,"game");
        // form.viewUsers(e -> cardLayout.show(SpaceInvaders.this.getContentPane(), "game"));
    }
}