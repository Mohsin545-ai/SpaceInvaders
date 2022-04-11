package com.zetcode.leaderboard;


import javax.swing.table.DefaultTableModel;

import com.zetcode.database.Database;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	public Model() {
		super(Database.getData(), Database.getCols());
	}
}
