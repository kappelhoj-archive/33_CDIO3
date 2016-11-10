package entity;

public class LaborCamp extends Ownable
{
	private int baseRent;
	
	public LaborCamp(String fieldName, int price, Player owner) {
		super(fieldName, price, owner);
		this.baseRent = 100;
	}

	public int getRent()
	{
		int amountOfLaborCamps = super.getOwner().getAmountOfLaborCamps();
		int rent;
		//diceSum skal ændres
		int diceSum = 0;
		
		rent = baseRent * amountOfLaborCamps * diceSum;
		
		return rent;
	}
	
	
}
