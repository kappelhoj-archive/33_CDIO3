package entity;

public class Territory extends Ownable 
{
	private int rent;
	
	public Territory(String fieldName, int price, int rent)
	{
		super(fieldName, price);
		this.rent = rent;
	}
	
	public int getRent()
	{
		return rent;
	}
}
