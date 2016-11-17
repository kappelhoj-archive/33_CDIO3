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

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
