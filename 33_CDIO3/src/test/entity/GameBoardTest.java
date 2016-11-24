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
	Player player1;
	Player player2;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		player1 = new Player("Peter");
		player2 = new Player("Lotte");
	}

	@After
	public void tearDown() throws Exception {
		gameBoard = null;
		player1 = null;
		player2 = null;
	}

	/*
	 * Testing if removeAllPlayerFields removes owner status from a specific
	 * players fields
	 */
	@Test
	public void testRemoveAllPlayerFields() {

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
			if (!gameBoard.getField(i).getType().equals("Refuge") && !gameBoard.getField(i).getType().equals("Tax")) {
				switch (i) {
				case 2:
				case 5:
					if (!((Ownable) gameBoard.getField(i)).getOwner().getPlayerName().equals(player2.getPlayerName()))
						fail("Checked field " + i + " it was suppossed to be owned by Lotte, but wasn't.");
					break;
				default:
					if (((Ownable) gameBoard.getField(i)).getOwner() != null)
						fail("Checked field " + i + " it was suppossed to be owned by nobody, but wasn't.");
					break;
				}
			}
		}

	}

}
