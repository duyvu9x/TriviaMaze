package Application;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class LoadMaze {

	private static final String ID = "DuyVu";

	private static char[][] map = new char[][] { { 'S', '-', '#', '#' }
											   , { '#', '-', '#', '#' },
											     { '#', 'R', '#', '#' },
		                                         { '#', '-', '-', 'E' } };

	private static Player p1;

	private LoadMaze() {

	}

	public static void main(String[] args) {
		p1 = new Player(ID, 0, 0, 5,map);
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			char intput = sc.next().charAt(0);
			if(intput == 'U') {
				p1.goUp();
			}
			if(intput == 'D') {
				p1.goDown();
			}
			if(intput == 'R') {
				p1.goRight();
			}
			if(intput == 'L') {
				p1.goLeft();
			}
			
			System.out.println(p1.getRow()+" " + p1.getCol());
			if(map[p1.getRow()][p1.getCol()] == 'E') {
				System.out.println("find exit");
				break;
			}
			if(map[p1.getRow()][p1.getCol()] == 'R') {
				// do some-thing
			}
			
			
		}
		
	}

}
