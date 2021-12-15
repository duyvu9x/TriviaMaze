package sql;

import java.sql.SQLException;
import java.util.ArrayList;

public class Question_Answer {

    public static void main (String[] args) throws SQLException {
        ArrayList<String>  checkcode = new ArrayList<>();
        checkcode = getQuestion();
        //System.out.print("-----------"+checkcode);
        
        for( int i = 0 ; i< checkcode.size() ; i++) {
            System.out.println( checkcode.get(i));
        }
    }

    
    // function to get question in SQL/ SQlite
    public static  ArrayList<String> getQuestion() throws SQLException {
    	//SQLtest sql = new SQLtest();
        //ArrayList<String> myQuestion = null;
        return SQLtest.randomQuestion();
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