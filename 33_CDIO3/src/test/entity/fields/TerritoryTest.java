package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.Territory;

public class TerritoryTest 
{

	Territory territory; 
	Player player1, player2;
	@Before
	public void setUp() throws Exception 
	{
		//Instantiates one territory and one player.
		territory = new Territory("territory",5000,500);
		player1 = new Player("Gurli");
		player2 = new Player("Susanne");
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resets the objects.
		territory = null;
		player1 = null;
	}

	/**
	 * Test-id: U015
	 * Method testGetRentTerritory tests if the getRent method in the Territory class returns the correct 
	 * rent.
	 */
	@Test
	public void testGetRentTerritory() 
	{
		// player buys one territory.
		territory.buyField(player1);
		
		// The expected rent
		int expectedRent = 500;
		// The actual rent
		int actualRent = territory.getRent();
		assertEquals("The expected rent is " + expectedRent + " but was " + actualRent,expectedRent,actualRent);
	}

	
	/**
	 * Test-id: U016
	 * Method testLandOnFieldTerritory tests if the correct things happens when a player lands on a territory field.
	 * (This method doesn't test the part of the the landOnField method that gives you the opportunity
	 * to buy the field.)
	 * In short the tested method is landOnField in the territory class.
	 */
	@Test
	public void testLandOnFieldTerritory()
	{
		// player1 buys territory
		territory.buyField(player1);
		// player2 lands on territory
		territory.landOnField(player2);
		
		// Checks if the balance of player1 is updated correctly.
		
		// The expected balance of player1 is 30000 minus the price of the territory (5000)
		// plus the rent from player2 (500)
		int expectedPlayer1Balance = 30000 - 5000 + 500;
		//The actual balance of player1
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals("The balance of player1 was expected to be " + expectedPlayer1Balance + " but was " + actualPlayer1Balance,expectedPlayer1Balance,actualPlayer1Balance);
		
		// Checks if the balance of player2 is updated correctly.
		
		// The expected balance of player2 is 30000 minus the (500)
		int expectedPlayer2Balance = 30000 - 500;
		// The actual balance of player2
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals("The balance of player2 was expected to be " + expectedPlayer2Balance + " but was " + actualPlayer2Balance,expectedPlayer2Balance,actualPlayer2Balance);
	}
	
}
