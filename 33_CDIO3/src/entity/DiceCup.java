package entity;

import entity.Die;

public class DiceCup 
{	
	private Die d1;
	private Die d2;
	
	/**
	 * DiceCup constructor. The diceCup object contains two dice.
	 */
	public DiceCup()
	{
		d1 = new Die();
		d2 = new Die();
	}
	
	/**
	 * Method rollDice rolls both dice in the DiceCup object.
	 */
	public void shakeCup()
	{
		d1.rollDie();
		d2.rollDie();
	}


	/**
	 * Method getDiceValue returns the value of the rolled dice as a integer array.
	 * @return Array with the two dice values.
	 */
	public int[] getDiceValue()
	{
		int[] array = {d1.getValue(), d2.getValue()};
		return array;
	}	
}
