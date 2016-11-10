package entity;

public class LaborCamp extends Ownable
{
	private int baseRent;
	private int diceSum;
	
	public LaborCamp(String fieldName, int price) {
		super(fieldName, price);
		this.baseRent = 100;
	}

	public int getRent()
	{
		int amountOfLaborCamps = super.getOwner().getAmountOfLaborCamps();
		
		int rent = baseRent * diceSum * amountOfLaborCamps;
		
		return rent;
	}
	
	public void setDiceSum(int diceSum)
	{
		this.diceSum = diceSum;
	}
}
