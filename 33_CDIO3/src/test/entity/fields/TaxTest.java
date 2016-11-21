package test.entity.fields;

import static org.junit.Assert.*;
import entity.fields.Tax;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.Player;

public class TaxTest {
	Tax taxField;
	Player player;
	
	@Before
	public void setUp() throws Exception 
	{
		taxField = new Tax("Tax", 2000, 10);
		player = new Player("Bob");
	}

	@After
	public void tearDown() throws Exception 
	{
		taxField = null;
		player = null;
	}
	
	/*
	 * Test method testLandOnField_TaxRate tests if the player pays the correct taxRate 
	 * when the player chooses to pay taxRate instead of taxAmount when he lands on a taxField.
	 * The test also tests that the player fortune is updated correctly.
	 */
	@Test
	public void testLandOnField_TaxRate() 
	{
		// The expected player balance is 30000 minus the taxRate (10% of 30000).
		int expectedPlayerBalance = (int)(player.getAccountBalance() - (player.getAccountBalance()*taxField.getTaxRate() / 100));
		// The expected player fortune is 30000 minus the taxRate (10% of 30000).
		int expectedPlayerFortune = (int)(player.getAccountBalance() - (player.getAccountBalance()*taxField.getTaxRate() / 100));
		
		//player decides to pay taxRate.
		player.setPayDecision(true);
		//player lands on taxField				
		taxField.landOnField(player);
		int actualPlayerBalance = player.getAccountBalance();
		int actualPlayerFortune = player.getPlayerFortune();
		
		assertEquals("The expectedPlayerBalance was " + expectedPlayerBalance + ". The actualPlayerBalance was " + actualPlayerBalance + ".",expectedPlayerBalance, actualPlayerBalance);
		assertEquals("The expectedPlayerFortune was " + expectedPlayerFortune + ". The actualPlayerFortune was " + actualPlayerFortune + ".",expectedPlayerFortune, actualPlayerFortune);
	}
	
	/*
	 * Test method testLandOnField_TaxAmount tests if the player pay the correct taxAmount
	 * when the player chooses to pay taxAmount instead of taxRate when he lands on a taxField.
	 * The test also tests that the player fortune is updated correctly.
	 */
	@Test
	public void testLandOnField_TaxAmount() 
	{
		// The expected player balance is 30000 minus the taxAmount for the tax field, in this case 2000.
		int expectedPlayerBalance = player.getAccountBalance() - taxField.getTaxAmount();
		// The expected player fortune is 30000 minus the taxAmount for the tax field, in this case 2000.
		int expectedPlayerFortune = player.getAccountBalance() - taxField.getTaxAmount();
		
		//player decides to pay tax amount.
		player.setPayDecision(false);
		//player lands on the taxField.
		taxField.landOnField(player);
		int actualPlayerBalance = player.getAccountBalance();
		int actualPlayerFortune = player.getPlayerFortune();
		
		assertEquals("The expectedPlayerBalance was " + expectedPlayerBalance + ". The actualPlayerBalance was " + actualPlayerBalance + ".",expectedPlayerBalance, actualPlayerBalance);
		assertEquals("The expectedPlayerFortune was " + expectedPlayerFortune + ". The actualPlayerFortune was " + actualPlayerFortune + ".",expectedPlayerFortune, actualPlayerFortune);
	}
}
