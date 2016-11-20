package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.Fleet;

public class FleetTest {
	Fleet fleetField1;
	Fleet fleetField2;
	Fleet fleetField3;
	Fleet fleetField4;
	Player player1;
	Player player2;

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
	
	@Test
	//Test to see if amount of Fleets owned by a player is correctly added up, so the rent on each Fleet-field rises.
	public void testGetRent() {
		fleetField1.buyField(player1);
		fleetField2.buyField(player1);
		fleetField3.buyField(player1);
		
		int expectedRent = 2000;
		int actualRent = fleetField1.getRent();
		assertEquals(expectedRent, actualRent);
	}

	@Test
	public void testLandOnFieldFleet() {
		fail("Not yet implemented");
	}

}
