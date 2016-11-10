package entity;

public abstract class Ownable extends Field
{
	private int price;
	private Player owner;
	
	public Ownable(String fieldName, int price) 
	{
		super(fieldName);
		this.price = price;
		this.owner = null;
	}

	public int getRent()
	{
		return 0;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public boolean isFieldOwned()
	{
		if (owner == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean buyField(Player player)
	{
		if (player.getAccountBalance() > price)
		{
			player.changeAccountBalance(-price);
			owner = player;
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
