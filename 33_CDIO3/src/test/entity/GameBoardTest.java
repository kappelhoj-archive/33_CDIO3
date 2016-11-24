package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.GameBoard;
import entity.Player;
import entity.fields.Ownable;

public class GameBoardTest 
{
	GameBoard gameBoard;
	Player player1;
	Player player2;

	@Before
	public void setUp() throws Exception 
	{
		gameBoard = new GameBoard();
		player1 = new Player("Peter");
		player2 = new Player("Lotte");
	}

	@After
	public void tearDown() throws Exception 
	{
		gameBoard = null;
		player1 = null;
		player2 = null;
	}

	/**
	 * Test-id: U021
	 * Method test_RemoveAllPlayerFields tests the method removeAllPlayerFields.
	 * The tested method should remove the player with the given name as a owner from all fields.
	 */

	@Test
	public void test_RemoveAllPlayerFields() 
	{

		// Player "Peter" buys two territory fields (1 and 4).
		((Ownable) gameBoard.getField(1)).buyField(player1);
		((Ownable) gameBoard.getField(4)).buyField(player1);

		// Player "Lotte" buys two territory fields (2 and 5).
		((Ownable) gameBoard.getField(2)).buyField(player2);
		((Ownable) gameBoard.getField(5)).buyField(player2);

		// Remove all fields from "Peter"
		gameBoard.removeAllPlayerFields("Peter");

		// Check if all the fields are as expected.
		for (int i = 1; i <= 21; i++) {
			// Checks that the checked field isn't a "Refuge" or "Tax" field, a.k.a not a Ownable field.
			if (!gameBoard.getField(i).getType().equals("Refuge") && !gameBoard.getField(i).getType().equals("Tax")) 
			{
				//Checks if field 2 and 5 is stil owned by Lotte.
				switch (i) 
				{
				case 2:
				case 5:
					if (!((Ownable) gameBoard.getField(i)).getOwner().getPlayerName().equals(player2.getPlayerName()))
						fail("Checked field " + i + " it was suppossed to be owned by Lotte, but wasn't.");
					break;
					// Checks if any other field is owned, they shouldn't because only Lotte and Peter had bought fields
					// and Peter should have been removed as owner on all fields.
				default:
					if (((Ownable) gameBoard.getField(i)).getOwner() != null)
						fail("Checked field " + i + " it was suppossed to be owned by nobody, but wasn't.");
					break;
				}
			}
		}

	}

}
