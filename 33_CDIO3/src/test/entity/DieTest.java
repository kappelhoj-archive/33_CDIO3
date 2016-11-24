package test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Die;

public class DieTest 
{

	Die d1;

	@Before
	public void setUp() throws Exception 
	{
		d1 = new Die(6);
	}

	@After
	public void tearDown() throws Exception 
	{
		d1 = null;
	}
	
	/**
	 * Test-id: U022.
	 * Tests if the method rollDie gives the probability of a fair die with 6 sides.
	 */
	@Test
	public void testRollDieFairness() 
	{
		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, faceValue = 0;
		final int TOTALROLLS = 60000;
		final int FAILRATE = 400; // 400 = 4% of 10000, where 10000 1/6 of TOTALROLLS
		final int SJETTEDEL = TOTALROLLS / 6;
		
		for (int i = 0; i <= TOTALROLLS; i++)
		{
			faceValue = d1.rollDie();
			switch (faceValue)
			{
			case (1): one++;   break;
			case (2): two++;   break;
			case (3): three++; break;
			case (4): four++;  break;
			case (5): five++;  break;
			case (6): six++;   break;
			default: fail("The value of the die was higher than 6 or lower than 1. It was" + d1);
			}
		}
		boolean fairOne   = FAILRATE > Math.abs(SJETTEDEL - one);
		boolean fairTwo   = FAILRATE > Math.abs(SJETTEDEL - two);
		boolean fairThree = FAILRATE > Math.abs(SJETTEDEL - three);
		boolean fairFour  = FAILRATE > Math.abs(SJETTEDEL - four);
		boolean fairFive  = FAILRATE > Math.abs(SJETTEDEL - five);
		boolean fairSix   = FAILRATE > Math.abs(SJETTEDEL - six);
		
		if (!(fairOne && fairTwo && fairThree && fairFour && fairFive && fairSix))
			fail("The die was not fair.\n"
					+ "The value of fairOne was" + fairOne + "\n" 
					+ "The value of fairTwo was" + fairTwo + "\n"
					+ "The value of fairThree was" + fairThree + "\n"
					+ "The value of fairFour was" + fairFour + "\n"
					+ "The value of fairFive was" + fairFive + "\n"
					+ "The value of fairSix was" + fairSix);
		
		
	}
	
	/**
	 * Test-id: U023.
	 * Tests if the method rollDie only show facevalues between 1 and 6 of the die. Both inclusive.
	 * In short, checks if the die is an 6-side die
	 */
	@Test
	public void testRollDie() 
	{
		int value;
		int MINIMUM_VALUE_DIE = 1;
		int MAXIMUM_VALUE_DIE = 6;
		for(int i = 0; i < 100; i++)
		{
			value = d1.rollDie();
			if(value < MINIMUM_VALUE_DIE || value > MAXIMUM_VALUE_DIE)
				fail("The value of the die was higher than 6 or lower than 1. It was:" + d1);
		}
	}
	
	/**
	 * Test-id: U024.
	 * Tests if the method getValue returns the correct face value of the die.
	 */
	@Test
	public void testGetValue() 
	{
	int expected = 4;
	d1.setValue(4);
	int actual = d1.getValue();
	assertEquals(expected, actual);
	}
	
	/**
	 * Test-id: U025
	 * Tests if the method toString creates the correct string representation of a die-object.
	 */
	@Test
	public void testToString() 
	{
	String expected = "The value of the die is: 4";
	d1.setValue(4);
	String actual = d1.toString();
	assertEquals(expected, actual);
	}

	/**
	 * Test-id: U026
	 * Tests if the constructor that constructs a die with n sides, works properly.
	 */
	@Test
	public void testConstructor()
	{
		Die dieN = new Die(-1);
		Die dieOverflow = new Die(Integer.MAX_VALUE + 1 );
		Die fiftySidedDie = new Die(50);
		int maxValueDieN = -1;
		int maxValueOverflowDieN = Integer.MAX_VALUE +1;
		int maxValueFiftySidedDie = 0;
		
		
		for (int i = 0; i < 50000; i++)
		{
			int newValueDieN = dieN.rollDie();
			maxValueDieN = Math.max(maxValueDieN, newValueDieN);
			int newValueOverflowDieN = dieOverflow.rollDie();
			maxValueOverflowDieN = Math.max(maxValueOverflowDieN, newValueOverflowDieN);
			int newValueFiftySidedDie = fiftySidedDie.rollDie();
			maxValueFiftySidedDie = Math.max(maxValueFiftySidedDie, newValueFiftySidedDie);
		}
		
		if (maxValueDieN != 6 && maxValueOverflowDieN != 6 && maxValueFiftySidedDie != 50)
		{
			fail("The constructor did not work properly");
		}
	}
	
}