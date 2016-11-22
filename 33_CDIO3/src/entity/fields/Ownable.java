package entity.fields;

import entity.Player;

public abstract class Ownable extends Field
{
	//Instance variables
	private int price;
	private Player owner;
	
	/**
	 * Object Ownable constructor
	 * @param type The type of the field.
	 * @param price The price of the Ownable field.
	 */
	public Ownable(String type, int price) 
	{
		super(type);
		this.price = price;
		this.owner = null;
	}

	/**
	 * The method getRent returns the rent to be paid by the player who lands on the Ownable field.
	 * A method to be overridden by subclasses.
	 * @return Returns the rent to be paid.
	 */
	public abstract int getRent();
	
	/**
	 * Method getOwner returns the owner of the field.
	 * @return Returns the player who owns the field.
	 */
	public Player getOwner()
	{
		return owner;
	}
	
	/**
	 * Method isFieldOwned check if the field is owned by a player.
	 * @return Returns true if the field is owned.
	 */
	public boolean isFieldOwned()
	{
		if (owner == null) //Checks if the field has a owner.
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Method buyField Lets the player buy a Ownable field.
	 * @param player The player to buy the field.
	 * @return Returns true if the buy succeeded.
	 */
	public boolean buyField(Player player)
	{
		if (player.getAccountBalance() > price)  //Checks if the player has enough money to buy the field.
		{
			player.changeAccountBalance(-price); //Subtracts the price of the field from the player account balance.
			owner = player;                      //Sets the player to be the owner of the field.

			player.changePlayerFortune(price);   //Adds the price of the field to the fortune of the player.
			if(this.getType().equals("Fleet"))
			{
				player.changeAmountOfFleets();
			}
			else if (this.getType().equals("Labor Camp"))
			{
				player.changeAmountOfLaborCamps();
			}

			return true;
		}
		else
		{
			return false;
		}
	}
		
	/**
	 * Method landOnField decides what to be done when player lands on a Ownable Field.
	 * @param player The player to land on the field.
	 */
	@Override
	public void landOnField(Player player)
	{
		if (!getOwner().getPlayerName().equals(player.getPlayerName())) //Checks if the owner of the field and the player who landed on the field isn't the same
		{
			player.payRent(getOwner(), this.getRent());      //player pays the owner of the field.
			player.changePlayerFortune(-(this.getRent()));   //Updates the players fortune.
			getOwner().changePlayerFortune(this.getRent());  //Updates the owners fortune.
		}
	}
	
	/**
	 * Method removeOwner sets the owner of the field to null.
	 */
	public void removeOwner()
	{
		owner = null;
	}
}
