package Application;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class MazeLocal {
	private static Scanner inputFile;

	
	public static void openFile() {
		try {
			inputFile = new Scanner(new File("C:\\Users\\david\\eclipse-workspace\\TriviaMazeGroup12\\map\\easy_map1.txt"));
			
		}catch(Exception e) {
			System.out.println("Can not find file");
		}
	}
	
	public char[][] readFile() {
		int Row;
		int Col;
		char[][] Map = null ;
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
