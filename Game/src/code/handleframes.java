package code;
import javax.swing.*;
/*
Structural design pattern : Facade
*/
public class handleframes {
    public static void showWindow(JFrame window){
        window.setVisible(true);
    }
    public static void closeWindow(JFrame window){
        window.setVisible(false);
    }
    public static void setSize(JFrame window){
        window.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
    }
}
