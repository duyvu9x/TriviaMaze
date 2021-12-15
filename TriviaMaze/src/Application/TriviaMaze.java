package Application;

import javax.swing.*;

import GUI.TriviaMazeGUI;
import Model.Player;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TriviaMaze {

	public static Player myPlayerGroup12 = new Player();
	
	public static Scanner inputFile;
	

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriviaMazeGUI window = new TriviaMazeGUI();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public static void openFile() {
		try {
			inputFile = new Scanner(new File("map\\easy\\easy_map1.txt"));
			
		}catch(Exception e) {
			System.out.println("Can not find file");
		}
	}
	
	// load map , entrange point for player.
	public static void getNewMap() {
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
			myPlayerGroup12.setRow(inputFile.nextInt()) ;
			myPlayerGroup12.setCol(inputFile.nextInt());
		}
		
		myPlayerGroup12.setMyGraph(Map);
			
		
	}
	
	
	
	

}
