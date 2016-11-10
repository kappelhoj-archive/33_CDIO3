package entity;

public class Fleet extends Ownable
{
	final private int RENT_1 = 500; 
	final private int RENT_2 = 1000;
	final private int RENT_3 = 2000;
	final private int RENT_4 = 4000;
	
	public Fleet(String name, int price, Player owner)
	{
		super(price,owner);
		
	}
}
