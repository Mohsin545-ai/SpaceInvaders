package Model;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private final String url = "jdbc:postgresql://localhost/space_invaders";
    private final String user = "postgres";
    private final String password = "Mohsin7@";

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
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
            String save_data = "";

//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < userArrayList.size()) {
                user = userArrayList.get(i);
               // save_data = user.getFirstname() + ", " + user.getLastname();
                i++;
            }

            String SQL = "INSERT INTO player "
                    + "VALUES(?,?)";
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


}
