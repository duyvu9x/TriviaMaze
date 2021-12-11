package Application;

import Application.TriviaMazeGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuPanel extends JPanel {

	/**
	 *  avoid error
	 */
	private static final long serialVersionUID = 1L;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		createPanel();

	}
	
	public void createPanel() {	
//		setBackground(Color.WHITE);
		setBounds(230, 100, 400, 400);

		setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(164, 36, 100, 32);
		add(btnNewGame);
		
		JButton btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setBounds(164, 79, 100, 32);
		add(btnResumeGame);
		Choice choice = new Choice();
		choice.setBounds(164, 132, 100, 41);
		choice.add("Level");
		choice.add("Easy");
		choice.add("Medium");
		choice.add("Dificult");
		add(choice);
		desktopPane.setBounds(113, 179, 277, 221);
		add(desktopPane);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TriviaMazeGUI.myFrame.getContentPane().add(new MazePanel());
//				TriviaMazeGUI.myMazePanel = new MazePanel();

				
			}
		});
		
		
		
		
		
		
		

		
		

		
		
		
		
		
		
		
		
		
		
		
	}
}
