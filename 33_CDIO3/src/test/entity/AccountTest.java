package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Account;

public class AccountTest {
	Account account;
	
	@Before
	public void setUp() throws Exception {
		account = new Account(30000);
	}

	@After
	public void tearDown() throws Exception {
		account = null;
	}
	
	/*
	 * Testing getBalance method
	 */
	@Test
	public void testGetBalance() {
		int expected = 30000;
		int actual = account.getBalance();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing if the changeBalance method subtracts correctly from
	 * balance when a player has to pay another player.
	 * In this test case, player1 owns 3 Fleet fields, and player2
	 * lands on any of player1's Fleet fields and therefore has to pay 2000
	 * to player1. 
	 */
	@Test
	public void testChangeBalanceSubtraction() {
		int value = -2000;
		account.changeBalance(value);
		
		int expectedBalance = 28000;
		int actualBalance = account.getBalance();
		assertEquals(expectedBalance, actualBalance);
	}
	
	/*
	 * Testing if the changeBalance method adds correctly to balance when
	 * a player receives money.
	 * In this test case, the player lands on "Walled City" field and receives
	 * 5000 money. 
	 */
	@Test
	public void testChangeBalanceAddition()
	{
		int value = 5000;
		account.changeBalance(value);
		
		int expectedBalance = 35000;
		int actualBalance = account.getBalance();
		assertEquals(expectedBalance, actualBalance);
	}
	
	/*
	 * Testing if the changeBalance method operates correctly when
	 * the balance overflows.
	 * In this test cast the player's account balance is the maximum integer
	 * value and he then lands on "Walled City" field and receives 5000 money.
	 */
	@Test
	public void testChangeBalanceOverflow()
	{
		int value = 5000;
		account.setBalance(Integer.MAX_VALUE);
		
		account.changeBalance(value);
		int expectedBalance = Integer.MAX_VALUE;
		int actualBalance = account.getBalance();
		assertEquals(expectedBalance, actualBalance);
	}
	
	/*
	 * Testing if the changeBalance method operates correctly when the
	 * balance underflows.
	 * In this test case the player's account balance is the minimum integer
	 * value and he then has to pay 2000 money.
	 */
	@Test
	public void testChangeBalanceUnderflow()
	{
		int value = -2000;
		account.setBalance(Integer.MIN_VALUE);
		
		account.changeBalance(value);
		int expectedBalance = Integer.MIN_VALUE;
		int actualBalance = account.getBalance();
		assertEquals(expectedBalance, actualBalance);
	}
}
