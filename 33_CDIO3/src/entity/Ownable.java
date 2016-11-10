package entity;

public abstract class Ownable extends Field
{
	private int price;
	private Player owner;
	
	public Ownable(String fieldName, int price, Player owner) 
	{
		super(fieldName);
		this.price = price;
		this.owner = owner;
	}

	public int getRent()
	{
		return 0;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	
}
