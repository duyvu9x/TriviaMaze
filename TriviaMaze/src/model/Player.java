package model;

public class Player {
	/**
	 *  myId id of player.
	 */
	private String myId;
	/**
	 * myX X coordinate of player.
	 */
	private int myCol;
	/**
	 * myY Y coordinate of player
	 */
	private int myRow;
	
	/**
	 * myStartX X start coordinate.
	 */
	private int myStartX;
	/**
	 * myStartY Y start coordinate. 
	 */
	private int myStartY;
	/**
	 * myKey key to open door.
	 */
	private int myKey;
	/**
	 * map 2D array map.
	 */
	private char[][] myMap;
//	/**
//	 * position of Player.
//	 */
//	private int position;

	
	
	
	public Player( final String theId, final int theRow, final int theCol, final int theKey, final char[][] themap) {
		myMap = themap;
		myRow = theRow;
		myCol = theCol;
		myKey = theKey;
		
	}
	
	
	public String getId() {
		return myId;
	}


	public void setId(String myId) {
		this.myId = myId;
	}


	public int getCol() {
		return myCol;
	}


	public void setCol(int myCol) {
		this.myCol = myCol;
	}


	public int getRow() {
		return myRow;
	}


	public void setRow(int myRow) {
		this.myRow = myRow;
	}


	public int getStartX() {
		return myStartX;
	}


	public void setStartX(int myStartX) {
		this.myStartX = myStartX;
	}


	public int getStartY() {
		return myStartY;
	}


	public void setStartY(int myStartY) {
		this.myStartY = myStartY;
	}


	public int getKey() {
		return myKey;
	}


	public void setKey(int myKey) {
		this.myKey = myKey;
	}


	public char[][] getMap() {
		return myMap;
	}


	public void setMap(char[][] myMap) {
		this.myMap = myMap;
	}

	

	public void goUp() {
		int row = myRow -1;
		int col = myCol;
		if( CanPass(row, col)) {
			myCol = col;
			myRow = row;
		}
	}
	public void goDown() {
		int row = myRow +1;
		int col = myCol;
		if( CanPass(row, col)) {
			myCol = col;
			myRow = row;
		}
	}
	public void goRight() {
		int row = myRow;
		int col = myCol +1;
		if( CanPass(row, col)) {
			myCol = col;
			myRow = row;
		}
	}
	public void goLeft() {
		int row = myRow;
		int col = myCol -1;
		if( CanPass(row, col)) {
			myCol = col;
			myRow = row;
		}
	}
	
	
	public boolean CanPass( int row , int col) {
		boolean canpass = false;
		if(row >= 0 && col >=0 && row< myMap.length  
		     && col <= myMap[0].length && myMap[row][col]!= '#') {
			canpass = true;
		}
		
		return canpass;
	}
	
	
	
	
	
	
}
