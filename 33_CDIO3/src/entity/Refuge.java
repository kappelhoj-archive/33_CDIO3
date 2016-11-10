package entity;


public class Refuge extends Field {

	private int bonus;

	public Refuge(String fieldName, int bonus)
	{
		super(fieldName);
		this.bonus = bonus;
	}
	
	public void landOnField(Player player)
	{
		player.changeAccountBalance(bonus);
	}
}

