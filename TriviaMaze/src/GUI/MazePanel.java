package GUI;

import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import Application.*;
import Model.Player;

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
	private final int CELL_WIDTH = 40;
	private final int CELL_HEIGHT = 40;


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
		setSize(CELL_WIDTH * Col,CELL_HEIGHT * Row);

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

					g.drawImage(Wall, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case 'S': {

					g.drawImage(Entrange, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '-': {

					g.drawImage(Street, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;

				}
				case 'E': {

					g.drawImage(Exit, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case 'r': {

					g.drawImage(DoorReady, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '|': {

					g.drawImage(RoomClose, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '/': {

					g.drawImage(RoomOpen, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}

				default:
					break;

				}
				g.drawImage(p.getPlayerImage(), p.getCol() * CELL_WIDTH, p.getRow() * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);

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

			try {
				challenge();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public Boolean canGo(int row, int col) {
		if (row < 0 || row >= Row || col < 0 || col >= Col || Graph[row][col] == '#' || Graph[row][col] == '|') {
			return false;
		}

		return true;
	}

	public String[] getListQuestion() throws SQLException {
		ArrayList<String>  checkcode = new ArrayList<>();
        checkcode = sql.Question_Answer.getQuestion();
        
        String[] list = new String[checkcode.size()];
        for( int i = 0 ; i < list.length ; i ++) {
        	list[i] = checkcode.get(i);
        }
        return list;
	}
	
	public void challenge() throws SQLException {
		if (Graph[p.getRow()][p.getCol()] == '/') {
			
			String[] possibilities = getListQuestion();
			
			String s = (String)JOptionPane.showInputDialog(
			                    null,
			                    "Complete the sentence:\n"
			                    + possibilities[0],
			                    "Customized Dialog",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities,
			                    possibilities[2]);
			
			
			if(s.equals("ham")) {
				JOptionPane.showMessageDialog(null,"cottrcnet");
				
			}else {
				Graph[p.getRow()][p.getCol()] = '|';
			}

		
		}
		if (Graph[p.getRow()][p.getCol()] == 'E') {
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
