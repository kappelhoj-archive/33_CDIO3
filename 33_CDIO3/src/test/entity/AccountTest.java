package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Account;

public class AccountTest {
	Account account;
	
	@Before
	public void setUp() throws Exception 
	{
		account = new Account(30000);
	}

	@After
	public void tearDown() throws Exception 
	{
		account = null;
	}
		
	/**
	 * Method test_ChangeBalanceElseSubtraction tests the else branch of the changeBalance method
	 * under the condition that the change is a negative value.
	 * The tested method should return the balance - value, where the value is a negative number.
	 */
	@Test
	public void test_ChangeBalanceElseSubtraction() 
	{
		//Changes the balance with minus 2000.
		account.changeBalance(-2000);
		
		//The expected balance after the call to changeBalance(-2000)
		int expectedBalance = 28000;
		//The actualBalance
		int actualBalance = account.getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	/**
	 * Method test_ChangeBalanceElseAddition tests the else branch of the changeBalance method
	 * under the condition that the change is a positive value.
	 * The tested method should return the balance + value, where the value is positive number.
	 */
	@Test
	public void test_ChangeBalanceAddition()
	{
		//Changes the balance with plus 2000.
		account.changeBalance(2000);
		
		//The expected balance after the call to changeBalance(2000)
		int expectedBalance = 32000;
		//The actualBalance
		int actualBalance = account.getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	/**
	 * Method test_changeBalanceOverflow tests the if branch of the changeBalance method
	 * under the condition that the balance is the value of Integer.MAX_VALUE.
	 * The tested method should return the balance as it was before 
	 * the value was added to the balance
	 */
	@Test
	public void test_ChangeBalanceOverflow()
	{
		//Sets the account balance to the value of Integer.MAX_VALUE
		account.setBalance(Integer.MAX_VALUE);
		//Adds 2000 to the balance.
		account.changeBalance(2000);
		
		//The expected account balance is Integer.MAX_VALUE
		int expectedBalance = Integer.MAX_VALUE;
		//The actual account balance
		int actualBalance = account.getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	/**
	 * Method test_changeBalanceUnderflow tests the if branch of the changeBalance method
	 * under the condition that the balance is the value of Integer.MIN_VALUE.
	 * The tested method should return the balance as it was before 
	 * the value was added to the balance
	 */
	@Test
	public void test_ChangeBalanceUnderflow()
	{
		//Sets the account balance to the value of Integer.MAX_VALUE
		account.setBalance(Integer.MIN_VALUE);
		//Subtracts 2000 to the balance.
		account.changeBalance(-2000);

		//The expected account balance is Integer.MAX_VALUE
		int expectedBalance = Integer.MIN_VALUE;
		//The actual account balance
		int actualBalance = account.getBalance();

		assertEquals(expectedBalance, actualBalance);
	}
}
