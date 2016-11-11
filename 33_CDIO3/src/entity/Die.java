package entity;

public class Die 
{
	//Constants
	public final int MAX_VALUE; //The max value of a die.
	
	//Instance variables
	private int value;

	/**
	 * Object Die constructor.
	 * Constructs a 6 sided die.
	 */
	public Die() 
	{
		MAX_VALUE = 6;
		value = rollDie();
	}

	/**
	 * Object die constructor.
	 * Constructs a n sided die. 
	 * If the parameter given is less than 1, the constructor constructs a
	 * 6-sided die. If the parameter overflows, the constructor constructs a
	 * 6-sided die.
	 * @param sides The amount of sides you want the die to have.
	 */
	public Die(int sides) 
	{
		if (sides < 1) 
		{
			MAX_VALUE = 6;
			value = rollDie();
		} 
		else 
		{
			MAX_VALUE = sides;
			value = rollDie();
		}
	}

	/**
	 * Method rollDie sets the face value of the die to a random integer between 1-MAX_VALUE.
	 * @return Returns the newly rolled value of the die.
	 */
	public int rollDie() 
	{
		value = (int) (Math.random() * MAX_VALUE + 1); // generates a random value between 1-MAX_VALUE.
		return value;
	}

	/**
	 * Method getValue returns the face value of the die.
	 * @return Returns the current face value of the die.
	 */
	public int getValue() 
	{
		return value;
	}

	/**
	 * Method toString returns a string representation of the die.
	 */
	public String toString() 
	{
		return "The value of the die is: " + value;
	}

	/**
	 * Method setValue sets the face value of the die. NB: This method is only
	 * used when testing the Die class and is therefore not seen in the
	 * diagrams.
	 * @param value The face value to be set.
	 */
	public void setValue(int value) 
	{
		this.value = value;
	}
}
