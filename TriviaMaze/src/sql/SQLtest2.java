
package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteDataSource;

/**
 * 
 * @author tom capaul
 * 
 * Simple class to demonstrate SQLite connectivity
 * 1) create connection
 * 2) add a table
 * 3) add entries to the table
 * 4) query the table for its contents
 * 5) display the results
 * 
 * NOTE: any interactions with a database should utilize a try/catch
 * since things can go wrong
 * 
 * @see <a href="https://shanemcd.org/2020/01/24/how-to-set-up-sqlite-with-jdbc-in-eclipse-on-windows/">
https://shanemcd.org/2020/01/24/how-to-set-up-sqlite-with-jdbc-in-eclipse-on-windows/</a>
 *
 */
public class SQLtest2 {

    public static void main(String[] args) {
        SQLiteDataSource ds = null;

        //establish connection (creates db file if it does not exist :-)
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questionstwo.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
        
        //////////////////////////////////////////
        
        
        System.out.println( "Opened database successfully" );
        
        
        //now create a table
        String query = "CREATE TABLE IF NOT EXISTS questions ( " +
                "QUESTION TEXT NOT NULL, " +
                "ANSWER TEXT NOT NULL )";
        try ( Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement(); ) {
              int rv = stmt.executeUpdate( query );
              System.out.println( "executeUpdate() returned " + rv );
          } catch ( SQLException e ) {
              e.printStackTrace();
              System.exit( 0 );
          }
          System.out.println( "Created questions table successfully" );
        
        
          //////////////////////////////////////////////
          
          		//  CREATING ANOTHER TABLE
          ///////////////////////////////////////////////
          
//          String query2 = "CREATE TABLE IF NOT EXISTS questions2 ("
//          		+ "QUESTIONS TEX NOT NULL,"
//          		+ "CORRECTANS TEXT NOT NULL,"
//          		+ "DUMMYANSWER1 TEXT NOT NULL,"
//          		+ "DUMMYANSWER2 TEXT NOT NULL,"
//          		+ "DUMMYANSWER3 TEXT NOT NULL,"
//          		+ "DUMMYANSWER4 TEXT NOT NULL )";
//          
//          try ( Connection conn = ds.getConnection();
//                  Statement stmt = conn.createStatement(); ) {
//                int rv = stmt.executeUpdate( query2 );
//                System.out.println( "executeUpdate() returned " + rv );
//            } catch ( SQLException e ) {
//                e.printStackTrace();
//                System.exit( 0 );
//            }
//            System.out.println( "Created questions2 table successfully" );
//          
          
         
        insertQueries(ds);
        
        
        
        
        //now query the database table for all its contents and display the results
        System.out.println( "Selecting all rows from test table" );
        query = "SELECT * FROM questions";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            ResultSet rs = stmt.executeQuery(query);
            
            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );

                System.out.println( "Result: Question = " + question +
                    ", Answer = " + answer );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }

    public static void insertQueries( SQLiteDataSource ds ) {                    
        //  testing out queries before adding official questions
        String query1 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'myquestion', 'myanswer' )";
        String query2 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'questions2', 'answer2' )";
        String query3 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'cerl', 'del' )";
        
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query1 );
            rv = stmt.executeUpdate( query2 );
            rv = stmt.executeUpdate( query3 );
        
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
    
//    public static void insertQandA( SQLiteDataSource ds) {
//    	String query1 = "INSERT INTO questions (arraylist1, arraylist2) VALUES(?,?)";
//    }
    
    public static void insertQandA( SQLiteDataSource ds) {
    	//  create 5 spaces in a table then add each one in an arraylist
    	
    	String query1 = "INSERT INTO questions ( QUESTION, ANSWER, ANS, ANS, ANS ) "
    			+ "VALUES ( 'The insect that starves to death in its adult stage because it doesn't have a mouth is a:', "
    			+ " '1. Luna Moth',"
    			+ " '2. Poodle Moth',"
    			+ " '3. Glasswing Hawk Moth'"
    			+ " '4. Rosy Maple Moth')";
    	
    	
    	//The insect that starves to death in its adult stage because it doesn't have a mouth is a:
    	//1. Luna Moth
//    	2. Poodle Moth
//    	3. Glasswing Hawk Moth
//    	4. Rosy Maple Moth
//    	1. Luna Moth
    	
    }
    
    public static ArrayList<String> questionAsArrayList() {
    	ArrayList<String> list = new ArrayList<>();
    	
    	return list;
    }
    
}