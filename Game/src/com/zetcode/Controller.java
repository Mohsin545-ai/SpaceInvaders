package com.zetcode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	
	private DefaultTableModel model;
	private JTextField searchTermTextField = new JTextField(30);

	public Controller(JTextField searchTermTextField, DefaultTableModel model) {
		super();
		this.model = model;
		this.searchTermTextField = searchTermTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String searchTerm = searchTermTextField.getText();
		if (searchTerm != null && !"".equals(searchTerm)) {
			Object[][] data = ModelDb.getData();
			Object[] cols = ModelDb.getCols();

			Object[][] newData = new Object[data.length][];
			int idx = 0;
			for (Object[] o: data) {
				if ("*".equals(searchTerm.trim())) {
					newData[idx++] = o;
				} 
				else {
					if(String.valueOf(o[0]).startsWith(searchTerm.trim())){
						newData[idx++] = o;
					}	
				}	
			}
			model.setDataVector(newData, cols);
		} 
		else {
			JOptionPane.showMessageDialog(null, "Search term is empty", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
}
