package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.*;

public class OwnableTest {
	Territory territoryField;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		territoryField = new Territory("Territory", 3000, 700); // Cold Desert
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception {
		territoryField = null;
		player1 = null;
		player2 = null;
	}
	
	/*
	 * Testing if a player can buy a field and if his account balance changes.
	 */
	@Test
	public void testBuyField() {
		territoryField.buyField(player1);
		Player expectedOwner = player1;
		Player actualOwner = territoryField.getOwner();
		assertEquals(expectedOwner, actualOwner);
		
		int expectedBalance = 30000 - 3000;
		int actualBalance = player1.getAccountBalance();
		assertEquals(expectedBalance, actualBalance);
	}
	
	/*
	 * Testing if a field can be bought when the player does not have enough money.
	 */
	@Test
	public void testBuyFieldNoMoney() {
		player1.changeAccountBalance(-30000);
		territoryField.buyField(player1);
		Player expectedOwner = null;
		Player actualOwner = territoryField.getOwner();
		assertEquals(expectedOwner, actualOwner);
	}
	
	/*
	 * Testing if a player loses the correct amount of money when he lands
	 * on a different players field.
	 */
	@Test
	public void testLandOnField() {
		territoryField.buyField(player1);
		territoryField.landOnField(player2);
		
		int expectedPlayer1Balance = 30000 - 3000 + 700;
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals(expectedPlayer1Balance, actualPlayer1Balance);
		
		int expectedPlayer2Balance = 30000 - 700;
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals(expectedPlayer2Balance, actualPlayer2Balance);
	}
	
	/*
	 * The test method testWhenOwnerLandsOnHisOwnField tests the method landOnField. 
	 * When a player who lands on a field that he owns the rent shouldn't be subtracted from his balance.
	 */
	@Test
	public void testWhenOwnerLandsOnHisOwnField()
	{
		// player1 buys a field.
		territoryField.buyField(player1);
		int expectedBalance = 30000 - 3001;
		// Later player1 lands on the field that he owns.
		territoryField.landOnField(player1);
		int actualBalance = player1.getAccountBalance();
		assertEquals("Expected balance after the player landed on his own field is " + expectedBalance + " but was " + actualBalance +".",expectedBalance, actualBalance);
	}

	/*
	 * The test method testIsFieldOwned tests the isFieldOwned method.
	 * This test tests if the method isFieldOwned returns true if the field is owned and false otherwise.
	 */
	@Test
	public void testIsFieldOwned() 
	{
		boolean expectedFieldOwner, actualFieldOwner;
		//Tests the if branch of the method.
		expectedFieldOwner = false;
		actualFieldOwner = territoryField.isFieldOwned();
		assertEquals("Assert 1: The expected field owner was " + expectedFieldOwner+ " But was "+ actualFieldOwner,expectedFieldOwner, actualFieldOwner);
		
		//Tests the else branch of the method.
		territoryField.buyField(player1);
		expectedFieldOwner = true;
		actualFieldOwner = territoryField.isFieldOwned();
		assertEquals("Assert2: The expected field owner was " + expectedFieldOwner + " But was "+ actualFieldOwner,expectedFieldOwner, actualFieldOwner);
	}
}