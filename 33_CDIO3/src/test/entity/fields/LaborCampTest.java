package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.*;

public class LaborCampTest {
	LaborCamp laborCampField;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		laborCampField = new LaborCamp("Labor Camp", 2500); // The pit
		player1 = new Player("Morten");
		player2 = new Player("Peter");
//		fleetField = new Fleet("Fleet", 4000); // Second sail
	}

	@After
	public void tearDown() throws Exception {
		laborCampField = null;
		player1 = null;
		player2 = null;
	}

	@Test
	public void testLandOnFieldLC() {
		laborCampField.buyField(player1);
		laborCampField.setDiceSum(10);
		laborCampField.landOnField(player2);
		
		
		
		int expectedPlayer1Balance = 30000 - 2500 + 1000;
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals(expectedPlayer1Balance, actualPlayer1Balance);
		
		int expectedPlayer2Balance = 30000;
	}

}
