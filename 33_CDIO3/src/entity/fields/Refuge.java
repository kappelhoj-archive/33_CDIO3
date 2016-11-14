package entity.fields;

import entity.Player;

public class Refuge extends Field 
{
	//Instance variables
	private int bonus;

	/**
	 * Object refuge constructor
	 * @param fieldName The name of the refuge field
	 * @param bonus The bonus that the refuge field gives.
	 */
	public Refuge(String fieldName, int bonus)
	{
		super(fieldName);
		this.bonus = bonus;
	}
	
	/**
	 * Method landOnField decides what to be done when player lands on a refuge Field.
	 * @param player The player to land on the field.
	 */
	public void landOnField(Player player)
	{
		player.changeAccountBalance(bonus); //Gives the player a bonus to his balance.
	}
}

