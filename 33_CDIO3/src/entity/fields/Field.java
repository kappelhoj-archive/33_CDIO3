package entity.fields;

import entity.Player;

public abstract class Field 
{
	//Instance variables
	private String fieldName;
	
	/**
	 * Object Field constructor
	 * @param fieldName The name of the field.
	 */
	public Field(String fieldName)
	{
		this.fieldName = fieldName;
	}
	
	/**
	 * Method landOnField that decides what to be done when player lands on a Field.
	 * A method to be overridden by subclasses.
	 * @param player The player to land on the field.
	 */
	abstract public void landOnField(Player player);
	
}
