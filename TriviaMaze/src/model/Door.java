package model;
import java.util.Random;
import java.util.Scanner;

public class Door {
	/**
	 * return true if it open;
	 */
	private boolean isOpen;
	private String myQuestion;
	private String myAnswers;
	private String correctAnswer;

	public String getQuestion() {
		return myQuestion;
	}

	public void setQuestionAndAnswers() {
		Random rand = new Random();
		int intRandom = rand.nextInt(15) + 1;
	}

	public String getAnswer() {
		return myAnswers;
	}
	
	public void displayQuestion() {
		System.out.println(myQuestion);
	}
	
	public boolean lockDoor(String userAnswer) {
		if (!correctAnswer.equals(userAnswer))
			isOpen = false;
	}

}
