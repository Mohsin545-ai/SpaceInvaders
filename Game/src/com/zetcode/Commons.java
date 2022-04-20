package com.zetcode;
import java.awt.*;
import javax.swing.*;
import com.zetcode.spaceinvaders.*;
public interface Commons {
    Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
    int BOARD_WIDTH = (int)s.getWidth();//750;//358;
    int BOARD_HEIGHT = (int)s.getHeight();//450;//350;
    int BORDER_RIGHT = 30;
    int BORDER_LEFT = 5;
    
    int GROUND = BOARD_HEIGHT - 100;//290;
    int BOMB_HEIGHT = 5;
    
    int ALIEN_HEIGHT = 12;
    int ALIEN_WIDTH = 12;
    int ALIEN_INIT_X = 150;
    int ALIEN_INIT_Y = 5;
    
    int GO_DOWN = 15;
    int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    int CHANCE = 5;
    int DELAY = 6;
    int PLAYER_WIDTH = 15;
    int PLAYER_HEIGHT = 10;
    
    JFrame GameWindow = new JFrame();
    JFrame HomeWindow = new JFrame();
    JFrame Leaderboard = new JFrame("Space Invaders Leaderboard");
    CardLayout cardLayout = new CardLayout();
    JFrame spaceInvadersWindow = new SpaceInvaders();
}
