package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ColorUIResource;

import model.Terrain;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame {

//	private JFrame frame;
//	private static JPanel panel ;
//	private static final int SCREEN_WIDTH = 450;
//	private static final int SCREEN_HEIGHT = 280;
//	private static Terrain[][] myMap;
//	private static final int SQUARE_SIZE = 40;
//	private static final BasicStroke STROKE =
//            new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2,
//                            new float[] {2, 2, 2, 2}, 0);
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Start window = new Start();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Start() {
//		mainDisplay();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void mainDisplay() { }
//
//	private void drawMap(final Graphics2D theGraphics) {
//       for (int y = 0; y < myMap.length; y++) {
//           final int topy = y * SQUARE_SIZE;
//
//           for (int x = 0; x < myMap[y].length; x++) {
//               final int leftx = x * SQUARE_SIZE;
//
//               switch (myMap[y][x]) {
//                   case STREET:
//                       theGraphics.setPaint(Color.LIGHT_GRAY);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;
//
//                   case WALL:
//                       theGraphics.setPaint(Color.BLACK);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;
//                   case ENTRANCE:
//                       theGraphics.setPaint(Color.BLACK);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;
//                   case EXIT:
//                       theGraphics.setPaint(Color.BLACK);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;
//                   case ROOMOPEN:
//                       theGraphics.setPaint(Color.BLACK);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;
//                   case ROOMCLOSE:
//                       theGraphics.setPaint(Color.BLACK);
//                       theGraphics.fillRect(leftx, topy, SQUARE_SIZE, SQUARE_SIZE);
//                       break;             
//
//                   default:
//               }
//
//      
//           }
//       }
//   }
	
	
	private static final String CITY_FILE = "easy_map1.txt";
	private int[][] map = {  
			{1,1,1,1,1,1,1,1,1,1},
			{0,0,0,1,1,1,0,1,0,1},
			{1,1,0,1,1,1,1,1,1,1},
			{1,1,0,1,1,1,1,1,1,1},
			{1,1,0,0,0,1,1,1,1,1},
			{1,1,1,1,0,1,1,1,1,1},
	};
	private static Terrain[][] maze ;
	
	
	public static void readGrid() throws FileNotFoundException {
		File text = new File("C:\\Users\\david\\eclipse-workspace\\Final Project TCSS360A\\map\\easy_map1.txt");
		Scanner theInput = new Scanner(text);
        final int numRows = theInput.nextInt();
        final int numColumns = theInput.nextInt();
        theInput.nextLine();
        maze = new Terrain[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            final String line = theInput.nextLine();
            for (int column = 0; column < numColumns; column++) {
            	maze[row][column] = Terrain.valueOf(line.charAt(column));
            }
        }
    }

	
	public Start() {
		
		setTitle("example maze");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint ( Graphics g) {
		super.paint(g);
		
		for( int row = 0 ; row < maze.length ; row++) {
			for( int col = 0 ; col < maze[0].length;col++) {
				Color color;
				switch (maze[row][col]) {
				case WALL : color = Color.BLACK; break;
				case STREET : color = Color.WHITE; break;
				case ENTRANCE : color = Color.RED; break;
				case EXIT : color = Color.ORANGE; break;
				case ROOMOPEN : color = Color.YELLOW; break;
				case ROOMCLOSE : color = Color.RED; break;
				default : color = Color.BLACK; 
				break;
				}
				g.setColor(color);
				g.fillRect(30 * col , 30 * row , 30, 30);
				g.setColor(Color.BLACK);
				g.drawRect(30 * col , 30 * row , 30, 30);
			}
		}
		
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		readGrid();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Start start = new Start();
				start.setVisible(true);
				
			}
		});
	}
	
	
	
	
	public Terrain[][] changeMaze(int[][] map){
		Terrain[][] maze = new Terrain[map.length][map[0].length];
		for( int i = 0 ; i< map.length ; i++) {
			for( int j = 0 ; j< map[0].length ; j++) {
				int a = map[i][j];
				if(a == 0 ) {
					maze[i][j] = Terrain.STREET;
				} else {
					maze[i][j] = Terrain.WALL;
				}
			}
		}
		return maze;
	}
	
}
