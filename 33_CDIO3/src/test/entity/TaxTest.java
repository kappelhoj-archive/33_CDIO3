package test.entity;



import static org.junit.Assert.*;
import entity.fields.Tax;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.Player;




public class TaxTest {

	Tax tax;
	Tax tax2;


	Player player;



	@Before
	public void setUp() throws Exception {
		player = new Player ("bob");
		tax = new Tax ("The pit",2000, 10);
		tax2 = new Tax ("Goldmine",4000, 10);
	}

	@After
	public void tearDown() throws Exception {
		player = null;
		tax = null;
		tax2 = null;
	}

	@Test
	public void testTaxRate() {

		player.setPayDecision(true);

		int expected = 3000;

		tax.landOnField(player);

		int actual = 30000 - player.getAccountBalance();

		assertEquals(expected, actual);
	}
	
		@Test
		public void testTaxConstant() {

			player.setPayDecision(false);

			int expected = 4000;

			tax2.landOnField(player);

			int actual = 30000 - player.getAccountBalance();

			assertEquals(expected, actual);

		}
	}
