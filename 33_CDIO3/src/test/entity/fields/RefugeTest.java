package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.fields.*;
import entity.Player;

public class RefugeTest {

	Refuge refuge;
	Player player;


	@Before
	public void setUp() throws Exception 
	{
		//Instantiates a Refuge field and one player.
		refuge = new Refuge ("Walled City", 5000);
		player = new Player ("Peter");
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resets the objects.
		refuge = null;
		player = null;
	}

	
	/**
	 * Method testLandOnFieldRefuge tests if the correct things happens when a player lands on a refuge field.
	 * In short the tested method is landOnField in the Refuge class.
	 */
	@Test
	public void testLandOnField() 
	{ 
		// player lands on refuge field.
		refuge.landOnField(player);
		
		//Checks if the balance of player is updated correctly.
		
		//The expected balance of player is 30000 + the bonus received from the refuge field (5000).
		int expectedPlayerBalance = 30000 + 5000;
		//The actual balance of player
		int actualPlayerBalance = player.getAccountBalance();
		assertEquals("The balance of player was expected to be " + expectedPlayerBalance + " but was " + actualPlayerBalance, expectedPlayerBalance, actualPlayerBalance);

	}
}
