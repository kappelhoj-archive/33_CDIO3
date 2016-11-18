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
	public void testLandOnField() { 
		 player.changeAccountBalance(refuge.getBonus());
		 int expected = 35000;
		 int actual = player.getAccountBalance();
		 assertEquals(expected, actual);
	}


	@Test
	public void testRefuge() {
	}

}
