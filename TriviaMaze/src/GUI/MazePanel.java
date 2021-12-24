package GUI;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import Application.TriviaMaze;
import Model.*;
import java.awt.*;

/**
 * Class create MAze and follow action move.
 * 
 * @author Duy Vu
 * @version Autumn 2021
 */
public class MazePanel extends JPanel implements ActionListener {
	/**
	 * @
	 */
	private static final long serialVersionUID = 112934893L;

	private static ImageIcon myImg;
	private Image myDoorOpen;
	private Image myEntrange;
	private Image myExit;
	private Image myRoomLock;
	private Image myDoorClose;
	private Image myStreet;
	private Image myWall;

	private Timer myTimer;
	private final int CELL_WIDTH = 40;
	private final int CELL_HEIGHT = 40;

	private static char[][] myGraph;
	private int myRow;
	private int myCol;
	private static Player myPlayer;
	private JButton mySaveButton;
//	private JButton myExitButton;

	public MazePanel() {
		myTimer = new Timer(10, this);
		myTimer.start();
		myPlayer = TriviaMaze.myPlayerGroup12;
		myGraph = myPlayer.getMyGraph();

		myRow = myGraph.length;
		myCol = myGraph[0].length;
		setSize(CELL_WIDTH * myCol, CELL_HEIGHT * myRow);
		addKeyListener(new Al());
		setFocusable(true);
		getImage();

		mySaveButton = new JButton("Save");
		mySaveButton.setBounds(822, 679, 89, 23);
		TriviaMazeGUI.layeredPane.add(mySaveButton);
		mySaveButton.setVisible(true);

//		myExitButton = new JButton("Exit");
//		myExitButton.setBounds(693, 679, 89, 23);
//		TriviaMazeGUI.layeredPane.add(myExitButton);
//		myExitButton.setVisible(true);
		mySaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TriviaMazeGUI.myMenuPanel.setVisible(true);
				TriviaMazeGUI.myMazePanel.setVisible(false);
				mySaveButton.setVisible(false);
//				myExitButton.setVisible(false);

			}
		});
//		myExitButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TriviaMazeGUI.myMenuPanel.setVisible(true);
//				TriviaMazeGUI.myMazePanel.setVisible(false);
//				myPlayer.setMyGraph(null);
//				mySaveButton.setVisible(false);
//				myExitButton.setVisible(false);
//
//			}
//		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < myRow; i++) {
			for (int j = 0; j < myCol; j++) {

				switch (myGraph[i][j]) {
				case '#': {

					g.drawImage(myWall, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case 'S': {

					g.drawImage(myEntrange, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '-': {

					g.drawImage(myStreet, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;

				}
				case 'E': {

					g.drawImage(myExit, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case 'R': {

					g.drawImage(myDoorOpen, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '|': {

					g.drawImage(myRoomLock, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}
				case '/': {

					g.drawImage(myDoorClose, j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, null);
					break;
				}

				default:
					break;

				}
				g.drawImage(myPlayer.getPlayerImage(), myPlayer.getCol() * CELL_WIDTH, myPlayer.getRow() * CELL_HEIGHT,
						CELL_WIDTH, CELL_HEIGHT, null);

			}
		}

	}

	public class Al extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W && myPlayer.canGo(myPlayer.getRow() - 1, myPlayer.getCol())) {
				myPlayer.setPreCol(myPlayer.getCol());
				myPlayer.setPreRow(myPlayer.getRow());
				myPlayer.moveUp();
			}
			if (keyCode == KeyEvent.VK_S && myPlayer.canGo(myPlayer.getRow() + 1, myPlayer.getCol())) {
				myPlayer.setPreCol(myPlayer.getCol());
				myPlayer.setPreRow(myPlayer.getRow());
				myPlayer.moveDown();

			}
			if (keyCode == KeyEvent.VK_A && myPlayer.canGo(myPlayer.getRow(), myPlayer.getCol() - 1)) {
				myPlayer.setPreCol(myPlayer.getCol());
				myPlayer.setPreRow(myPlayer.getRow());
				myPlayer.moveLeft();

			}
			if (keyCode == KeyEvent.VK_D && myPlayer.canGo(myPlayer.getRow(), myPlayer.getCol() + 1)) {
				myPlayer.setPreCol(myPlayer.getCol());
				myPlayer.setPreRow(myPlayer.getRow());
				myPlayer.moveRight();

			}

			try {
				challenge();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public String[] getListQuestion() throws SQLException {
		ArrayList<String> checkcode = new ArrayList<>();
		checkcode = Model.Question_Answer.getQuestion();

		String[] list = new String[checkcode.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = checkcode.get(i);
		}
		return list;
	}

	public void challenge() throws SQLException {
		if (myGraph[myPlayer.getRow()][myPlayer.getCol()] == '/') {
			String[] possibilities = getListQuestion();
			String[] options = { possibilities[2], possibilities[3], possibilities[4] };

			String s = (String) JOptionPane.showInputDialog(TriviaMazeGUI.layeredPane, "Question\n" + possibilities[0],
					"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, options, possibilities[1]);

			if (s.equals(possibilities[1])) {
				JOptionPane.showMessageDialog(TriviaMazeGUI.layeredPane, "correct");
				myGraph[myPlayer.getRow()][myPlayer.getCol()] = 'R';

			} else {
				myGraph[myPlayer.getRow()][myPlayer.getCol()] = '|';
				myPlayer.setCol(myPlayer.getPreCol());
				myPlayer.setRow(myPlayer.getPreRow());
				if (myPlayer.checkHaveWay(myPlayer.getPreRow(), myPlayer.getPreCol()) == false) {
					JOptionPane.showMessageDialog(TriviaMazeGUI.myFrame, myPlayer.getMyID() + " No way to go");

					TriviaMazeGUI.myMazePanel.setVisible(false);
					TriviaMazeGUI.myMenuPanel.setVisible(true);
					mySaveButton.setVisible(false);
//					myExitButton.setVisible(false);
				}

			}

		}
		if (myGraph[myPlayer.getRow()][myPlayer.getCol()] == 'E') {
			JOptionPane.showConfirmDialog(getComponentPopupMenu(), "Exit");
			myPlayer.setMyGraph(null);
			TriviaMazeGUI.myMazePanel.setVisible(false);
			TriviaMazeGUI.createMenuPanel();

		}

	}

	public void getImage() {
		myImg = new ImageIcon("icon\\DoorClose.png");
		myDoorClose = myImg.getImage();
		myImg = new ImageIcon("icon\\Entrange.png");
		myEntrange = myImg.getImage();
		myImg = new ImageIcon("icon\\Exit.png");
		myExit = myImg.getImage();
		myImg = new ImageIcon("icon\\RoomLock.png");
		myRoomLock = myImg.getImage();
		myImg = new ImageIcon("icon\\DoorOpen.png");
		myDoorOpen = myImg.getImage();
		myImg = new ImageIcon("icon\\Street.png");
		myStreet = myImg.getImage();
		myImg = new ImageIcon("icon\\Wall.png");
		myWall = myImg.getImage();

	}

}
