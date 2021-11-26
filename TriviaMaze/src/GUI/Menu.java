package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author Duyvu
 *@version 1.0
 */

public class Menu {

	// main frmMenu Game.
	private JFrame frmMemuGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMemuGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		menu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void menu() {
		frmMemuGame = new JFrame();
		frmMemuGame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMemuGame.setTitle("Trivial Maze Game");
		frmMemuGame.setBounds(100, 100, 500, 400);
		frmMemuGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMemuGame.getContentPane().setLayout(null);

		/**
		 * initialize buttton.
		 */
		JButton btnFile = new JButton("File");
		JButton btnGuest = new JButton("Guest");
		JButton btnPlay = new JButton("Play");
		JButton btnScore = new JButton("High Score");
		JButton btnSetting = new JButton("Setting");

		btnFile.setBounds(180, 50, 120, 40);
		frmMemuGame.getContentPane().add(btnFile);

		btnGuest.setBounds(180, 100, 120, 40);
		frmMemuGame.getContentPane().add(btnGuest);

		btnPlay.setBounds(180, 150, 120, 40);
		frmMemuGame.getContentPane().add(btnPlay);

		btnScore.setBounds(180, 200, 120, 40);
		frmMemuGame.getContentPane().add(btnScore);

		btnSetting.setBounds(180, 250, 120, 40);
		frmMemuGame.getContentPane().add(btnSetting);

		/**
		 * Set color for button.
		 */
//		btnLogin.setBackground(Color.GREEN);
//		btnGuest.setBackground(Color.GREEN);
//		btnPlay.setBackground(Color.GREEN);
//		btnScore.setBackground(Color.YELLOW);
//		btnSetting.setBackground(Color.GREEN);

		/*
		 * visible button.
		 */
//		btnPlay.setVisible(false);
//		btnScore.setVisible(false);
//		btnSetting.setVisible(false);

		/**
		 * action listening.
		 */
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}
