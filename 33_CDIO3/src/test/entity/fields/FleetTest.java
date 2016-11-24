package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.Fleet;

public class FleetTest {
	Fleet fleet1, fleet2, fleet3, fleet4;
	Player player1, player2;

	@Before
	public void setUp() throws Exception 
	{
		//Instantiates four fleet fields and two players.
		fleet1 = new Fleet("Fleet", 4000);
		fleet2 = new Fleet("Fleet", 4000);
		fleet3 = new Fleet("Fleet", 4000);
		fleet4 = new Fleet("Fleet", 4000);
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resets the objects.
		fleet1 = null;
		fleet2 = null;
		fleet3 = null;
		fleet4 = null;
		player1 = null;
		player2 = null;
	}
	
	/**
	 * Test-id: U001
	 * Method testGetRentFleet tests if the getRent method in the Fleet class returns the correct 
	 * rent based on the amount of fleets owned by the player.
	 */
	@Test
	public void testGetRentFleet() 
	{
		// Instantiates a fleet[] containing all the fleets.
		Fleet[] fleetFields = {fleet1, fleet2, fleet3, fleet4};
		// Instantiates a int[] containing the expected rents when 1,2,3 and 4 fleets are owned.
		int[] expectedRents = {500, 1000, 2000, 4000};
		
		// This for-loop buys 1 fleet at a time and checks if the rent is correct when landed on.
		// Buy 1 to 4 Fleet fields and check if the Rent values are correct.
		for(int i = 0; i < fleetFields.length; i++)
		{
			// player1 buys one fleet per iteration.
			fleetFields[i].buyField(player1);
			// The expected rent with i fleet fields.
			int expectedRent = expectedRents[i];
			// The actual rent with i fleet fields.
			int actualRent = fleet1.getRent();
			assertEquals("Amount of owned fleet fields are " + (i+1) + " The expected rent is: " + expectedRents[i] + " but was " + actualRent, expectedRent, actualRent);
		}
	}
	
	/**
	 * Test-id: U002
	 * Method testLandOnFieldFleet tests if the correct things happens when a player lands on a fleet field.
	 * (This method doesn't test the part of the the landOnField method that gives you the opportunity
	 * to buy the field.)
	 * In short the tested method is landOnField in the Fleet class.
	 */
	@Test
	public void testLandOnFieldFleet() 
	{
		// player1 buys fleet1 and fleet2.
		fleet1.buyField(player1);
		fleet2.buyField(player1);
		// player2 lands on fleet2
		fleet2.landOnField(player2);
		
		// Checks if the balance of player1 is updated correctly.
		
		// The expected balance of player1 is 30000 minus the two Fleet fields that he bought (2*4000) 
		// plus the 1000 rent from player2.
		int expectedPlayer1Balance = 30000 - (2*4000) + 1000;
		//The actual balance of player1
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals("The balance of player1 was expected to be " + expectedPlayer1Balance +  " but was " + actualPlayer1Balance,expectedPlayer1Balance, actualPlayer1Balance);
		
		//Checks if the balance of player2 is updated correctly.
		
		// The expected balance of player2 is 30000 minus the rent (1000).
		int expectedPlayer2Balance = 30000 - 1000;
		//The actual balance of player2
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals("The balance of player 2 was expected to be " + expectedPlayer2Balance + " but was " + actualPlayer2Balance,expectedPlayer2Balance, actualPlayer2Balance);
	}
}
