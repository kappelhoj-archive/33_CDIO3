package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.Fleet;

public class FleetTest {
	Fleet fleetField1, fleetField2, fleetField3, fleetField4;
	Player player1, player2;

	@Before
	public void setUp() throws Exception {
		fleetField1 = new Fleet("Fleet", 4000);
		fleetField2 = new Fleet("Fleet", 4000);
		fleetField3 = new Fleet("Fleet", 4000);
		fleetField4 = new Fleet("Fleet", 4000);
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception {
		fleetField1 = null;
		fleetField2 = null;
		fleetField3 = null;
		fleetField4 = null;
		player1 = null;
		player2 = null;
	}
	
	/*
	 * Testing all Rent values for how many Fleet fields are owned.
	 */
	@Test
	public void testGetRent() {
		// Array with all the Fleet fields
		Fleet[] fleetFields = {fleetField1, fleetField2, fleetField3, fleetField4};
		// Array with the different Fleet rent values
		int[] expectedRents = {500, 1000, 2000, 4000};
		
		// Buy 1 to 4 Fleet fields and check if the Rent values are correct.
		for(int i = 0; i < fleetFields.length; i++)
		{
			fleetFields[i].buyField(player1);
			
			int expectedRent = expectedRents[i];
			int actualRent = fleetField1.getRent();
			assertEquals("Owned Fleet fields: " + (i+1) + " Rent: " + expectedRents[i], expectedRent, actualRent);
			//System.out.println("Owned Fleet fields: " + (i+1) + " Rent: " + expectedRents[i]);
		}
	}
	
	/*
	 * Testing if landOnField for the Fleet field works as intended.
	 */
	@Test
	public void testLandOnFieldFleet() {
		fleetField1.buyField(player1);
		fleetField2.buyField(player1);
		
		fleetField2.landOnField(player2);
		
		// The expected player1 balance is 30000 minus the two Fleet fields
		// he bought (2*4000) plus the 1000 rent price from player2.
		int expectedPlayer1Balance = 30000 - (2*4000) + 1000;
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals(expectedPlayer1Balance, actualPlayer1Balance);
		
		// The expected player2 balance is 30000 minus the 1000 rent price.
		int expectedPlayer2Balance = 30000 - 1000;
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals(expectedPlayer2Balance, actualPlayer2Balance);
	}
}
