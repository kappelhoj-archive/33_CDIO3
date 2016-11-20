package entity.fields;

public class Fleet extends Ownable
{
	//Constants
	final private int RENT_1 = 500;
	final private int RENT_2 = 1000;
	final private int RENT_3 = 2000;
	final private int RENT_4 = 4000;
	
	/**
	 * Object Fleet constructor.
	 * @param fieldName The name of the fleet field.
	 * @param price The price of the fleet field.
	 */
	public Fleet(String type, int price)
	{
		super(type, price);
	}

	/**
	 * The method getRent returns the rent to be paid by the player who lands on the fleet field.
	 * @return Returns the rent to be paid.
	 */
	@Override
	public int getRent()
	{
		int amountOfFleets = super.getOwner().getAmountOfFleets(); //The amount of fleet fields the owner of the fleet field owns.
		int rent;
		switch(amountOfFleets)
		{
		case 1: rent = RENT_1; //The rent to be paid if the owner owns one fleet field.
			break;
		case 2: rent = RENT_2; //The rent to be paid if the owner owns two fleet fields.
			break;
		case 3: rent = RENT_3; //The rent to be paid if the owner owns three fleet fields.
			break;
		case 4: rent = RENT_4; //The rent to be paid if the owner owns all fleet fields.
			break;
		default: rent = 0;
		}
		return rent;
	}
}
