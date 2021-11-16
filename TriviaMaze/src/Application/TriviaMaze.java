package Application;

import java.util.Scanner;

public class TriviaMaze {
	private static int ROWS;
	private static int COLUMNS;
	
	public static void main(String[] args) {
		
		int[][] maze = new int[ROWS][COLUMNS];
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Select the size of the maze (a-b): ");
		String mazeOption = s.next();
		
		switch( mazeOption ) {
			case "a": case "A":
				ROWS = 4;
				COLUMNS = 4;
				break;
				
			case "b" : case "B":
				ROWS = 6;
				COLUMNS = 6;
				break;
				
			case "c" : case "C":
				ROWS = 10;
				COLUMNS = 10;
				break;
			
			default:
				System.out.println("INVALID OPTION");
				break;
		}
		
		int playerXpos = 0;
		int playerYpos = 0;
		
		while( playerXpos != ROWS-1 || playerYpos != COLUMNS-1 ) {		//  while the game is not over -> continue
			System.out.println( "Select a position to move" );
			System.out.println( "");
		}
//		System.out.println(ROWS);
//		System.out.println(COLUMNS);
		
		
		
	}
	
	public int[][] generateMaze( int rows , int columns , int Xpos , int Ypos  ) {
		
		// the maze is full of zeros
		//  the number one will represent the player
		
		
		
		
		//return maze;
	}
}
