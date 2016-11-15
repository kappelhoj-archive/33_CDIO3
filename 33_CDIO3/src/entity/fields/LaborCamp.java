package entity.fields;

public class LaborCamp extends Ownable
{
	//Instance variables
	private int baseRent;
	private int diceSum;
	
	/**
	 * Object LaborCamp constructor.
	 * @param fieldName The name of the labor camp field.
	 * @param price The price of the labor camp field.
	 */
	public LaborCamp(String fieldName, int price) {
		super(fieldName, price);
		this.baseRent = 100;
	}

	/**
	 * The method getRent returns the rent to be paid by the player who lands on the Labor camp field.
	 * @return Returns the rent to be paid.
	 */
	@Override
	public int getRent()
	{
		int amountOfLaborCamps = super.getOwner().getAmountOfLaborCamps();
		
		int rent = baseRent * diceSum * amountOfLaborCamps;
		
		return rent;
	}
	
	/**
	 * Method setDiceSum sets the diceSum to the parameter value.
	 * @param diceSum The diceSum to be set.
	 */
	public void setDiceSum(int diceSum)
	{
		this.diceSum = diceSum;
	}
}
