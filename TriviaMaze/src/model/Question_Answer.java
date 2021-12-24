package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import sql.SQLtest;

/**
 * 
 * @author Carlos Manrique Ucharico
 * @version Autumn 2021
 *
 */
public class Question_Answer {


	/**
	 * 
	 * @return Function to get rundom qustion 
	 * @throws SQLException exception error.
	 */
	public static ArrayList<String> getQuestion() throws SQLException {
		// SQLtest sql = new SQLtest();
		// ArrayList<String> myQuestion = null;
		return SQLtest.randomQuestion();
	}

	// let question is answer .
	public void questionAnswer(ArrayList<String> question) {
	}

	public Boolean isCorrectAnswer(String answer, String input) {
		if (input == answer) {
			return true;
		}
		return false;
	}

}