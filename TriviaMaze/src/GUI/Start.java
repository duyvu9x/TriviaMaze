package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;

public class Start {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		starGame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void starGame() {
		// create main frame
		frame = new JFrame("Trivia Maze Group 12");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0,  434, 22);
		frame.getContentPane().add(menuBar);
		frame.getContentPane().add(BorderLayout.NORTH, menuBar);

		JMenu meFile = new JMenu("File");
		JMenu meHelp = new JMenu("Help");
		menuBar.add(meFile);
		menuBar.add(meHelp);

		// menu for File
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		JMenuItem mntmExit = new JMenuItem("Exit");

		// menu item for Help
		JMenuItem mntmAbout = new JMenuItem("About");
		JMenuItem mntmPlayRule = new JMenuItem("Play InsTructions");
		JMenuItem mntmCheats = new JMenuItem("Cheats");

		// add menu item for Jmenu
		meFile.add(mntmSaveGame);
		meFile.add(mntmLoadGame);
		meFile.add(mntmExit);

		meHelp.add(mntmAbout);
		meHelp.add(mntmPlayRule);
		meHelp.add(mntmCheats);
		
		JPanel Jpanel = new JPanel();
		JPanel Jpanel1 = new JPanel();
		JPanel Jpanel2 = new JPanel();
		Jpanel.setBackground(Color.GREEN);
		Jpanel1.setBackground(Color.RED);
		Jpanel2.setBackground(Color.BLUE);

		
		frame.getContentPane().add(BorderLayout.CENTER, Jpanel);
		frame.getContentPane().add(BorderLayout.CENTER, Jpanel1);
		frame.getContentPane().add(BorderLayout.CENTER, Jpanel2);
		

//		JPanel MazePanel = new JPanel();
//		MenuPanel.setBounds(0, 21, 434, 240);
//		frame.getContentPane().add(BorderLayout.CENTER,MenuPanel);
//
//		JPanel Question = new JPanel();
//		MenuPanel.setBounds(0, 21, 434, 240);
//		frame.getContentPane().add(MenuPanel);

		// action listening button
		mntmSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action mntmSaveGame button");
			}
		});
		mntmLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action mntmLoadGame button");
			}
		});
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action mntmExit button");
			}
		});
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action mntmAbout button");
			}
		});
		mntmPlayRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action PlayRuler button");
			}
		});
		mntmCheats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("action Cheats button");
			}
		});

	}
}
