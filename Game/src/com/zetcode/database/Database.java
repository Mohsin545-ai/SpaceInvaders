package com.zetcode.database;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import com.zetcode.login.User;

public class Database {
    private static Object[] TABLE_HEADER = {"Player Name", "High Score"};

    private static String url = "jdbc:postgresql://localhost:5432/spaceinvaders";//"jdbc:postgresql://localhost/space_invaders";
    private static String user = "postgres";
    private static String password = "mihir";//"mohsin";

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
    }
    
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static Object[][] getData(){
		ArrayList<Object[]> temp = new ArrayList<Object[]>();
		try (Connection connection = connect()) {
			System.out.println("Connected to PostgreSQL database!");
			
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM player");
			
			while (resultSet.next()) {
				Object[] t = new Object[2]; 
				t[0] = resultSet.getString("name");
				t[1] = resultSet.getString("highscore");
				temp.add(t);
            }
        }
		catch (SQLException e) {
			System.out.println("Connection failure!");
            e.printStackTrace();
        }
		Object[][] ans = new Object[temp.size()][2];
		for(int i=0; i<temp.size(); i++){
			ans[i] = temp.get(i);
		}
		return ans;
	}



    // adds user to our collection
    public boolean addUser(User user) {

        if (userArrayList.size() == 0) {
            System.out.println("empty");
        }
        String[][] users = this.loadUsers();

        for (String[] row : users) {
            if (row[0].compareTo(user.getName()) == 0) {
                return true;
            }
        }
        userArrayList.add(user);
        return false;
    }

    // saves user to database file
    public void saveUser() {
        try {
            // user model
            User user = null;
            // String save_data = "";

//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < userArrayList.size()) {
                user = userArrayList.get(i);
               // save_data = user.getFirstname() + ", " + user.getLastname();
                i++;
            }

            String SQL = "INSERT INTO player " + "VALUES(?,?)";
            try (
                    Connection conn = connect();
                    PreparedStatement statement = conn.prepareStatement(SQL);) {



               if (user != null) {
                   statement.setString(1, user.getName());
                   statement.setString(2, user.getPassword());
               }


                statement.addBatch();

                // execute every 100 rows or less

                statement.executeBatch();


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }


//            bufferedWriter.write(save_data);
//            bufferedWriter.newLine();
//            // prevents memory leak
//            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // reads user from database file
    public String[][] loadUsers() {
//        Object[] objects;
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            // each lines to array
//            objects = bufferedReader.lines().toArray();
//            bufferedReader.close();
//            return objects;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;


        String SQL = "SELECT * FROM player";
        String[][] data;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            data = displayActor(rs);
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;

    }

    private String[][] displayActor(ResultSet rs) throws SQLException {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        while (rs.next()) {
//            System.out.println(rs.getString("student_id") + "\t"
//                    + rs.getString("name") + "\t"
//                    + rs.getString("semester"));

            ArrayList<String> row = new ArrayList<>();
            row.add(rs.getString("name"));
            row.add(rs.getString("password"));
            row.add(rs.getString("highscore"));

            data.add(row);

        }


        String[][] arr = data.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);

        return arr;
    }

    public static Object[] getCols(){
		return TABLE_HEADER;
	}

    public static void updateScore(String name){
        String sqlUpdate = "update player set highscore = highscore + 1 where name=" + "'" + name + "'" + ";";
        try (Connection connection = connect()) {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlUpdate);
			System.out.println("Connected to PostgreSQL database and sucessfully updated score!");
        }
		catch (SQLException e) {
			System.out.println("Connection failure!");
            e.printStackTrace();
        }
    }
}
