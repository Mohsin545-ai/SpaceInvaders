package com.zetcode;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ModelDb {

	private static Object[] TABLE_HEADER = {"Player Name", "High Score"};

	public static Object[][] getData(){
		ArrayList<Object[]> temp = new ArrayList<Object[]>();
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spaceinvaders", "postgres", "mihir")) {
			System.out.println("Connected to PostgreSQL database!");
			
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM gamers");
			
			while (resultSet.next()) {
				Object[] t = new Object[2]; 
				t[0] = resultSet.getString("player_name");
				t[1] = resultSet.getString("high_score");
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

	public static Object[] getCols(){
		return TABLE_HEADER;
	}
}