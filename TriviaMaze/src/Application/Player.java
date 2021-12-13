package Application;

import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import java.awt.*;
import Application.*;

public class Player {
	private ImageIcon img = new ImageIcon("icon\\Player.png");
	private int Row;
	private int Col;
	private String myID;
	private char[][] myGraph;
	private Image playerImg = img.getImage();

	public Player() {

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


}
