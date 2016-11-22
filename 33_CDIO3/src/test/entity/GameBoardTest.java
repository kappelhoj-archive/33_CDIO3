package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.GameBoard;
import entity.Player;
import entity.fields.Ownable;

public class GameBoardTest {
	GameBoard gameBoard;
	Player player;
	int fields[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		player = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception {
		gameBoard = null;
		player = null;
	}
	
	
	/*
	 * Testing if removeAllPlayerFields removes owner status from a specific players fields
	 */
	@Test
	public void testRemoveAllPlayerFields() {
		
		// Player "Peter" buys two territory fields (1 and 4).
		((Ownable) gameBoard.getField(fields[2])).buyField(player);
		((Ownable) gameBoard.getField(fields[5])).buyField(player);
		
		// Remove all fields from "Peter"
		gameBoard.removeAllPlayerFields("Peter");
		
		Player expected = null;
		Player actualField1Owner = ((Ownable) gameBoard.getField(fields[2])).getOwner();
		Player actualField4Owner = ((Ownable) gameBoard.getField(fields[5])).getOwner();
		
		if(actualField1Owner != expected && actualField4Owner != expected)
			fail("One of the fields still has an owner. Field1Owner = " + actualField1Owner.getPlayerName() + " Field4Owner = " + actualField4Owner.getPlayerName());
		
	}

}
