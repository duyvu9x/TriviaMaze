package GUI;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;

import Application.TriviaMaze;
import Model.*;
import GUI.*;


import java.awt.*;

public class MazePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ImageIcon img;
	private Image DoorOpen;
	private Image Entrange;
	private Image Exit;
	private Image RoomLock;
	private Image DoorClose;
	private Image Street;
	private Image Wall;

	private Timer timer;
	private final int CELL_WIDTH = 40;
	private final int CELL_HEIGHT = 40;


	private static char[][] Graph;
	private int Row;
	private int Col;
	private static Player p;

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
		
		JButton SaveButton = new JButton("Save");
		SaveButton.setBounds(822, 679, 89, 23);
	    TriviaMazeGUI.layeredPane.add(SaveButton);
		SaveButton.setVisible(true);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(693, 679, 89, 23);
		TriviaMazeGUI.layeredPane.add(ExitButton);
		ExitButton.setVisible(true);
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TriviaMazeGUI.myMenuPanel.setVisible(true);
				TriviaMazeGUI.myMazePanel.setVisible(false);
				SaveButton.setVisible(false);
				ExitButton.setVisible(false);
				
			}
		});
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TriviaMazeGUI.myMenuPanel.setVisible(true);
				TriviaMazeGUI.myMazePanel.setVisible(false);
				p.setMyGraph(null);
				SaveButton.setVisible(false);
				ExitButton.setVisible(false);
				
			}
		});
		
		
		

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
				case 'R': {

					g.drawImage(DoorOpen, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '|': {

					g.drawImage(RoomLock, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '/': {

					g.drawImage(DoorClose, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
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
				p.setPreCol(p.getCol());
				p.setPreRow(p.getRow());	
				p.moveUp();
			}
			if (keyCode == KeyEvent.VK_S && canGo(p.getRow() + 1, p.getCol())) {
				p.setPreCol(p.getCol());
				p.setPreRow(p.getRow());
				p.moveDown();

			}
			if (keyCode == KeyEvent.VK_A && canGo(p.getRow(), p.getCol() - 1)) {
				p.setPreCol(p.getCol());
				p.setPreRow(p.getRow());
				p.moveLeft();

			}
			if (keyCode == KeyEvent.VK_D && canGo(p.getRow(), p.getCol() + 1)) {
				p.setPreCol(p.getCol());
				p.setPreRow(p.getRow());
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
        checkcode = Model.Question_Answer.getQuestion();
        
        String[] list = new String[checkcode.size()];
        for( int i = 0 ; i < list.length ; i ++) {
        	list[i] = checkcode.get(i);
        }
        return list;
	}
	
	public void challenge() throws SQLException {
		if (Graph[p.getRow()][p.getCol()] == '/') {
			String[] possibilities = getListQuestion();
			String[] options = {possibilities[2],possibilities[3],possibilities[4]};
			
			String s = (String)JOptionPane.showInputDialog(
					TriviaMazeGUI.layeredPane,
			                    "Question\n"
			                    + possibilities[0],
			                    "Customized Dialog",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    options,
			                    possibilities[1]);
			
			
			if(s.equals(possibilities[1])) {
				JOptionPane.showMessageDialog(null,"correct");
				Graph[p.getRow()][p.getCol()] = 'R';
				
			}else {
				Graph[p.getRow()][p.getCol()] = '|';
				p.setCol(p.getPreCol());
				p.setRow(p.getPreRow());
//				if(!Model.Question_Answer.checkWay(p.getRow(), p.getCol(), Graph)) {
//					System.out.print("true");
//				}
				
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
		img = new ImageIcon("icon\\DoorClose.png");
		DoorClose = img.getImage();
		img = new ImageIcon("icon\\Entrange.png");
		Entrange = img.getImage();
		img = new ImageIcon("icon\\Exit.png");
		Exit = img.getImage();
		img = new ImageIcon("icon\\RoomLock.png");
		RoomLock = img.getImage();
		img = new ImageIcon("icon\\DoorOpen.png");
		DoorOpen = img.getImage();
		img = new ImageIcon("icon\\Street.png");
		Street = img.getImage();
		img = new ImageIcon("icon\\Wall.png");
		Wall = img.getImage();

	}

}
