package test.entity.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.fields.*;
import entity.Player;

public class OwnableTest 
{
	Player player;
	Territory territory;
	LaborCamp laborCamp;
	Fleet fleet;
	@Before
	public void setUp() throws Exception 
	{
		//Instantiates the objects.
		player = new Player("Susanne");
		territory = new Territory("Territory",5000,500);
		laborCamp = new LaborCamp("Labor Camp",5000);
		fleet = new Fleet("Fleet",5000);
	}

	@After
	public void tearDown() throws Exception 
	{
		//Resets the objects.
		player = null;
		territory = null;
		laborCamp = null;
		fleet = null;
	}

	/**
	 * Test-id: U005
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
	 * Test-id: U006
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
	 * Test-id: U007
	 * Method test_buyFieldNoMoney tests the else branch of the buyField method.
	 * The tested method should return false, if the field is not bought.
	 */
	@Test
	public void test_buyFieldNoMoney()
	{
		//Changes the account balance from 30000 to 1000.
		player.changeAccountBalance(-29000);
		
		// The value expected from buyField is false, because the player cannot afford
		// the territory.
		boolean expected = false;
		// The actual value returned by buyField.
		boolean actual = territory.buyField(player);
		
		assertEquals("The expected value is " + expected + " but was " + actual,expected,actual);
	}
	
	/**
	 * Test-id: U008
	 * Method test_buyFieldTerritory tests the if branch of the buyField method
	 * when a territory is bought.
	 * The tested method should <br>
	 * - return true <br>
	 * - change the owner of the territory to the player who bought the territory. <br>
	 * - change the fortune (propertyFortune) of the player who bought the territory. <br>
	 * - change the account balance of the player who bought the territory.
	 */
	@Test
	public void test_buyFieldTerritory()
	{
		// Expected values when a player buys/has bought a territory field. The player starts with 30000
		// and the price of the territory is 5000.
		boolean expectedBoolean = true;
		Player expectedOwner   = player;
		int expectedPropertyFortune = 5000;
		int expectedAccountBalance = 25000;
		
		// The actual values
		boolean actualBoolean = territory.buyField(player);
		Player actualOwner = territory.getOwner();
		int actualPropertyFortune = player.getPlayerFortune() - player.getAccountBalance();
		int actualAccountBalance = player.getAccountBalance();
		
		assertEquals("The expected value is " + expectedBoolean + " but was " + actualBoolean, expectedBoolean, actualBoolean);
		assertEquals("The expected value is " + expectedOwner + " but was " + actualOwner, expectedOwner, actualOwner);
		assertEquals("The expected value is " + expectedPropertyFortune + " but was " + actualPropertyFortune, expectedPropertyFortune, actualPropertyFortune);
		assertEquals("The expected value is " + expectedAccountBalance + " but was " + actualAccountBalance, expectedAccountBalance, actualAccountBalance);
	}

	/**
	 * Test-id: U009
	 * Method test_buyFieldLaborCamp tests the if branch of the buyField method
	 * when a LaborCamp is bought.
	 * The tested method should <br>
	 * - return true <br>
	 * - change the owner of the LaborCamp to the player who bought the LaborCamp. <br>
	 * - change the fortune (propertyFortune) of the player who bought the LaborCamp. <br>
	 * - change the account balance of the player who bought the LaborCamp. <br>
	 * - increase the amount of labor camps the buyer has by one.
	 */
	@Test
	public void test_buyFieldLaborCamp()
	{
		// Expected values when a player buys/has bought a Labor Camp field. The player starts with 30000
		// and the price of the Labor camp field is 5000.
		boolean expectedBoolean = true;
		Player expectedOwner   = player;
		int expectedPropertyFortune = 5000;
		int expectedAccountBalance = 25000;				
		
		// The actual values
		boolean actualBoolean = laborCamp.buyField(player);
		Player actualOwner = laborCamp.getOwner();
		int actualPropertyFortune = player.getPlayerFortune() - player.getAccountBalance();
		int actualAccountBalance = player.getAccountBalance();
				
		assertEquals("The expected value is " + expectedBoolean + " but was " + actualBoolean, expectedBoolean, actualBoolean);
		assertEquals("The expected value is " + expectedOwner + " but was " + actualOwner, expectedOwner, actualOwner);
		assertEquals("The expected value is " + expectedPropertyFortune + " but was " + actualPropertyFortune, expectedPropertyFortune, actualPropertyFortune);
		assertEquals("The expected value is " + expectedAccountBalance + " but was " + actualAccountBalance, expectedAccountBalance, actualAccountBalance);
	}
	
	/**
	 * Test-id: U010
	 * Method test_buyFieldFleet tests the if branch of the buyField method
	 * when a Fleet is bought.
	 * The tested method should <br>
	 * - return true <br>
	 * - change the owner of the Fleet to the player who bought the Fleet. <br>
	 * - change the fortune (propertyFortune) of the player who bought the Fleet. <br>
	 * - change the account balance of the player who bought the Fleet. <br>
	 * - increase the amount of fleets the buyer has by one. 
	 */
	@Test
	public void test_buyFieldFleet()
	{
		// Expected values when a player buys/has bought a fleet field. The player starts with 30000
		// and the price of the fleet is 5000.
		boolean expectedBoolean = true;
		Player expectedOwner   = player;
		int expectedPropertyFortune = 5000;
		int expectedAccountBalance = 25000;

		// The actual values
		boolean actualBoolean = fleet.buyField(player);
		Player actualOwner = fleet.getOwner();
		int actualPropertyFortune = player.getPlayerFortune() - player.getAccountBalance();
		int actualAccountBalance = player.getAccountBalance();

		assertEquals("The expected value is " + expectedBoolean + " but was " + actualBoolean, expectedBoolean, actualBoolean);
		assertEquals("The expected value is " + expectedOwner + " but was " + actualOwner, expectedOwner, actualOwner);
		assertEquals("The expected value is " + expectedPropertyFortune + " but was " + actualPropertyFortune, expectedPropertyFortune, actualPropertyFortune);
		assertEquals("The expected value is " + expectedAccountBalance + " but was " + actualAccountBalance, expectedAccountBalance, actualAccountBalance);
	}
	
	/**
	 * Test-id: U011
	 * Method test_landOnOwnField tests the landOnField method. 
	 * The tested method should do nothing when a player lands on his own field.
	 * OBS The if branch of the method landOnField is tested on 
	 * every type of field in their own test file.
	 */
	@Test
	public void test_landOnOwnField()
	{	
		//player buys the territory field
		territory.buyField(player);
		//Expected balance after the player has landed on his own field.
		int expectedBalance = player.getAccountBalance();
		
		//player lands on his own field
		territory.landOnField(player);
		
		//Actual balance after the player has landed on his own field.
		int actualBalance = player.getAccountBalance();
		
		assertEquals("The expected balance is " + expectedBalance + " but was " + actualBalance, expectedBalance, actualBalance);
	}
	
}
