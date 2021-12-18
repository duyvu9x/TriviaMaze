package GUI;

import javax.swing.*;

import Application.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Application.*;

/**
 * Class create GUI.
 * 
 * @author Duy Vu
 * @version Autumn 2021
 */
public class TriviaMazeGUI {
	/**
	 * Width size of frame.
	 */
	public static final int WIDTH_SIZE = 1000;
	/**
	 * Height size of frame.
	 */
	public static final int HEIGHT_SIZE = 800;

	/**
	 * Width size of panel.
	 */
	public static final int WIDTH_PANEL_SIZE = 800;
	/**
	 * Height size of panel.
	 */
	public static final int HEIGHT_PANEL_SIZE = 600;
	/**
	 * declare main Frame.
	 */
	public static JFrame myFrame;
	/**
	 * declare to control Panel.
	 */
	public static JLayeredPane layeredPane;
	/**
	 * declare login panel.
	 */
	public JPanel myLoginPanel;
	/**
	 * declare MenuPanel
	 */
	public static JPanel myMenuPanel;
	/**
	 * declare Maze Panel.
	 */
	public static JPanel myMazePanel;
	
	private String myAbout;
	private String myRuler;
	private String myCheats;

//	public  JTextField inputID;
//	private ImageIcon backGroundImage; 
//	private JLabel Background;

	/**
	 * Create the application.
	 */
	public TriviaMazeGUI() {
		startGame();
		readInstrutor();

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
		createMenuBar();

		layeredPane = new JLayeredPane();
		myFrame.getContentPane().add(layeredPane);
		createLoginPanel();
	}
	/**
	 * create instructor for Game.
	 */
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		myFrame.getContentPane().add(menuBar);
		myFrame.getContentPane().add(BorderLayout.NORTH, menuBar);

		JMenu meFile = new JMenu("File");
		JMenu meHelp = new JMenu("Help");
		menuBar.add(meFile);
		menuBar.add(meHelp);
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
		mntmAbout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(myFrame, myAbout);
				
			}
		});
		mntmPlayRule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(myFrame, myRuler);
				
			}
		});
		mntmCheats.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(myFrame, myCheats);
				
			}
		});
		
		
	}
	/**
	 * read file to instructor
	 * 
	 */
	public void readInstrutor() {
		 Scanner scanner = null;
		try {
		    // open file to read
			scanner = new Scanner(new File("instructor\\about.txt"));

		    // read until end of file (EOF)
		    while (scanner.hasNextLine()) {
		        myAbout += scanner.nextLine() + "\n";
		    }

		        
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
		try {
		    // open file to read
		   scanner = new Scanner(new File("instructor\\gamePlayInstructions.txt"));

		    // read until end of file (EOF)
		    while (scanner.hasNextLine()) {
		    	myRuler += scanner.nextLine() + "\n";
		    }

		        
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
		try {
		    // open file to read
		  scanner = new Scanner(new File("instructor\\cheats.txt"));

		    // read until end of file (EOF)
		    while (scanner.hasNextLine()) {
		    	myCheats +=scanner.nextLine() +  "\n";
		    }

		        
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		}
	    // close the scanner
	    scanner.close();
	}

	/**
	 * Function to create components of Login Panel.
	 */
	public void createLoginPanel() {

		// create loginPanel
		myLoginPanel = new JPanel();
		myLoginPanel.setBounds(100, 35, WIDTH_PANEL_SIZE, HEIGHT_PANEL_SIZE);
		layeredPane.add(myLoginPanel);

		// create new player button
		JButton btnNewPlayer = new JButton("New Player");
		btnNewPlayer.setBounds(200, 100, 115, 35);

		// create textFile to get name player
		JTextField inputID = new JTextField();
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
				if (name.isEmpty()) {
					JOptionPane.showMessageDialog(myLoginPanel, " please input ID");

				} else {
					TriviaMaze.myPlayerGroup12.setMyID(name);
					JOptionPane.showMessageDialog(myFrame, "Have Fun " + TriviaMaze.myPlayerGroup12.getMyID());
					myLoginPanel.setVisible(false);
					createMenuPanel();
				}
			}
		});

	}

	/**
	 * Function to create components of Menu Panel.
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

		JButton resumeGameButton = new JButton("Load Game");
		resumeGameButton.setBounds(300, 200, 100, 30);
		myMenuPanel.add(resumeGameButton);

		JButton levelButton = new JButton("Level");
		levelButton.setBounds(300, 250, 100, 30);
		myMenuPanel.add(levelButton);

		JButton instructionButton = new JButton("instruction");
		instructionButton.setBounds(300, 300, 100, 30);
		myMenuPanel.add(instructionButton);

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
				if (TriviaMaze.myPlayerGroup12.getMyGraph() == null) {
					JOptionPane.showMessageDialog(myMenuPanel, "No save game");
				} else {
					myMazePanel = new MazePanel();
					layeredPane.add(myMazePanel);
					myMenuPanel.setVisible(false);

				}

			}
		});
		levelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] level = { "Easy", "Medium", "Hard" };
				String s = (String) JOptionPane.showInputDialog(myFrame, null, "Level Graph", JOptionPane.PLAIN_MESSAGE,
						null, level, "Easy");

				// If a string was returned, say so.
				if (s.equals("Easy")) {
					TriviaMaze.myPlayerGroup12.setLevel("Easy");
				}
				if (s.equals("Medium")) {
					TriviaMaze.myPlayerGroup12.setLevel("Medium");
				}
				if (s.equals("Hard")) {
					TriviaMaze.myPlayerGroup12.setLevel("Hard");
				}

			}
		});

	}
}
