package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Application.TriviaMaze;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TriviaMazeGUI {
	
	public static final int WIDTH_SIZE = 1000;
	public static final int HEIGHT_SIZE = 800;
	
	public static final int WIDTH_PANEL_SIZE = 800;
	public static final int HEIGHT_PANEL_SIZE = 600;
	
	
	
	
	
	
	
	public  JFrame myFrame;
	public static JLayeredPane layeredPane;
	
	public  JPanel myLoginPanel;
	
	public   JPanel myMenuPanel;
	
	public static  JPanel myMazePanel;
	
	
	public  JTextField inputID;
	private ImageIcon backGroundImage; 
	private JLabel Background;

	
	
	
	


	/**
	 * Create the application.
	 */
	public TriviaMazeGUI() {

		startGame();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void startGame() {
		
		
		myFrame = new JFrame("Maze Game Group 12");
		myFrame.setBounds(0, 0, WIDTH_SIZE, HEIGHT_SIZE);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		backGroundImage = new ImageIcon("icon\\FrameBackGround.jpg");
//		Background = new JLabel(backGroundImage);	
//		Background.setSize(1000,800);
//		myFrame.add(Background);
//		Background.setVisible(true);
		
		layeredPane = new JLayeredPane();
		myFrame.getContentPane().add(layeredPane);
		createLoginPanel();
	}

	public void createLoginPanel() {

		// create loginPanel
		myLoginPanel = new JPanel();
//		myLoginPanel.setBackground(null);
		myLoginPanel.setBounds(100, 100, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
		layeredPane.add(myLoginPanel);

		// create new player button
		JButton btnNewPlayer = new JButton("New Player");
		btnNewPlayer.setBounds(200, 100, 115, 35);

//		// create login button
//		JButton btnLogin = new JButton("Login");
//		btnLogin.setBounds(23, 214, 115, 33);

		// create textFile to get name player
		inputID = new JTextField();
		inputID.setBounds(375, 100, 115, 35);
		inputID.setColumns(20);
		inputID.setVisible(false);

		JButton btnInputNewName = new JButton("OK");
		btnInputNewName.setBounds(386, 167, 89, 23);
		btnInputNewName.setVisible(false);
		
		
//		JButton btnInputLogin = new JButton("OK");
//		btnInputLogin.setBounds(33, 272, 89, 23);
//		btnInputLogin.setVisible(false);
		
		// add component to myLoginPanel
		myLoginPanel.setLayout(null);
		myLoginPanel.add(btnNewPlayer);
//		myLoginPanel.add(btnLogin);
		myLoginPanel.add(inputID);
		myLoginPanel.add(btnInputNewName);
		
	
//		myLoginPanel.add(btnInputLogin);
		
		

		myLoginPanel.setVisible(true);
	
		
		
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputID.setVisible(true);
				btnInputNewName.setVisible(true);
//				btnInputLogin.setVisible(false);
			}
		});


		btnInputNewName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create player in player model			
				String name = inputID.getText();
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(myLoginPanel, " please input ID");
					
				}else {
				TriviaMaze.myPlayerGroup12.setMyID(name);
				JOptionPane.showMessageDialog(myFrame,"Have Fun " + TriviaMaze.myPlayerGroup12.getMyID());
				myLoginPanel.setVisible(false);
				createMenuPanel();	
				}
			}
		});
		
//		btnLogin.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			inputID.setVisible(true);
//			btnInputNewName.setVisible(false);
//			btnInputLogin.setVisible(true);
//		}
//	});
//		btnInputLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String name = inputID.getText();
//				myLoginPanel.setVisible(false);
//				String nameLogin = inputID.getText();
//				TriviaMaze.myPlayerGroup12.setMyID(nameLogin);
//				JOptionPane.showMessageDialog(myFrame, TriviaMaze.myPlayerGroup12.getMyID());
//				createMenuPanel();
//
//				
//				
//
//			}
//		});
		

	}
	
	/**
	 * create a MenuPanel
	 */
	public static void createMenuPanel() {

		JPanel myMenuPanel = new JPanel();
		myMenuPanel.setBounds(100, 100, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
		myMenuPanel.setLayout(null);
		layeredPane.add(myMenuPanel);
		myMenuPanel.setVisible(true);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(300, 150, 100, 30);
		myMenuPanel.add(btnNewGame);

		JButton btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setBounds(300, 200, 100, 30);
		myMenuPanel.add(btnResumeGame);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Time New Roman", Font.PLAIN, 16));
		lblLevel.setBounds(350, 250, 46, 14);
		myMenuPanel.add(lblLevel);
		
		Choice choice = new Choice();
		choice.setBounds(450, 250, 100, 30);
		choice.add("Easy");
		choice.add("Medium");
		choice.add("Hard");
		myMenuPanel.add(choice);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TriviaMaze.getNewMap();			
				myMazePanel = new MazePanel();
//				myMazePanel.setBounds(100, 100, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
				layeredPane.add(myMazePanel);
				
				

				myMenuPanel.setVisible(false);
				

			}
		});
		
		btnResumeGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if( TriviaMaze.myPlayerGroup12.getMyGraph() == null) {
					JOptionPane.showMessageDialog(myMenuPanel,"No save game");
				} else {
				myMazePanel = new MazePanel();
				myMazePanel.setBounds(100, 100, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
//				layeredPane.add(myMazePanel);
				layeredPane.add(layeredPane, BorderLayout.CENTER);

				myMenuPanel.setVisible(false);
				}

			}
		});
		
		
		
	}
}
