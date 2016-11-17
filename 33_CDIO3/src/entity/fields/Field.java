package entity.fields;

import entity.Player;

public abstract class Field 
{
	//Instance variables

	private String type;
	
	/**
	 * Object Field constructor
	 * @param fieldName The name of the field.
	 */
	public Field(String type)
	{
		this.type = type;
	}
	
	/**
	 * Method getType returns the type of the field.
	 * @return Returns the field type.
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Method landOnField that decides what to be done when player lands on a Field.
	 * A method to be overridden by subclasses.
	 * @param player The player to land on the field.
	 */
	abstract public void landOnField(Player player);
	/**
	 * The method getRent returns the rent to be paid by the player who lands on the Ownable field.
	 * A method to be overridden by subclasses.
	 * @return Returns the rent to be paid.
	 */
	public abstract int getRent();
	
}
