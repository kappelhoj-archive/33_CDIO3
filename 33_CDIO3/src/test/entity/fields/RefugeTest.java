package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.fields.*;
import entity.Player;

public class RefugeTest {

	Refuge refuge;
	Refuge refuge2;
	Player player;


	@Before
	public void setUp() throws Exception {
		refuge = new Refuge ("Walled City", 5000);
		refuge2 = new Refuge ("Monestary", 500);
		player = new Player ("Peter");
	}

	@After
	public void tearDown() throws Exception {
		refuge = null;
		refuge2 = null;
	}

	@Test
	/**
	 * Simple test to see if the players fund is given the correct values from the Refuge class.
	 * First is added the 5000 gold from the "Walled City"-field, and then the 500 gold from
	 * the "Monestary"-field.
	 */
	public void testLandOnField() { 
		player.changeAccountBalance(refuge.getBonus());
		int expected = 35000;
		int actual = player.getAccountBalance();
		assertEquals(expected, actual);

		player.changeAccountBalance(refuge2.getBonus());
		int expected2 = 35500;							//The new value with an added 500 gold.
		int actual2 = player.getAccountBalance();		//We use the same balance as before to verify that the balance from before is correctly added.
		assertEquals(expected2, actual2);
	}
}
