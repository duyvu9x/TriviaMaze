package model;

import java.util.ArrayList;

/**
 * 
 * @author Duy vu
 * @version 1
 *
 */
public class Question {

	private ArrayList<String> MyQuestion;
	private Player myPlayer;
	
	

	public boolean iscorrect(String correct, String input) {
		if (input.equalsIgnoreCase(correct)) {
			return true;
		}
		return false;
	}

	public boolean useKey(Player p1) {
		int key = p1.getKey();
		if (key > 0) {
			p1.setKey(key - 1);
			return true;
		}
		return false;
	}

}
