package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.fields.Fleet;

public class PlayerTest2 
{
	Player player, owner;
	Fleet fleet1, fleet2;
	@Before
	public void setUp() throws Exception 
	{
		player = new Player("Susanne");
		owner = new Player("Henrik");
		fleet1 = new Fleet("Fleet", 5000);
		fleet2 = new Fleet("Fleet", 3700);
		
	}

	@After
	public void tearDown() throws Exception 
	{
		player = null;
		owner = null;
		fleet1 = null;
		fleet2 = null;
	}

	/**
	 * Method test_getPlayerFortuneNoFields tests the method getPlayerFortune under 
	 * the condition that the player owns no field.
	 * The method should return the account balance of the player when no fields is own.
	 */
	@Test
	public void test_getPlayerFortuneNoFieldsOwned() 
	{
		// expected value of the players fortune is the value of the player's account balance
		// when no fields is owned.
		int expectedPlayerFortune = player.getAccountBalance();
		// The actual player fortune.
		int actualPlayerFortune = player.getPlayerFortune();
		
		assertEquals("The expected player fortune is " + expectedPlayerFortune + " but was " + actualPlayerFortune, expectedPlayerFortune, actualPlayerFortune);
	}

	/**
	 * Method test_getPlayerFortuneNoFields tests the method getPlayerFortune under 
	 * the condition that the player owns two fields.
	 * The method should return the account balance plus the propertyFortune which 
	 * is the sum of the prices given for the owned fields.
	 */
	@Test
	public void test_getPlayerFortuneFieldsOwned() 
	{
		// player1 buys two fleet fields. which cost 5000 and 3700
		fleet1.buyField(player);
		fleet2.buyField(player);
		
		//player1 receives 4000 otherwise the playerFortune is equal to the account balance 
		// before the fields was bought
		player.changeAccountBalance(4000);
		
		// expected value of the players fortune is the value of account balance 
		// plus the propertyFortune which is the sum of the prices given for the owned fields.
		int expectedPlayerFortune = player.getAccountBalance() + 3700 + 5000;
		// The actual player fortune.
		int actualPlayerFortune = player.getPlayerFortune();
		
		assertEquals("The expected player fortune is " + expectedPlayerFortune + " but was " + actualPlayerFortune, expectedPlayerFortune, actualPlayerFortune);
	}
	
	/**
	 * Method test_payRentIF tests the if branch of the method payRent.
	 * The tested method should  <br>
	 * - Change the balance of the owner with rent <br>
	 * - Change the balance of the player with -rent
	 */
	@Test
	public void test_payRentIF()
	{
		// The expected value of the owner's account balance and the player's account balance
		// when the player pays 1000 in rent to the owner.
		int expectedOwnerBalance = 30000 + 1000;
		int expectedPlayerBalance = 30000 - 1000;
		player.payRent(owner, 1000);
		
		int actualOwnerBalance = owner.getAccountBalance();
		int actualPlayerBalance = player.getAccountBalance();
		
		assertEquals("The expected owner balance is " + expectedOwnerBalance + " but was " + actualOwnerBalance, expectedOwnerBalance, actualOwnerBalance);
		assertEquals("The expected owner balance is " + expectedPlayerBalance + " but was " + actualPlayerBalance, expectedPlayerBalance, actualPlayerBalance);
	}
	
	/**
	 * Method test_payRentElse tests the else branch of the method payRent.
	 * The tested method should <br>
	 * - Change the balance of the owner with the balance of the player <br>
	 * - sets the players value of hasLost to true.
	 */
	@Test
	public void test_payRentElse()
	{
		// Changes the players balance to 500.
		player.changeAccountBalance(-29500);
		
		// The expected value of the owner's account balance and the player's account balance
		// when the player pays 1000 in rent to the owner.
		int expectedOwnerBalance = 30000 + 500;
		boolean expectedPlayerHasLost = true;
		player.payRent(owner, 1000);
		
		int actualOwnerBalance = owner.getAccountBalance();
		boolean actualPlayerHasLost = player.getPlayerHasLost();
		
		assertEquals("The expected owner balance is " + expectedOwnerBalance + " but was " + actualOwnerBalance, expectedOwnerBalance, actualOwnerBalance);
		assertEquals("The expected owner balance is " + expectedPlayerHasLost + " but was " + actualPlayerHasLost, expectedPlayerHasLost, actualPlayerHasLost);
	}
}
