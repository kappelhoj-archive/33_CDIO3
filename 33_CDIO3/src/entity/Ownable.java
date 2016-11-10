package entity;

public abstract class Ownable extends Field
{
	private int price;
	private Player owner;
	
	public Ownable(String name, int price, Player owner) 
	{
		super(name);
		this.price = price;
		this.owner = owner;
	}

	public int getRent()
	{
		return 0;
	}
	
	
}
