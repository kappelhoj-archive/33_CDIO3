package entity;

public class Tax extends Field{
	
	private int taxRate;
	private int taxAmount;
	
	public Tax (String fieldName, int taxAmount, int taxRate)
	{	
		super(fieldName);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}
	
	public void landOnField(Player player)
	{
		if (player.getPlayerPayDecision())
		{
			double rent = 0.01 * taxRate * player.getPlayerFortune();
			player.changeAccountBalance(-rent);
			player.setPlayerFortune(-taxAmount);
		}
		else
		{
			player.changeAccountBalance(-taxAmount);
			player.setPlayerFortune(-taxAmount);
		}
	}
}
