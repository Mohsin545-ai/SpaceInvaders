package com.zetcode;
import java.awt.*;
import javax.swing.*;
import com.zetcode.spaceinvaders.*;
public class Commons {
    public static Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
    public static int BOARD_WIDTH = (int)s.getWidth();//750;//358;
    public static int BOARD_HEIGHT = (int)s.getHeight();//450;//350;
    public static int BORDER_RIGHT = 30;
    public static int BORDER_LEFT = 5;

    public static int GROUND = BOARD_HEIGHT - 100;//290;
    public static int BOMB_HEIGHT = 5;
    
    public static int ALIEN_HEIGHT = 12;
    public static int ALIEN_WIDTH = 12;
    public static int ALIEN_INIT_X = 150;
    public static int ALIEN_INIT_Y = 5;
    
    public static int GO_DOWN = 15;
    public static int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    public static int CHANCE = 5;
    public static int DELAY = 6;
    public static int PLAYER_WIDTH = 15;
    public static int PLAYER_HEIGHT = 10;
    
    public static JFrame GameWindow = new JFrame();
    public static JFrame HomeWindow = new JFrame();
    public static JFrame Leaderboard = new JFrame("Space Invaders Leaderboard");
    public static CardLayout cardLayout = new CardLayout();
    public static JFrame spaceInvadersWindow = new SpaceInvaders();
}
