package sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;


/*
 *  It is good to address the problem about with the " ' " when trying to use it in a query
 *  in words such as doesn't, can't'
 * */

public class SQLtest {
	
	PreparedStatement statement;
	
	private static SQLiteDataSource ds = null;
	
    public static void main(String[] args) throws SQLException {
        
    	//
    	
        //establish connection (creates db file if it does not exist :-)
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println( "Opened database successfully" );
        //System.out.println("here: ");
        //randomQuestion();
        //now create a table
        String query = "CREATE TABLE IF NOT EXISTS questions ( " +
                "QUESTION TEXT NOT NULL, " +
                "ANSWER TEXT NOT NULL,"
                + "ANS1 TEXT NOT NULL,"
                + "ANS2 TEXT NOT NULL,"
                + "ANS3 TEXT NOT NULL )";
        
        try ( Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement(); ) {
              int rv = stmt.executeUpdate( query );
              System.out.println( "executeUpdate() returned " + rv );
          } catch ( SQLException e ) {
              e.printStackTrace();
              System.exit( 0 );
          }
          System.out.println( "Created questions table successfully" );
          
          
          
       
        
        //next insert two rows of data
        System.out.println( "Attempting to insert two rows into questions table" );

        //String query1 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'Last name of Java creator?', 'Gosling' )";
        //String query2 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'This statement is false', 'paradox' )";
        
//        String query1 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3) "
//        		+ "VALUES ('asd','1','2','3','4')";

        
        
        insertQueries( ds );
        
        
        
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
                String ans = rs.getString("ANS1");
                String ans2 = rs.getString("ANS2");
                String ans3 = rs.getString("ANS3");

                System.out.println( "Result: Question = " + question +
                    ", Answer = " + answer + ", ans1 = " + ans + ",ans2 = " + ans2 + ",ans3 = "+ ans3 );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        
        
        
        System.out.println("---------------------------");
        
        
//        String query1 = "SELECT * FROM questions ORDER BY RANDOM() LIMIT 1";
//    	
//    	try ( Connection conn = ds.getConnection();
//              Statement stmt = conn.createStatement(); ) {
//              ResultSet rs = stmt.executeQuery( query1 );
//              //System.out.println( "1st executeUpdate() returned " + rv );
//              //System.out.println( "2nd executeUpdate() returned " + rv );
//              String question = rs.getString( "QUESTION" );
//              String answer = rs.getString( "ANSWER" );
//              String ans = rs.getString("ANS1");
//              String ans2 = rs.getString("ANS2");
//              String ans3 = rs.getString("ANS3"); 
//              
//              System.out.println("The question :  "+question);
//          } catch ( SQLException e ) {
//              e.printStackTrace();
//              System.exit( 0 );
//          }
    	
        
        
    }
    
    public static void insertQueries( SQLiteDataSource ds ) {
    	        
        String query1 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'The insect that starves to death in its adult stage because it does not have a mouth is a:', "
    			+ " '1. Luna Moth',"
    			+ " '2. Poodle Moth',"
    			+ " '3. Glasswing Hawk Moth',"
    			+ " '4. Rosy Maple Moth' )";
        
        String query2 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'A substance that is harmless to bugs is:', "
    			+ " '1. none of the above',"
    			+ " '2. capsaicin',"
    			+ " '3. caffeine' ,"
    			+ " '4. rosin' )";
        
        String query3 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'Satoshi Tajiri developed Pokemon from one of the following experiences with animals:', "
    			+ " '1. Bug catching',"
    			+ " '2. Bird watching',"
    			+ " '3. Pet keeping' ,"
    			+ " '4. Rodent control' )";
        
        String query4 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'The mammal with the densest fur/hair is:', "
    			+ " '1. Sea Otter',"
    			+ " '2. Arctic Fox',"
    			+ " '3. Polar Bear' ,"
    			+ " '4. Tibetan Mastiff' )";
        
        String query5 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'This food is typically fed to pregnant dogs to gain weight:', "
    			+ " '1. Cottage Cheese',"
    			+ " '2. Bananas',"
    			+ " '3. Ham' ,"
    			+ " '4. Unseasoned Burger Meat' )";
        
        String query6 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'The bird that lays the largest eggs compared to its body is:', "
    			+ " '1. Kiwi',"
    			+ " '2. Bald Eagle',"
    			+ " '3. Kakapo' ,"
    			+ " '4. Humingbird' )";
        
        String query7 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'The size of a newborn kangaroo is:', "
    			+ " '1. 1 inch',"
    			+ " '2. 2 inches',"
    			+ " '3. 3 inches' ,"
    			+ " '4. 4 inches' )";
        
        String query8 = "INSERT INTO questions ( QUESTION, ANSWER, ANS1, ANS2, ANS3 ) "
    			+ "VALUES ( 'What advantage do slugs have over snails?', "
    			+ " '1. Needs less calcium',"
    			+ " '2. More defenses',"
    			+ " '3. Moves faster' ,"
    			+ " '4. None of the above' )";
        
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query1 );
            //System.out.println( "1st executeUpdate() returned " + rv );

