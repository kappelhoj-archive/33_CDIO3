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
	
	public void landOnField(Player player)
	{
		if (!super.getOwner().getPlayerName().equals(player.getPlayerName()))
		{
			player.payRent(super.getOwner(), this.getRent());
		}
	}
}
