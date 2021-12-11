package Application;

import java.util.ArrayList;

public class Question_Answer {
	

	
	
	// function to get question in SQL/ SQlite
	public ArrayList<String> getQuestion() {
		ArrayList<String> myQuestion = null;
		return myQuestion;
	}
	// let question is answer .
	public void questionAnswer( ArrayList<String> question ) {
	}
	
	public Boolean isCorrectAnswer(String answer, String input) {
		if (input == answer) {
			return true;
		}
		return false;

	}

}
