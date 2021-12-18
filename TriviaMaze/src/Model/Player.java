package Model;

import java.util.Stack;
import javax.swing.*;
import java.awt.*;

/**
 * @author Duy Vu
 * @version Autumn 2021
 */

public class Player {
	private ImageIcon img = new ImageIcon("icon\\Player.png");
	private Image playerImg = img.getImage();
	/**
	 * myRow row in graph of player.
	 */
	private int myRow;
	/**
	 * myCol Col in graph of player.
	 */
	private int myCol;
	/**
	 * myPreRow row before move;
	 */
	private int myPreRow;
	/**
	 * myPreCol Col before move;
	 */
	private int myPreCol;
	/**
	 * myID id of player
	 */
	private String myID;
	/**
	 * myGraph Graph of player
	 */
	private char[][] myGraph;
	/**
	 * myLevel difficulty of graph
	 */
	private String myLevel;

	/**
	 * initialize the initial values of player.
	 */
	public Player() {
		myRow = 0;
		myCol = 0;
		myPreCol = myCol;
		myPreRow = myRow;
		myGraph = null;
		setLevel("Easy");

	}

	/**
	 * initialize of an object used function checkHaveWAy
	 */
	static class Pointer {
		int Row;
		int Col;

		public Pointer(int theRow, int theCol) {
			this.Row = theRow;
			this.Col = theCol;
		}

	}

	/**
	 * move the player to West.
	 */
	public void moveUp() {
		myRow -= 1;

	}

	/**
	 * move player to North.
	 */
	public void moveRight() {
		myCol += 1;

	}

	/**
	 * player move to South.
	 */
	public void moveDown() {
		myRow += 1;

	}

	/**
	 * player move to East.
	 */
	public void moveLeft() {

		myCol -= 1;

	}

	/**
	 * check player possible to go position.
	 * 
	 * @param theRow row.
	 * @param theCol col.
	 * @return boolean true false.
	 */
	public boolean canGo(int theRow, int theCol) {
		if (theRow < 0 || theRow >= myGraph.length || theCol < 0 || theCol >= myGraph[0].length
				|| myGraph[theRow][theCol] == '#' || myGraph[theRow][theCol] == '|') {
			return false;
		}

		return true;
	}

	/**
	 * check player have way to find exit.
	 * 
	 * @param theRow
	 * @param theCol
	 * @return boolean
	 */
	public boolean checkHaveWay(int theRow, int theCol) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int Row = myGraph.length;
		int Col = myGraph[0].length;
		boolean[][] isVisit = new boolean[Row][Col];
		Stack<Pointer> stack = new Stack<>();
		stack.add(new Pointer(theRow, theCol));
		isVisit[theRow][theCol] = true;
		while (!stack.isEmpty()) {

			Pointer p = stack.pop();
			for (int i = 0; i < dx.length; i++) {
				int newRow = p.Row + dx[i];
				int newCol = p.Col + dy[i];
				if (newRow >= 0 && newCol >= 0 && newRow < Row && newCol < Col && isVisit[newRow][newCol] == false
						&& myGraph[newRow][newCol] != '|' && myGraph[newRow][newCol] != '#') {
					isVisit[newRow][newCol] = true;
					stack.push(new Pointer(newRow, newCol));
					if (myGraph[newRow][newCol] == 'E') {
						return true;
					}

				}

			}

		}

		return false;

	}

	/**
	 * get image for player
	 * 
	 * @return image.
	 */
	public Image getPlayerImage() {
		return playerImg;
	}

	/**
	 * current Row .
	 * 
	 * @return int Row.
	 */
	public int getRow() {
		return myRow;
	}

	/**
	 * assign value Row.
	 * 
	 * @param theRow
	 */
	public void setRow(int theRow) {
		this.myRow = theRow;
		;
	}

	/**
	 * current column.
	 * 
	 * @return
	 */
	public int getCol() {
		return myCol;
	}

	/**
	 * assign column.
	 * 
	 * @param theCol
	 */
	public void setCol(int theCol) {
		this.myCol = theCol;
	}

	/**
	 * Id player .
	 * 
	 * @return strong ID
	 */
	public String getMyID() {
		return myID;
	}

	/**
	 * assign Id for player
	 * 
	 * @param myID return ID
	 */
	public void setMyID(String myID) {
		this.myID = myID;
	}

	/**
	 * map in 2D array of player.
	 * 
	 * @return myGraph char[][] .
	 */
	public char[][] getMyGraph() {
		return myGraph;
	}

	/**
	 * assign graph for player
	 * 
	 * @param myGraph
	 */
	public void setMyGraph(char[][] myGraph) {
		this.myGraph = myGraph;
	}

	/**
	 * preRow of player.
	 * 
	 * @return preRow.
	 */
	public int getPreRow() {
		return myPreRow;
	}

	/**
	 * assign Row of player .
	 * 
	 * @param thePreRow preRow.
	 */
	public void setPreRow(int thePreRow) {
		this.myPreRow = thePreRow;
	}

	/**
	 * pre column player .
	 * 
	 * @return preCol.
	 */
	public int getPreCol() {
		return myPreCol;
	}

	/**
	 * assign preCol.
	 * 
	 * @param thePreCol
	 */
	public void setPreCol(int thePreCol) {
		this.myPreCol = thePreCol;
	}

	/**
	 * level of Graph.
	 * 
	 * @return string level.
	 */
	public String getLevel() {
		return myLevel;
	}

	/**
	 * assign level of Graph.
	 * 
	 * @param theLevel
	 */
	public void setLevel(String theLevel) {
		this.myLevel = theLevel;
	}

}
