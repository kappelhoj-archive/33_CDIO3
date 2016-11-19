package test.entity.fields;

import static org.junit.Assert.*;
import entity.fields.Tax;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.Player;

public class TaxTest {
	Tax taxField1;
	Tax taxField2;
	Player player;
	
	@Before
	public void setUp() throws Exception {
		taxField1 = new Tax("Tax", 2000, 10); // Goldmine
		taxField2 = new Tax("Tax", 4000, 10); // Caravan
		player = new Player("Bob");
	}

	@After
	public void tearDown() throws Exception {
		taxField1 = null;
		taxField2 = null;
		player = null;
	}
	
	/*
	 * Testing if player pays 10% of his fortune when he chooses to pay the taxRate
	 * when he lands on a Tax field.
	 */
	@Test
	public void testLandOnFieldTaxPayTaxRate() {
		player.setPayDecision(true);
		taxField1.landOnField(player);
		
		// The expected player balance is 30000 minus the taxRate (10% of 30000).
		int expectedPlayerBalance = (int)(30000 - (30000*0.1));
		int actualPlayerBalance = player.getAccountBalance();
		
		assertEquals(expectedPlayerBalance, actualPlayerBalance);
	}
	
	/*
	 * Testing if player pays the correct Tax amount when he lands on
	 * tax field 1 (Goldmine), if he chose to pay the Tax amount.
	 */
	@Test
	public void testLandOnFieldTaxPayTaxAmount1() {
		player.setPayDecision(false);
		taxField1.landOnField(player);
		
		// The expected player balance is 30000 minus the taxAmount for tax field 1 (2000).
		int expectedPlayerBalance = 30000 - 2000;
		int actualPlayerBalance = player.getAccountBalance();
		assertEquals(expectedPlayerBalance, actualPlayerBalance);
	}
	
	/*
	 * Testing if player pays the correct Tax amount when he lands on
	 * tax field 2 (Caravan), if he chose to pay the Tax amount.
	 */
	@Test
	public void testLandOnFieldTaxPayTaxAmount2() {
		player.setPayDecision(false);
		taxField2.landOnField(player);
		// The expected player balance is 30000 minus the taxAmount for tax field 2 (4000).
		int expectedPlayerBalance = 30000 - 4000;
		int actualPlayerBalance = player.getAccountBalance();
		assertEquals(expectedPlayerBalance, actualPlayerBalance);
	}
	
//	@Test
//	public void testLandOnFieldTaxPayTaxAmount3() {
//		player.setPayDecision(false);
//		Tax[] taxFields = {taxField1, taxField2};
//		
//		for(int i = 0; i < taxFields.length; i++)
//		{
//			taxFields[i].landOnField(player);
//			int expectedPlayerBalance = 30000 - taxFields[i].getTaxAmount();
//			int actualPlayerBalance = player.getAccountBalance();
//			assertEquals("Tax Field: " + (i+1),expectedPlayerBalance, actualPlayerBalance);
//		}	
//	}
}
