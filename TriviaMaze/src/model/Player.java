package model;

public class Player {
	/**
	 *  myId id of player.
	 */
	private String myId;
	/**
	 * myX X coordinate of player.
	 */
	private int myX;
	/**
	 * myY Y coordinate of player
	 */
	private int myY;
	
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
//	/**
//	 *myCanGo true if still have eay to exit. 
//	 */
//	private boolean myCanGo;
	
	
	
	protected Player( final String theId, final int theX, final int theY, final int theKey) {
		myX = theX;
		myY = theY;
		myStartX = theX;
		myStartY = theY;
		myKey = theKey;
//		myCanGo = true;
	}
	
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public int getkey() {
		return myKey;
	}
//	public boolean canWin() {
//		if( myKey> 0) {
//			myCanGo = true;
//		} else {
//			
//		}
//		return myCanGo;
//		
//	}

}
