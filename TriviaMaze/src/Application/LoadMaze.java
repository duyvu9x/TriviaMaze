package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class LoadMaze {

	private static final String ID = "DuyVu";

	private static Terrain[][] map;

	private static Player p1;
	private static final String CITY_FILE = "easy_map1.txt";

	private LoadMaze() {

	}

	public static void main(String[] args) throws FileNotFoundException {
		File text = new File("C:\\Users\\david\\eclipse-workspace\\Final Project TCSS360A\\map\\easy_map1.txt");
		Scanner scmap = new Scanner(text);

		Terrain[][] map;
		map = readGrid(scmap);
		int row = scmap.nextInt();
		int col = scmap.nextInt();
		System.out.print(map.length +" "+ map[0].length);
		
//		 
		
		
		p1 = new Player(ID, row, col, 5, map);
		

		Scanner sc = new Scanner(System.in);
		while (true) {
			char comandinput = sc.next().charAt(0);
			command(comandinput);
			if (p1.getTerrain() == Terrain.EXIT) {
				break;
			}

		}
		sc.close();

	}

	public static void command(char input) {
		if (input == 'U') {
			p1.goUp();
		}
		if (input == 'D') {
			p1.goDown();
		}
		if (input == 'R') {
			p1.goRight();
		}
		if (input == 'L') {
			p1.goLeft();
		}
		System.out.println(p1.getRow() + " " + p1.getCol());
		if (map[p1.getRow()][p1.getCol()] == Terrain.EXIT) {
			System.out.println("find exit");
		}
		if (map[p1.getRow()][p1.getCol()] == Terrain.ROOMOPEN) {
			// run panel of question.

		}

	}

	private static Terrain[][] readGrid(final Scanner theInput) {
        final int numRows = theInput.nextInt();
        final int numColumns = theInput.nextInt();
        theInput.nextLine();
        final Terrain[][] grid = new Terrain[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            final String line = theInput.nextLine();
            for (int column = 0; column < numColumns; column++) {
                grid[row][column] = Terrain.valueOf(line.charAt(column));
            }
        }
        return grid;
    }

}
