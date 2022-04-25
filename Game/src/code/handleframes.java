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
}
