package example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class function_quesiton {
	File myQuestionFile = new File("questions.txt");
	
	public static ArrayList<String> listQuestion(){
		ArrayList<String> listquestion = new ArrayList<>();
		// todo something.
		Random rand = new Random();
		int intRandom = rand.nextInt(15) + 1;
		if(intRandom > 1) {
			intRandom = 6 * (intRandom - 1);
		}
		try {
			while(!Files.readAllLines(Paths.get("questions.txt")).get(intRandom).equals("*")) {
				listquestion.add(Files.readAllLines(Paths.get("questions.txt")).get(intRandom));
				intRandom++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listquestion;
	}
	
	public void remove() {
		// remove used question to answer.txt file
		try {
			FileWriter answeredQuestions = new FileWriter("answer.txt");
			for(int i = 0; i < listQuestion().size(); i++) {
				answeredQuestions.write(listQuestion().get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkAnswer(){
		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();
		return listQuestion().get(userChoice + 1).equals(listQuestion().get(listQuestion().size()));
	}
}
