package Application;

import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import Application.*;
import Application.TriviaMazeGUI;

public class MazePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ImageIcon img;
	private Image DoorReady;
	private Image Entrange;
	private Image Exit;
	private Image RoomClose;
	private Image RoomOpen;
	private Image Street;
	private Image Wall;

	private Timer timer;
	private int Size = 32;

	private char[][] Graph;
	private int Row;
	private int Col;
	private Player p;

	public MazePanel() {
		timer = new Timer(10, this);
		timer.start();
		p = TriviaMaze.myPlayerGroup12;

		Graph = p.getMyGraph();
		Row = Graph.length;
		Col = Graph[0].length;

		addKeyListener(new Al());
		setFocusable(true);
		getImage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {

				switch (Graph[i][j]) {
				case '#': {

					g.drawImage(Wall, j * Size, i * Size, Size, Size, null);
					break;
				}
				case 's': {

					g.drawImage(Entrange, j * Size, i * Size, Size, Size, null);
					break;
				}
				case '-': {

					g.drawImage(Street, j * Size, i * Size, Size, Size, null);
					break;

				}
				case 'e': {

					g.drawImage(Exit, j * Size, i * Size, Size, Size, null);
					break;
				}
				case 'r': {

					g.drawImage(DoorReady, j * Size, i * Size, Size, Size, null);
					break;
				}
				case '|': {

					g.drawImage(RoomClose, j * Size, i * Size, Size, Size, null);
					break;
				}
				case '/': {

					g.drawImage(RoomOpen, j * Size, i * Size, Size, Size, null);
					break;
				}

				default:
					break;

				}
				g.drawImage(p.getPlayerImage(), p.getCol() * Size, p.getRow() * Size, Size, Size, null);

			}
		}

	}

	public class Al extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W && canGo(p.getRow() - 1, p.getCol())) {
				p.moveUp();
			}
			if (keyCode == KeyEvent.VK_S && canGo(p.getRow() + 1, p.getCol())) {
				p.moveDown();

			}
			if (keyCode == KeyEvent.VK_A && canGo(p.getRow(), p.getCol() - 1)) {
				p.moveLeft();

			}
			if (keyCode == KeyEvent.VK_D && canGo(p.getRow(), p.getCol() + 1)) {
				p.moveRight();

			}

			challenge();
		}

	}

	public Boolean canGo(int row, int col) {
		if (row < 0 || row >= Row || col < 0 || col >= Col || Graph[row][col] == '#' || Graph[row][col] == '|') {
			return false;
		}

		return true;
	}

	public void challenge() {
		if (Graph[p.getRow()][p.getCol()] == '/') {
			String[] possibilities = {"ham", "spam", "yam"};
			
			String s = (String)JOptionPane.showInputDialog(
			                    null,
			                    "Complete the sentence:\n"
			                    + possibilities[0],
			                    "Customized Dialog",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities,
			                    "ham");
			if(s.equals("ham")) {
				JOptionPane.showMessageDialog(null,"cottrcnet");
				
			}

		
		}
		if (Graph[p.getRow()][p.getCol()] == 'e') {
			JOptionPane.showConfirmDialog(getComponentPopupMenu(), "Exit");
			p.setMyGraph(null);
			TriviaMazeGUI.myMazePanel.setVisible(false);
			TriviaMazeGUI.createMenuPanel();

		}

	}

	public void getImage() {
		img = new ImageIcon("icon\\DoorReady.png");
		DoorReady = img.getImage();
		img = new ImageIcon("icon\\Entrange.png");
		Entrange = img.getImage();
		img = new ImageIcon("icon\\Exit.png");
		Exit = img.getImage();
		img = new ImageIcon("icon\\RoomClose.png");
		RoomClose = img.getImage();
		img = new ImageIcon("icon\\RoomOpen.png");
		RoomOpen = img.getImage();
		img = new ImageIcon("icon\\Street.png");
		Street = img.getImage();
		img = new ImageIcon("icon\\Wall.png");
		Wall = img.getImage();

	}

}
