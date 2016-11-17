package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.*;

public class OwnableTest {
	Territory territoryField;
	LaborCamp laborCampField;
	Fleet fleetField;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		territoryField = new Territory("Territory", 3000, 700); // Cold Desert
		laborCampField = new LaborCamp("Labor Camp", 2500); // The pit
		fleetField = new Fleet("Fleet", 4000); // Second sail
		
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception {
		territoryField = null;
		laborCampField = null;
		fleetField = null;
	}
	
	/*
	 * Testing if a player can buy a field and if his account balance changes.
	 * In this test case, player1 with an account balance of 30000
	 * buys the Territory field "Cold Desert" at a price of 3000.
	 */
	@Test
	public void testBuyField() {
		territoryField.buyField(player1);
		Player expectedOwner = player1;
		Player actualOwner = territoryField.getOwner();
		assertEquals(expectedOwner, actualOwner);
		
		int expectedBalance = 27000;
		int actualBalance = player1.getAccountBalance();
		assertEquals(expectedBalance, actualBalance);
		
//		int expectedFortune = 30000;
//		int actualFortune = player1.getPlayerFortune();
//		assertEquals(expectedFortune, actualFortune);
	}
	
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
	 * Testing if the isFieldOwned method returns true if the field is owned,
	 * and false if not.
	 */
	@Test
	public void testIsFieldOwned() {
		boolean expectedFieldOwner = false;
		boolean actualFieldOwner = territoryField.isFieldOwned();
		assertEquals(expectedFieldOwner, actualFieldOwner);
		
		territoryField.buyField(player1);
		boolean expectedOwner = true;
		boolean actualOwner = territoryField.isFieldOwned();
		assertEquals(expectedOwner, actualOwner);
	}
}
