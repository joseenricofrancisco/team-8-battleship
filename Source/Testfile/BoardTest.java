import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testBoard7x7() {
		Board board = new Board(6,7);
		assertEquals("In a board of 7x7, the height should be 7.", 7, board.getMapHeight());
		assertEquals("In a board of 7x7, the width should be 6.", 6, board.getMapWidth());
	}
	
	@Test
	public void testBoardOver10x10() {
		Board board = new Board(-12, 22);
		assertEquals("The default value should be 10 if the value entered is > 10 or < 0.", 10, board.getMapHeight());
		assertEquals("The default value should be 10 if the valie entered is > 10 or < 0.", 10, board.getMapWidth());
	}

	@Test
	public void testGetMapWidth() {
		Board board = new Board(10, 8);
		assertEquals(10, board.getMapWidth());
	}

	@Test
	public void testGetMapHeight() {
		Board board = new Board(10, 8);
		assertEquals(8, board.getMapHeight());
	}

	@Test
	public void testSetMapWidth() {
		Board board = new Board(10, 10);
		assertEquals(10, board.getMapWidth());
		board.setMapWidth(4);
		assertEquals("After using the setter method, the width should now be 4.", 4, board.getMapWidth());
	}
	
	@Test
	public void testSetMapHeight() {
		Board board = new Board(10, 10);
		assertEquals(10, board.getMapHeight());
		board.setMapHeight(4);
		assertEquals("After using the setter method, the height should now be 4.", 4, board.getMapHeight());
	}

}
