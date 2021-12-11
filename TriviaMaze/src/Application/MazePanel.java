package Application;

import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import java.awt.*;
import Application.*;

public class MazePanel extends JPanel implements ActionListener {

	private Timer timer;
	private int Size = 32;
	private char[][] Graph;
	private int Row;
	private int Col;
	private Player p;

	private static ImageIcon img;
	private Image DoorReady;
	private Image Entrange;
	private Image Exit;
	private Image Player;
	private Image RoomClose;
	private Image RoomOpen;
	private Image Street;
	private Image Wall;

	public MazePanel() {
		p = new Player();
		addKeyListener(new Al());
		setFocusable(true);
		timer = new Timer(10, this);
		timer.start();
		getImage();
		getMap();

	}

	public void getMap() {
		Graph = null;
		Row = Graph.length;
		Col = Graph[0].length;
	}

	public void getImage() {
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\DoorReady.png");
		DoorReady = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Entrange.png");
		Entrange = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Exit.png");
		Exit = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Player.png");
		Player = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\RoomClose.png");
		RoomClose = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\RoomOpen.png");
		RoomOpen = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Street.png");
		Street = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Wall.png");
		Wall = img.getImage();

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
				g.drawImage(p.getPlayerImage(), p.getCol()*Size, p.getRow()*Size, Size, Size, null);

			}
		}

	}
	
	public class Al extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W) {
				p.moveUp();
			}
			if (keyCode == KeyEvent.VK_S) {
				p.moveDown();

			}
			if (keyCode == KeyEvent.VK_A) {
				p.moveLeft();

			}
			if (keyCode == KeyEvent.VK_D) {
				p.moveRight();

			}

		}

	}

}
