package com.zetcode;


import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	public Model() {
		super(ModelDb.getData(), ModelDb.getCols());
	}
}
