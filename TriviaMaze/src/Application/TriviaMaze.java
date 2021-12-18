package Application;

import GUI.TriviaMazeGUI;

import Model.Player;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class to run the program
 * 
 * @author Duy Vu
 * @version Autumn 2021
 */

public final class TriviaMaze {
	/**
	 * create player for game.
	 */
	public static Player myPlayerGroup12;
	/**
	 * Scanner Input File
	 */
	public static Scanner myInputFile;

	/**
	 * declare player and run Framer.
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {
		myPlayerGroup12 = new Player();
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

	/**
	 * open file by level.
	 */
	public static void openFile() {
		File dir = new File("map//" + TriviaMaze.myPlayerGroup12.getLevel());
		String[] triG = dir.list();
		Collections.shuffle(Arrays.asList(triG));
		System.out.println(triG[0]);

		String path = "map//" + TriviaMaze.myPlayerGroup12.getLevel() + "//" + triG[0];

		try {
			myInputFile = new Scanner(new File(path));

		} catch (Exception e) {
			System.out.println("Can not find file");
		}
	}

	/**
	 * update map for player.
	 */
	public static void getNewMap() {
		openFile();
		int Row, Col;
		char[][] Map = null;
		while (myInputFile.hasNext()) {
			Row = myInputFile.nextInt();
			Col = myInputFile.nextInt();
			Map = new char[Row][Col];
			for (int i = 0; i < Row; i++) {
				String str = myInputFile.next();
				for (int j = 0; j < Col; j++) {
					Map[i][j] = str.charAt(j);

				}
			}
			myPlayerGroup12.setRow(myInputFile.nextInt());
			myPlayerGroup12.setCol(myInputFile.nextInt());
		}

		myPlayerGroup12.setMyGraph(Map);

	}

}
