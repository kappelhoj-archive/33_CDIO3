package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;



public class PlayerTest 
{

	Player player;
	Player player2;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Peter");   //Player to be paying rent.
		player2 = new Player("Simon");  //Player to be payed rent.
	}

	@After
	public void tearDown() throws Exception {
		player = null;
		player2 = null;
	}

	@Test
	/**
	 * Simple test to see if the player name is correctly read into the player class.
	 */
	public void testGetPlayerName() {
		String expected = "Peter";
		String actual = player.getPlayerName();
		assertEquals(expected,actual);
	}

	@Test
	/**
	 * Test to see if the bonus from the Refuge field is correctly added to the player's fortune,
	 * i.e. the players liquid cash amount.
	 */
	public void testChangePlayerFortune() {
		int value = 5000;
		
		player.changePropertyFortune(value);
		
		int expected = 35000;
		int actual = player.getPlayerFortune();
		assertEquals(expected, actual);
	}

	@Test 
	/**
	*Test to see if the first player's balance is correctly subtracted funds,
	*and the second player's balance is correctly added funds.
	*/
	public void testPayRent() {
		int rent = 4000;
		player.payRent(player2, rent);
		int expected = 26000;		//The expected balance after subtracting 4000 from 30000.
		int actual = player.getAccountBalance();
		assertEquals(expected, actual);		//Checking the first player's account balance. 
		
		int expected1 = 34000;		//The expected balance after adding 4000 to 30000.
		int actual1 = player2.getAccountBalance();
		assertEquals(expected1, actual1);		//Checking the second player's account balance.
		
		
	}

}
