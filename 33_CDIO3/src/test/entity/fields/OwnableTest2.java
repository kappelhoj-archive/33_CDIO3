package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.fields.*;
import entity.Player;

public class OwnableTest2 
{
	Player player;
	Territory territory;
	LaborCamp laborCamp;
	Fleet fleet;
	@Before
	public void setUp() throws Exception 
	{
		player = new Player("Susanne");
		territory = new Territory("Territory",5000,500);
		laborCamp = new LaborCamp("Labor Camp",5000);
		fleet = new Fleet("Fleet",5000);
	}

	@After
	public void tearDown() throws Exception 
	{
		player = null;
		territory = null;
		laborCamp = null;
		fleet = null;
	}

	/**
	 * Method test_isFieldOwnedIF tests the if branch of the isFieldOwned method.
	 * The tested method should return false, if the field is not owned.
	 */
	@Test
	public void test_isFieldOwnedIF() 
	{
		// The expected value of isFieldOwned is false.
		boolean expected = false;
		// The actual value of isFieldOwned.
		boolean actual = territory.isFieldOwned();
		
		assertEquals("Expected" + expected + " but was " + actual,expected, actual);
	}
	
	/**
	 * Method test_isFieldOwnedElse tests the else branch of the isFieldOwned method.
	 * The tested method should return true, if the field is owned.
	 */
	@Test
	public void test_isFieldOwnedElse()
	{
		//player buys the territory to set it as its owner.
		territory.buyField(player);
		
		// The expected value of isFieldOwned is true.
		boolean expected = true;
		// The actual value of isFieldOwned.
		boolean actual = territory.isFieldOwned();
		
		assertEquals("Expected" + expected + " but was " + actual,expected, actual);
	}
	
	/**
	 * Method test_buyFieldNoMoney tests the else branch of the buyField method.
	 * The tested method should return false, if the field is not bought.
	 */
	@Test
	public void test_buyFieldNoMoney()
	{
		
	}
	
	/**
	 * Method test_buyFieldTerritory tests the if branch of the buyField method
	 * when a territory is bought.
	 * The tested method should 
	 * - return true
	 * - change the owner of the territory to the player who bought the territory.
	 * - change the fortune (propertyFortune) of the player who bought the territory.
	 * - change the account balance of the player who bought the territory.
	 */
	@Test
	public void test_buyFieldTerritory()
	{
		
	}

	/**
	 * Method test_buyFieldLaborCamp tests the if branch of the buyField method
	 * when a LaborCamp is bought.
	 * The tested method should 
	 * - return true
	 * - change the owner of the LaborCamp to the player who bought the LaborCamp.
	 * - change the fortune (propertyFortune) of the player who bought the LaborCamp.
	 * - change the account balance of the player who bought the LaborCamp.
	 * - increase the amount of labor camps the buyer has by one.
	 */
	@Test
	public void test_buyFieldLaborCamp()
	{
		
	}
	
	/**
	 * Method test_buyFieldFleet tests the if branch of the buyField method
	 * when a Fleet is bought.
	 * The tested method should 
	 * - return true
	 * - change the owner of the Fleet to the player who bought the Fleet.
	 * - change the fortune (propertyFortune) of the player who bought the Fleet.
	 * - change the account balance of the player who bought the Fleet.
	 * - increase the amount of fleets the buyer has by one.
	 */
	@Test
	public void test_buyFieldFleet()
	{
		
	}
	
	/**
	 * Method test_landOnOwnField tests the the "else" branch of the LandOnField method when
	 * a player lands on one of his own fields.
	 * The tested method should do nothing when a player lands on his own field.
	 * OBS The if branch of the method landOnField is tested on 
	 * every type of field in their own test file.
	 */
	@Test
	public void test_landOnOwnField()
	{
		
	}
	
}
