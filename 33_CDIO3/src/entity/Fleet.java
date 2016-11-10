package entity;

public class Fleet extends Ownable
{
	final private int RENT_1 = 500; 
	final private int RENT_2 = 1000;
	final private int RENT_3 = 2000;
	final private int RENT_4 = 4000;
	
	public Fleet(String fieldName, int price)
	{
		super(fieldName, price);
	}

	public int getRent()
	{
		int amountOfFleets = super.getOwner().getAmountOfFleets();
		int rent;
		switch(amountOfFleets)
		{
		case 1: rent = RENT_1;
			break;
		case 2: rent = RENT_2;
			break;
		case 3: rent = RENT_3;
			break;
		case 4: rent = RENT_4;
			break;
		default: rent = 0;
		}
		return rent;
	}
}
