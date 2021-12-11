package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriviaMazeGUI {
//	private JButton btbShowPanel1;
	public static JFrame myFrame;
	public JLayeredPane layeredPane;
	
	public  JPanel myLoginPanel;
	
	public  JPanel myMenuPanel;
	
	public  JPanel myMazePanel;
	
	
	
	public  JTextField inputID;
	
	
	public Player playerGroup12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriviaMazeGUI window = new TriviaMazeGUI();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TriviaMazeGUI() {
		playerGroup12 = new Player();
		startGame();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void startGame() {
		myFrame = new JFrame();
		myFrame.setBounds(0, 0, 872, 725);
		myFrame.getContentPane().setBackground(Color.GRAY);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layeredPane = new JLayeredPane();
		myFrame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		createLoginPanel();
//		createMenuPanel();
//		createMazePanel();
	}

	public void createLoginPanel() {
//		layeredPane.setLayout(null);

		// create loginPanel
		myLoginPanel = new JPanel();
		myLoginPanel.setBackground(Color.LIGHT_GRAY);
		myLoginPanel.setBounds(29, 26, 302, 313);
		layeredPane.add(myLoginPanel);

		// create new player button
		JButton btnNewPlayer = new JButton("New Player");
		btnNewPlayer.setBounds(23, 58, 115, 35);

		// create login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(23, 214, 115, 33);

		// create textFile to get name player
		inputID = new JTextField();
		inputID.setBounds(175, 58, 115, 35);
		inputID.setColumns(10);
		inputID.setVisible(false);

		JButton btnInputNewName = new JButton("OK");
		btnInputNewName.setBounds(33, 104, 89, 23);
		btnInputNewName.setVisible(false);

		JButton btnInputLogin = new JButton("OK");
		btnInputLogin.setBounds(33, 272, 89, 23);
		btnInputLogin.setVisible(false);
		// add component to myLoginPanel
		myLoginPanel.setLayout(null);
		myLoginPanel.add(btnNewPlayer);
		myLoginPanel.add(btnLogin);
		myLoginPanel.add(inputID);
		myLoginPanel.add(btnInputNewName);
		myLoginPanel.add(btnInputLogin);

		myLoginPanel.setVisible(true);

		// actionlistenter for button

		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputID.setVisible(true);
				btnInputNewName.setVisible(true);
				btnInputLogin.setVisible(false);
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputID.setVisible(true);
				btnInputNewName.setVisible(false);
				btnInputLogin.setVisible(true);
			}
		});

		btnInputNewName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create player in player model
				myLoginPanel.setVisible(false);
				String name = inputID.getText();
				playerGroup12.setMyID(name);
				JOptionPane.showMessageDialog(myFrame, playerGroup12.getMyID());
				createMenuPanel();
			}
		});
		btnInputLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = inputID.getText();
				myLoginPanel.setVisible(false);
				String nameLogin = inputID.getText();
				playerGroup12.setMyID(nameLogin);
				JOptionPane.showMessageDialog(myFrame, playerGroup12.getMyID());
				
				
//				createMenuPanel();

			}
		});
		
		JPanel myMenuPanel = new JPanel();
		myMenuPanel.setBounds(440, 11, 378, 267);

		myMenuPanel.setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(164, 36, 100, 32);
		myMenuPanel.add(btnNewGame);

		JButton btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setBounds(164, 79, 100, 32);
		myMenuPanel.add(btnResumeGame);
		Choice choice = new Choice();
		choice.setBounds(164, 132, 100, 41);
		choice.add("Level");
		choice.add("Easy");
		choice.add("Medium");
		choice.add("Dificult");
		myMenuPanel.add(choice);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.getContentPane().add(new MazePanel());

			}
		});
		layeredPane.add(myMenuPanel);
		
		JPanel panel = new MazePanel();
		panel.setBounds(29, 367, 399, 273);
		layeredPane.add(panel);
		
		
		
		
		
		
		
		
		
		

	}

	public void createMenuPanel() {

//		JPanel myMenuPanel = new MenuPanel();
//		layeredPane.add(myMenuPanel);

		JPanel myMenuPanel = new JPanel();
		myMenuPanel.setBounds(230, 100, 400, 400);

		myMenuPanel.setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(164, 36, 100, 32);
		myMenuPanel.add(btnNewGame);

		JButton btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setBounds(164, 79, 100, 32);
		myMenuPanel.add(btnResumeGame);
		Choice choice = new Choice();
		choice.setBounds(164, 132, 100, 41);
		choice.add("Level");
		choice.add("Easy");
		choice.add("Medium");
		choice.add("Dificult");
		myMenuPanel.add(choice);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame.getContentPane().add(new MazePanel());

			}
		});
		layeredPane.add(myMenuPanel);

	}

	public void createMazePanel() {
		
		myFrame.getContentPane().add( new MazePanel());
		
		

//		JPanel myMenuPanel = new JPanel();
//		myMenuPanel.setBounds(230, 100, 400, 400);
//		layeredPane.add(myMenuPanel);
//		myMenuPanel.setVisible(true);
//		JButton btnInputNewName = new JButton("OK");
//		btnInputNewName.setBounds(188, 121, 89, 23);
//		btnInputNewName.setVisible(true);

	}

	public void createQuestionPanel() {

	}
}
