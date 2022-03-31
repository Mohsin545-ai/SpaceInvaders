package com.zetcode;

import javax.swing.SwingUtilities;

public class Leaderboard {

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

	public static void startApplication() throws Exception {
		Model model = new Model();
		new View(model);
	}
}