            rv = stmt.executeUpdate( query2 );
            rv = stmt.executeUpdate( query3 );
            rv = stmt.executeUpdate( query4 );
            rv = stmt.executeUpdate( query5 );
            rv = stmt.executeUpdate( query6 );
            rv = stmt.executeUpdate( query7 );
            rv = stmt.executeUpdate( query8 );
            //System.out.println( "2nd executeUpdate() returned " + rv );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        
        
    }
    
    
    public static ArrayList<String> randomQuestion( ) throws SQLException {
    	ArrayList<String> list = new ArrayList<>();
    	
    	try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
    	
    	String query1 = "SELECT * FROM questions ORDER BY RANDOM() LIMIT 1";
    	
    	try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
              ResultSet rs = stmt.executeQuery( query1 );
              //System.out.println( "1st executeUpdate() returned " + rv );
              //System.out.println( "2nd executeUpdate() returned " + rv );
              String question = rs.getString( "QUESTION" );
              String answer = rs.getString( "ANSWER" );
              String ans = rs.getString("ANS1");
              String ans2 = rs.getString("ANS2");
              String ans3 = rs.getString("ANS3"); 
              
              list.add(question);
              list.add(answer);
              list.add(ans);
              list.add(ans2);
              list.add(ans3);
          } catch ( SQLException e ) {
              e.printStackTrace();
              System.exit( 0 );
          }
    	
    	//ResultSet rs = ((Statement) ds).executeQuery("SELECT * FROM questions ORDER BY RAND() LIMIT 1");
    	//String query = "";
    	//ResultSet rs = stmt.executeQuery(query);
    	
        System.out.println(list.get(0));
        
    	return list;
    }
    
    public static void deleteRow( ArrayList<String> theList ) {
    	
    	try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
    	
    	String questionAsString = theList.get(0);
    	
    	
    	String query = "DELETE FROM questions WHERE QUESTION = "+questionAsString;
    	
    	try ( Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement(); ) {              
    			ResultSet rs = stmt.executeQuery( query );
                
            } catch ( SQLException e ) {
                e.printStackTrace();
                System.exit( 0 );
            }
    }
    
    public static ArrayList<String> questionAsArrayList( String question , String answer , 
    		String ans1 , String ans2, String ans3 ) {
    	ArrayList<String> list = new ArrayList<>();
    	
    	list.add( question );
    	list.add( answer );
    	list.add( ans1 );
    	list.add( ans2 );
    	list.add( ans3 );
    	
    	return list;
    }
    
    public static void saveGame( player thePlayer ) throws SQLException {
    	try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:players.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println( "Opened database players successfully" );
        
        String query = "CREATE TABLE IF NOT EXISTS players ( "
        		+ "THEID TEXT NOT NULL,"
        		+ "THEROW INT,"
        		+ "THECOLUMN INT,"
        		+ "THEKEY INT,"
        		+ "TERRAIN int[][] )";
        
        try ( Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement(); ) {
              int rv = stmt.executeUpdate( query );
              System.out.println( "executeUpdate() returned " + rv );
          } catch ( SQLException e ) {
              e.printStackTrace();
              System.exit( 0 );
          }
          System.out.println( "Created players table successfully" );
        
          
          
          String id = thePlayer.theID;
          int therow = thePlayer.theRow;
          int thecol = thePlayer.theRow;
          int thekey = thePlayer.theRow;
          
          String query1 = "INSERT INTO players VALUES ( "+id+","+therow+","+thecol
        		  +","+thekey;
          
    }
    
    
    class player implements Serializable{
    	public String theID;
    	public int theRow;
    	public int theCol;
    	public int theKey;
    	//public Terrain[][] theMap;
    }
    
}