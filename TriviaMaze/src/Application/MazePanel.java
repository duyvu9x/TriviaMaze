package Application;

import java.awt.event.*;
import java.io.File;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import Application.*;

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
	private int Size = 12;
	
	private  Scanner inputFile;
	
	private  char[][] Graph;
	private  int Row;
	private  int Col;
	private Player p;

	

	public MazePanel() {
		timer = new Timer(10, this);
		timer.start();
		p = TriviaMaze.myPlayerGroup12;
		
		Graph = getNewMap();
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
	
		g.setColor(Color.RED);
		g.fillRect(45,45,32 ,32);


		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {

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
	

	

	public void getImage() {
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\DoorReady.png");
		DoorReady = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Entrange.png");
		Entrange = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Exit.png");
		Exit = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Player.png");
		RoomClose = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\RoomOpen.png");
		RoomOpen = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Street.png");
		Street = img.getImage();
		img = new ImageIcon("C:\\Users\\david\\Desktop\\TriviaMazeGroup12\\icon\\Wall.png");
		Wall = img.getImage();

	}
	
	public  void openFile() {
		try {
			inputFile = new Scanner(new File("C:\\Users\\david\\Desktop\\MazeDuyVu\\MazeFinal\\map\\easy_map1.txt"));
			
		}catch(Exception e) {
			System.out.println("Can not find file");
		}
	}
	
	public  char[][] getNewMap() {
		openFile();
		int Row, Col ;
		char[][] Map = null;
		while(inputFile.hasNext()) {
			Row = inputFile.nextInt();
			Col = inputFile.nextInt();
			Map = new char[Row][Col];
			for( int i = 0 ; i < Row ; i ++) {
				String str = inputFile.next();
				for( int j = 0 ; j < Col ; j++) {
					Map[i][j] = str.charAt(j);
					
				}
			}
			int x = inputFile.nextInt();
			int y = inputFile.nextInt();
		}
		return Map;
		
		
	}

	
	
	

}








