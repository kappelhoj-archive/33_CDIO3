package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.*;

public class LaborCampTest {
	LaborCamp laborCamp1;
	LaborCamp laborCamp2;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() throws Exception 
	{
		//Instantiates two Labor Camp fields and two players.
		laborCamp1 = new LaborCamp("Labor Camp", 2500);
		laborCamp2 = new LaborCamp("Labor Camp", 2500);
		player1 = new Player("Morten");
		player2 = new Player("Peter");
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resets the object.
		laborCamp1 = null;
		laborCamp2 = null;
		player1 = null;
		player2 = null;
	}
	
	
	/**
	 * Test-id: U003
	 * Method testGetRentLC tests if the getRent method in the Labor Camp class returns the correct
	 * rent based on the amount of Labor camps owned by the player and the sum of the dice.
	 */
	@Test
	public void testGetRentLC() 
	{
		//Gives player1 and player2 some extra money.
		player1.changeAccountBalance(10000000);
		player2.changeAccountBalance(10000000);
		
		// Instantiates a LaborCamp[] containing all Labor Camps.
		LaborCamp[] laborCamps = {laborCamp1,laborCamp2};
		// Instantiates a int[] containing all the possibility dice sums our dice can have.
		int[] diceSums = {2,3,4,5,6,7,8,9,10,11,12};
		// Instantiates a variable containing the base rent of a labor camp.
		int baseRent = 100;
		// Instantiates a variable containing the amount of Labor Camp fields in the game.
		int amountOfLaborCamps = 2;
		
		for (int i = 0; i < amountOfLaborCamps; i++)
		{
			//player1 buys one labor camp per iteration.
			laborCamps[i].buyField(player1);
			for(int diceSum : diceSums)
			{
				// The expected rent with i amount of labor camps with a base rent of 100 
				// and a dice sum of diceSum.
				int expectedRent = diceSum * player1.getAmountOfLaborCamps() * baseRent;
				// The actual rent.
				laborCamp1.setDiceSum(diceSum);
				int actualRent = laborCamp1.getRent();
				assertEquals("The expected rent is " + expectedRent + " but was " + actualRent + ".",expectedRent, actualRent);
			}
		}
	}

	
	/**
	 * Test-id: U004
	 * Method testLandOnFieldLC tests if the correct things happens when a player lands on a Labor camp field.
	 * (This method doesn't test the part of the the landOnField method that gives you the opportunity
	 * to buy the field.)
	 * In short the tested method is landOnField in the LaborCamp class.
	 */
	@Test
	public void testLandOnFieldLC() 
	{
		// player1 buys laborCamp1
		laborCamp1.buyField(player1);
		// Simulates that player2 rolled the dice with a diceSum of 10.
		laborCamp1.setDiceSum(10);
		// player2 lands on laborCamp1
		laborCamp1.landOnField(player2);
		
		// Checks if the balance of player1 is updated correctly.
		
		// The expected balance of player1 is 30000 minus the price of laborCamp1 (2500)
		// plus the rent from player2 (1000).
		int expectedPlayer1Balance = 30000 - 2500 + 1000;
		// The actual balance of player 1
		int actualPlayer1Balance = player1.getAccountBalance();
		assertEquals("The balance of player1 was expected to be " + expectedPlayer1Balance +  " but was " + actualPlayer1Balance,expectedPlayer1Balance, actualPlayer1Balance);
		
		//Checks if the balance of player2 is updated correctly.
		
		// The expected balance of player2 is 30000 minus the rent.
		int expectedPlayer2Balance = 30000 - 1000;
		int actualPlayer2Balance = player2.getAccountBalance();
		assertEquals("The balance of player 2 was expected to be " + expectedPlayer2Balance + " but was " + actualPlayer2Balance,expectedPlayer2Balance, actualPlayer2Balance);
	}
}
