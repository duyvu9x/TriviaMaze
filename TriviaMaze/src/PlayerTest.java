package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Application.Player;
/**
 * 
 * @author Carlos Manrique Ucharico
 *
 */
public class PlayerTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	public static Player myPlayer = new Player();
	public static Player myPlayerTest2 = new Player();
	public static Player myPlayerTest3 = new Player();
	public static char[][] myGraph = { {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
									   {'S','-','-','/','-','-','-','-','#','#','#','#','#','#'},
									   {'#','#','#','-','#','#','#','-','-','#','#','#','#','#'},
									   {'#','#','#','-','#','#','#','#','/','#','#','#','#','#'},
									   {'#','#','#','-','#','#','#','#','-','#','#','#','#','#'},
									   {'#','#','#','-','-','-','/','-','-','-','-','/','#','#'},
									   {'#','#','#','#','#','#','#','#','#','#','#','E','#','#'} };
	
	public static char[][] myGraph2 = { {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
			   						   {'S','-','-','|','-','-','-','-','#','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','-','-','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','#','|','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','#','-','#','#','#','#','#'},
			   						   {'#','#','#','-','-','-','|','-','-','-','-','/','#','#'},
			   						   {'#','#','#','#','#','#','#','#','#','#','#','E','#','#'} };
	
	public static char[][] myGraph3 = { {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
			   						   {'S','-','-','/','-','-','-','-','#','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','-','-','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','#','/','#','#','#','#','#'},
			   						   {'#','#','#','-','#','#','#','#','-','#','#','#','#','#'},
			   						   {'#','#','#','-','-','-','/','-','-','-','-','/','#','#'},
			   						   {'#','#','#','#','#','#','#','#','#','#','#','E','#','#'} };
	
	@Before
	public void setUp() throws Exception {
		myPlayerTest2.setRow(3);
		myPlayerTest2.setCol(3);
		myPlayerTest2.setPreCol(2);
		
		
	}

	/**
	 * Test method for {@link Model.Player#Player()}.
	 */
	@Test
	public void testPlayer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Model.Player#moveUp()}.
	 */
	@Test
	public void testMoveUp() {
		myPlayer.setRow(5);
		myPlayer.setCol(5);
		
		myPlayer.moveUp();		
		assertEquals( 4 , myPlayer.getRow());
		
		myPlayer.moveUp();		
		assertEquals( 3 , myPlayer.getRow());
		
		myPlayer.moveUp();		
		assertEquals( 2 , myPlayer.getRow());
	}

	/**
	 * Test method for {@link Model.Player#moveRight()}.
	 */
	@Test
	public void testMoveRight() {
		myPlayer.setRow(2);
		myPlayer.setCol(2);
		
		myPlayer.moveRight();		
		assertEquals( 3 , myPlayer.getCol());
		
		myPlayer.moveRight();		
		assertEquals( 4 , myPlayer.getCol());
		
		myPlayer.moveRight();		
		assertEquals( 5 , myPlayer.getCol());
	}

	/**
	 * Test method for {@link Model.Player#moveDown()}.
	 */
	@Test
	public void testMoveDown() {
		myPlayer.setRow(2);
		myPlayer.setCol(2);
		
		myPlayer.moveDown();		
		assertEquals( 3 , myPlayer.getRow() );
		
		myPlayer.moveDown();		
		assertEquals( 4 , myPlayer.getRow() );
		
		myPlayer.moveDown();		
		assertEquals( 5 , myPlayer.getRow() );
	}

	/**
	 * Test method for {@link Model.Player#moveLeft()}.
	 */
	@Test
	public void testMoveLeft() {
		myPlayer.setRow(2);
		myPlayer.setCol(5);
		
		myPlayer.moveRight();		
		assertEquals( 4 , myPlayer.getCol());
		
		myPlayer.moveRight();		
		assertEquals( 3 , myPlayer.getCol());
		
		myPlayer.moveRight();		
		assertEquals( 2 , myPlayer.getCol());
	}

	/**
	 * Test method for {@link Model.Player#canGo(int, int)}.
	 */
	@Test
	public void testCanGo() {
		
		/*
		 *##############
		 S--/----######
		 ###-###--#####
		 ###-####/#####
		 ###-####-#####
	 	 ###---/----/##
		 ###########E## 
		 * */
		//
		//  as we can see from the map the first row should not be accesible
		
		myPlayer.setMyGraph(myGraph);
		
		for( int i = 0 ; i<14 ; i++) {
			assertEquals( false , myPlayer.canGo(0, i) );
		}
		
		assertEquals(true, myPlayer.canGo(1, 1));
		assertEquals(true, myPlayer.canGo(1, 2));
		assertEquals(true, myPlayer.canGo(1, 3));
		
		for( int i = 8 ; i <= 14 ; i++ ) {
			assertEquals( false , myPlayer.canGo(1, i) );
		}
		
		//  testing last row
		for( int i = 0 ; i < 14; i++ ) {
			if( i != 11 )			
				assertEquals( false , myPlayer.canGo(13, i) );
			else
				assertEquals( true , myPlayer.canGo(13, i) );
		}
		
		
	}

	/**
	 * Test method for {@link Model.Player#checkHaveWay(int, int)}.
	 */
	@Test
	public void testCheckHaveWay() {
		/*
		  
		 * ##############
		   S--|----######
		   ###-###--#####
		   ###-####|#####
		   ###-####-#####
		   ###---|----/##
		   ###########E##
		   
		 * */
		
		//  testing right before the exit with the door open
		
		myPlayer.setMyGraph(myGraph2);
		assertEquals( true , myPlayer.checkHaveWay( 5 , 8 ) );
		assertEquals( true , myPlayer.checkHaveWay( 5 , 9 ) );
		assertEquals( true , myPlayer.checkHaveWay( 5 , 10 ) );
		
		// testing in a position behind the doors closed
		
		assertEquals( false , myPlayer.checkHaveWay( 1 , 1 ) );
		assertEquals( true , myPlayer.checkHaveWay( 1 , 5 ) );
		assertEquals( true , myPlayer.checkHaveWay( 5 , 4 ) );
		assertEquals( true , myPlayer.checkHaveWay( 5 , 5 ) );
		
	}

	/**
	 * Test method for {@link Model.Player#getPlayerImage()}.
	 */
	@Test
	public void testGetPlayerImage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Model.Player#getRow()}.
	 */
	@Test
	public void testGetRow() {
		myPlayer.setRow(10);
		assertEquals( 10 , myPlayer.getRow() );
		
		myPlayer.setRow(20);
		assertEquals( 20 , myPlayer.getRow() );
		
		myPlayer.setRow(1);
		assertEquals( 1 , myPlayer.getRow() );
	}

	/**
	 * Test method for {@link Model.Player#setRow(int)}.
	 */
	@Test
	public void testSetRow() {
		myPlayer.setRow(0);
		assertEquals( 0 , myPlayer.getRow() );
		
		myPlayer.setRow(1);
		assertEquals( 1 , myPlayer.getRow() );
		
		myPlayer.setRow(5);
		assertEquals( 5 , myPlayer.getRow() );
	}

	/**
	 * Test method for {@link Model.Player#getCol()}.
	 */
	@Test
	public void testGetCol() {
		myPlayer.setCol(10);
		assertEquals( 10 , myPlayer.getCol() );
		
		myPlayer.setCol(20);
		assertEquals( 20 , myPlayer.getCol() );
		
		myPlayer.setCol(1);
		assertEquals( 1 , myPlayer.getCol() );

	}

	/**
	 * Test method for {@link Model.Player#setCol(int)}.
	 */
	@Test
	public void testSetCol() {
		myPlayer.setCol(0);
		assertEquals( 0 , myPlayer.getCol() );
		
		myPlayer.setCol(10);
		assertEquals( 10 , myPlayer.getCol() );
		
		myPlayer.setCol(20);
		assertEquals( 20 , myPlayer.getCol() );
	}

	/**
	 * Test method for {@link Model.Player#getMyID()}.
	 */
	@Test
	public void testGetMyID() {
		myPlayer.setMyID("a");
		String expected = "a";
		assertEquals( true , expected.equals( myPlayer.getMyID() ) );
		
		myPlayer.setMyID("abcde");
		String expected2 = "abcde";
		assertEquals( true , expected2.equals( myPlayer.getMyID() ) );
		
		myPlayer.setMyID("123");
		String expected3 = "123";
		assertEquals( true , expected3.equals( myPlayer.getMyID() ) );
	}

	/**
	 * Test method for {@link Model.Player#setMyID(java.lang.String)}.
	 */
	@Test
	public void testSetMyID() {
		myPlayer.setMyID( "a" );
		String expected = "a";
		assertEquals( true , expected.equals( myPlayer.getMyID()) );
		
		myPlayer.setMyID( "abcde" );
		String expected2 = "abcde";
		assertEquals( true , expected2.equals( myPlayer.getMyID()) );
		
		myPlayer.setMyID( "123" );
		String expected3 = "123";
		assertEquals( true , expected3.equals( myPlayer.getMyID()) );
	}

	/**
	 * Test method for {@link Model.Player#getMyGraph()}.
	 */
	@Test
	public void testGetMyGraph() {
		char[][] matrix = { {'a', 'b' , 'c' } , {'d','e','f'} };
		myPlayer.setMyGraph( matrix );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix) );
		
		char[][] matrix2 = { {'a', 'b' } , {'d','e'} };
		myPlayer.setMyGraph( matrix2 );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix2 ) );
		
		char[][] matrix3 = { {'a', 'b' , 'c', 'd' } , {'e','f','g' , 'h'} };
		myPlayer.setMyGraph( matrix3 );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix3) );
	}

	/**
	 * Test method for {@link Model.Player#setMyGraph(char[][])}.
	 */
	@Test
	public void testSetMyGraph() {
		char[][] matrix = { {'0', '1' , '2' } , {'3','4','5'} };
		myPlayer.setMyGraph( matrix );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix) );
		
		char[][] matrix2 = { {'0', '1' } , {'2','3'} };
		myPlayer.setMyGraph( matrix2 );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix2 ) );
		
		char[][] matrix3 = { {'a', 'e' , 'i', 'o' } , {'u','a','e' , 'i'} };
		myPlayer.setMyGraph( matrix3 );
		assertEquals( true , compareMatrixes( myPlayer.getMyGraph() , matrix3) );
	}

	/**
	 * Test method for {@link Model.Player#getPreRow()}.
	 */
	@Test
	public void testGetPreRow() {
		myPlayer.setPreRow(0);
		assertEquals( 0 , myPlayer.getPreRow() );
		
		myPlayer.setPreRow(10);
		assertEquals( 10 , myPlayer.getPreRow() );
		
		myPlayer.setPreRow(5);
		assertEquals( 5 , myPlayer.getPreRow() );
	}

	/**
	 * Test method for {@link Model.Player#setPreRow(int)}.
	 */
	@Test
	public void testSetPreRow() {
		myPlayer.setPreRow(0);
		assertEquals( myPlayer.getPreRow() , 0 );
		
		myPlayer.setPreRow(10);
		assertEquals(  myPlayer.getPreRow() , 10 );
		
		myPlayer.setPreRow(5);
		assertEquals( myPlayer.getPreRow() , 5 );
	}

	/**
	 * Test method for {@link Model.Player#getPreCol()}.
	 */
	@Test
	public void testGetPreCol() {
		myPlayer.setPreCol(0);
		assertEquals( 0 , myPlayer.getPreCol() );
		
		myPlayer.setPreCol(10);
		assertEquals( 10 , myPlayer.getPreCol() );
		
		myPlayer.setPreCol(5);
		assertEquals( 5 , myPlayer.getPreCol() );
	}

	/**
	 * Test method for {@link Model.Player#setPreCol(int)}.
	 */
	@Test
	public void testSetPreCol() {
		myPlayer.setPreCol(0);
		assertEquals( myPlayer.getPreCol() , 0 );
		
		myPlayer.setPreCol(10);
		assertEquals( myPlayer.getPreCol() , 10 );
		
		myPlayer.setPreCol(5);
		assertEquals( myPlayer.getPreCol() , 5 );
	}

	/**
	 * Test method for {@link Model.Player#getLevel()}.
	 */
	@Test
	public void testGetLevel() {
		myPlayer.setLevel("word");
		assertEquals( true ,  myPlayer.getLevel().equals("word") );
		
		myPlayer.setLevel("string");
		assertEquals( true ,  myPlayer.getLevel().equals("string") );
		
		myPlayer.setLevel("test3");
		assertEquals( true ,  myPlayer.getLevel().equals("test3") );
	}

	/**
	 * Test method for {@link Model.Player#setLevel(java.lang.String)}.
	 */
	@Test
	public void testSetLevel() {
		myPlayer.setLevel("word");
		assertEquals( myPlayer.getLevel().equals("word") , true  );
		
		myPlayer.setLevel("string");
		assertEquals( myPlayer.getLevel().equals("word2") , true  );
		
		myPlayer.setLevel("test3");
		assertEquals( myPlayer.getLevel().equals("word3") ,  true );
	}
	
public boolean compareMatrixes( char[][] first , char[][] second ) {
		
		if( first.length != second.length )
			return false;
		
		if( first[0].length != second[0].length )
			return false;
		
		for( int i = 0 ; i<first.length ; i++ ) {
			for( int j = 0 ; j<first[0].length ; j++ ) {
				if( first[i][j] != second[i][j] ) {
					return false;
				}
			}
		}
		
		return true;
	}

}