package code.leaderboard;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import code.Commons;
import code.handleframes;

public class View {

	public View(Model model) {
		// Create views swing UI components 
		JTextField searchTermTextField = new JTextField(30);
		JButton filterButton = new JButton("Filter");
		JButton goBack = new JButton("Go Back");
		JTable table = new JTable();

		// // Create table model
		// Model model = new Model();
		table.setModel(model);
		
		// Create controller
		Controller controller = new Controller(searchTermTextField, model);
		filterButton.addActionListener(controller);
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				handleframes.showWindow(Commons.HomeWindow);
				handleframes.closeWindow(Commons.Leaderboard);
				Commons.Leaderboard = new JFrame("Space Invaders Leaderboard");
			}
		}
		);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(searchTermTextField);
		ctrlPane.add(filterButton);
		ctrlPane.add(goBack);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Gamers", TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		// JFrame frame = new JFrame("Space Invaders Leaderboard");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Commons.Leaderboard.add(splitPane);
		Commons.Leaderboard.pack();
		Commons.Leaderboard.setLocationRelativeTo(null);
		Commons.Leaderboard.setVisible(true);
	}
}

