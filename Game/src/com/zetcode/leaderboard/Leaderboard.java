package com.zetcode.leaderboard;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public class Leaderboard implements ActionListener{

	public static void ShowLeaderboard() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					startApplication();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void startApplication(){// throws Exception {
	// public static View startApplication() throws Exception {
		Model model = new Model();
		new View(model);
		// return new View(model);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ShowLeaderboard();
	}	
}
