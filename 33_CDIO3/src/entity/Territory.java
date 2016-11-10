package entity;

public class Territory extends Ownable 
{
	private int rent;
	
	public Territory(String fieldName, int price, Player owner, int rent)
	{
		super(fieldName, price, owner);
		this.rent = rent;
	}
}
