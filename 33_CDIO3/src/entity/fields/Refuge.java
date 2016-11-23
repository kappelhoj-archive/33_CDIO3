package entity.fields;

import entity.Player;

public class Refuge extends Field 
{
	//Instance variables
	private int bonus;

	/**
	 * Object refuge constructor.
	 * @param type The type of the field
	 * @param bonus The bonus that the refuge field gives.
	 */
	public Refuge(String type, int bonus)
	{
		super(type);
		this.bonus = bonus;
	}
	
	/**
	 * Method getBonus returns the bonus that the refuge field gives to the affected player.
	 * @return Returns bonus.
	 */
	public int getBonus() 
	{
		return bonus;
	}
	
	/**
	 * Method landOnField decides what is to be done, when a player lands on a refuge Field.
	 * @param player The player to land on the field.
	 */
	@Override
	public void landOnField(Player player)
	{
		player.changeAccountBalance(bonus); //Gives the player a bonus to his balance.
	}
	
	/**
	 * Method getRent() is not used. Added because field is abstract.
	 */
	@Override
	public int getRent(){
		return -1;
	}
	
}

