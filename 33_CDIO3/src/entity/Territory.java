package entity;

public class Territory extends Ownable 
{
	private int rent;
	
	/**
	 * Territory constructor
	 * @param name
	 * @param price
	 * @param owner
	 * @param rent
	 */
	public Territory(String name, int price, Player owner, int rent)
	{
		super(name, price, owner);
		this.rent = rent;
	}
}
