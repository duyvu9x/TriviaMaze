package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Application.*;
import Model.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TriviaMazeGUI {
	
	public static final int WIDTH_SIZE = 1000;
	public static final int HEIGHT_SIZE = 800;
	
	public static final int WIDTH_PANEL_SIZE = 800;
	public static final int HEIGHT_PANEL_SIZE = 600;

	public static JFrame myFrame;
	public static JLayeredPane layeredPane;
	
	public  JPanel myLoginPanel;
	
	public  static JPanel myMenuPanel;
	
	
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
//		myFrame.getContentPane().add(Background);
//		Background.setVisible(true);
		
		layeredPane = new JLayeredPane();
		myFrame.getContentPane().add(layeredPane);
		createLoginPanel();
	}

	public void createLoginPanel() {

		// create loginPanel
		myLoginPanel = new JPanel();
		myLoginPanel.setBounds(100, 35, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
		layeredPane.add(myLoginPanel);

		// create new player button
		JButton btnNewPlayer = new JButton("New Player");
		btnNewPlayer.setBounds(200, 100, 115, 35);

		// create textFile to get name player
		inputID = new JTextField();
		inputID.setBounds(375, 100, 115, 35);
		inputID.setColumns(20);
		inputID.setVisible(false);

		JButton btnInputNewName = new JButton("OK");
		btnInputNewName.setBounds(386, 167, 89, 23);
		btnInputNewName.setVisible(false);
		
		
		// add component to myLoginPanel
		myLoginPanel.setLayout(null);
		myLoginPanel.add(btnNewPlayer);
		myLoginPanel.add(inputID);
		myLoginPanel.add(btnInputNewName);
		myLoginPanel.setVisible(true);
		
		
		
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputID.setVisible(true);
				btnInputNewName.setVisible(true);
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
	
	}
	
	/**
	 * create a MenuPanel
	 */
	public static void createMenuPanel() {

		 myMenuPanel = new JPanel();
		myMenuPanel.setBounds(100, 100, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
		myMenuPanel.setLayout(null);
		layeredPane.add(myMenuPanel);
		myMenuPanel.setVisible(true);

		JButton NewGameButton = new JButton("New Game");
		NewGameButton.setBounds(300, 150, 100, 30);
		myMenuPanel.add(NewGameButton);

		JButton resumeGameButton = new JButton("Resume Game");
		resumeGameButton.setBounds(300, 200, 100, 30);
		myMenuPanel.add(resumeGameButton);
		
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
		
	

		
		
		
		NewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TriviaMaze.getNewMap();			
				myMazePanel = new MazePanel();
				layeredPane.add(myMazePanel);
				myMenuPanel.setVisible(false);

				
				

			}
		});
			
		resumeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if( TriviaMaze.myPlayerGroup12.getMyGraph() == null) {
					JOptionPane.showMessageDialog(myMenuPanel,"No save game");
				} else {
					myMazePanel = new MazePanel();
					layeredPane.add(myMazePanel);
					myMenuPanel.setVisible(false);


				}

			}
		});

			
	}
}
