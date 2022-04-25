/*
Creational design pattern used here, singleton pattern.
*/
package code.database;

import java.sql.*;

public class sqldb {
    private static Connection connection = null;
 
    private static String url = "jdbc:postgresql://localhost:5432/spaceinvaders";//"jdbc:postgresql://localhost/space_invaders";
    private static String user = "postgres";
    private static String passwordMihir = "mihir";
    private static String passwordMohsin = "mohsin";
    
    private sqldb() {}
 
    public static Connection connect() {
        
        if(connection == null){
            System.out.println("Connected to PostgreSQL database!");
            try{
                connection =  DriverManager.getConnection(url, user, passwordMohsin);
            }
            catch(SQLException e){
                try {
                    connection =  DriverManager.getConnection(url, user, passwordMihir);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return connection;
    }
}
