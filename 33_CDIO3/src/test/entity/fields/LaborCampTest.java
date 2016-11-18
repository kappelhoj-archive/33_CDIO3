package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.*;

public class LaborCampTest {
	LaborCamp laborCampField;
	LaborCamp laborCampField2;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		laborCampField = new LaborCamp("Labor Camp", 2500); // The pit
		laborCampField2 = new LaborCamp("Labor Camp", 2500);
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception {
		laborCampField = null;
		laborCampField2 = null;
		player1 = null;
		player2 = null;
	}
	
	/*
	 * Tests if the Labor Camp field's rent is equal to 100 multiplied by 
	 * the player's dice roll and times the amount of Labor camps owned
	 * by the owner.
	 */
	@Test
	public void testGetRent() {
		laborCampField.buyField(player1);
		laborCampField.buyField(player1);
		laborCampField.setDiceSum(12);
		
		int expectedRent = 100*12*2;
		int actualRent = laborCampField.getRent();
		assertEquals(expectedRent, actualRent);
	}

	/*
	 * Testing if player2 pays the rent equal to his dice roll multiplied
	 * by 100 to the owner of the Labor Camp field.
	 */
	@Test
	public void testLandOnFieldLC() {
		laborCampField.buyField(player1);
		laborCampField.setDiceSum(10);
		laborCampField.landOnField(player2);
		
		int expectedPlayer1Balance = 30000 - 2500 + 10*100;
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals(expectedPlayer1Balance, actualPlayer1Balance);
		
		int expectedPlayer2Balance = 30000 - 10*100;
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals(expectedPlayer2Balance, actualPlayer2Balance);
	}
}
