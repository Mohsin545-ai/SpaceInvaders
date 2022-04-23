package code.leaderboard;


import javax.swing.table.DefaultTableModel;

import code.database.Database;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	public Model() {
		super(Database.getData(), Database.getCols());
	}
}
