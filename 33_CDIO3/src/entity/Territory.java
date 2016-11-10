package entity;

public class Territory extends Ownable 
{
	//Instance variables
	private int rent;
	
	/**
	 * Object Territory constructor
	 * @param fieldName The name of the field
	 * @param price The price of the field
	 * @param rent The rent it costs to land on the field if the field is owned.
	 */
	public Territory(String fieldName, int price, int rent)
	{
		super(fieldName, price);
		this.rent = rent;
	}
	
	/**
	 * The method getRent returns the rent to be paid by the player who lands on the territory field.
	 * @return Returns the rent to be paid.
	 */
	public int getRent()
	{
		return rent;
	}
}
