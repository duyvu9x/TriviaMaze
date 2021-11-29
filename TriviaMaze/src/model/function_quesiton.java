package example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class function_quesiton {
	File myQuestionFile = new File("questions.txt");
	ArrayList<String> listquestion;
	public function_quesiton() {
		listquestion = new ArrayList<>();
		
	}
	public void setListQuestion(){
		//ArrayList<String> listquestion = new ArrayList<>();
		// todo something.
		Random rand = new Random();
		int intRandom = rand.nextInt(11) + 1;
		int questionNum = 0;
		if(intRandom > 1) {
			questionNum = 7 * (intRandom - 1);
		}
		else {
			questionNum = 0;
		}
		String questionPart = "";
		while(!questionPart.equals("*")) {
			try (Stream<String> lines = Files.lines(Paths.get("questions.txt"))) {
				questionPart = lines.skip(questionNum).findFirst().get();
				listquestion.add(questionPart);
				
				questionNum++;
			}
			catch(IOException e){
				System.out.println(e);
			}
		}
	}
	
	public ArrayList<String> getList(){
		return listquestion;
	}
	
	public void remove(ArrayList<String> listquestion) {
		// remove used question to answer.txt file
		try {
			FileWriter answeredQuestions = new FileWriter("answer.txt");
			for(int i = 0; i < listquestion.size(); i++) {
				answeredQuestions.write(listquestion.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkAnswer(ArrayList<String> listquestion){
		Scanner input = new Scanner(System.in);
		System.out.println("Select the corresponding number to the answer choice:");
		for(int i = 1; i < listquestion.size()-2; i++) {
			System.out.println(listquestion.get(i));
		}
		int userChoice = input.nextInt();
		return listquestion.get(userChoice + 1).equals(listquestion.get(listquestion.size()-2));
	}
}
