package Model;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import java.awt.*;

public class Player {
	private ImageIcon img = new ImageIcon("icon\\Player.png");
	private Image playerImg = img.getImage();
	private int Row;
	private int Col;
	private int preRow;
	private int preCol;
	private String myID;
	private char[][] myGraph;

	


	public Player() {
		Row = 0;
		Col = 0;
		preCol = Col;
		preRow = Row;
		myGraph = null;

	}

	

	public void moveUp() {
		Row = Row - 1;

	}

	public void moveRight() {
		Col = Col + 1;

	}

	public void moveDown() {
		Row = Row + 1;

	}

	public void moveLeft() {

		Col = Col - 1;

	}
	public Boolean canGo(int row, int col) {
		if (row < 0 || row >= Row || col < 0 || col >= Col || myGraph[row][col] == '#' || myGraph[row][col] == '|') {
			return false;
		}

		return true;
	}

	public Image getPlayerImage() {
		return playerImg;
	}

	public int getRow() {
		return Row;
	}
	public void setRow(int row) {
		this.Row = row;;
	}

	public int getCol() {
		return Col;
	}
	public void setCol(int Col) {
		this.Col = Col;
	}

	public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}
	public char[][] getMyGraph(){
		return myGraph;
	}
	
	public void setMyGraph(char[][] myGraph) {
		this.myGraph = myGraph;
	}



	public int getPreRow() {
		return preRow;
	}



	public void setPreRow(int preRow) {
		this.preRow = preRow;
	}



	public int getPreCol() {
		return preCol;
	}



	public void setPreCol(int preCol) {
		this.preCol = preCol;
	}


}
