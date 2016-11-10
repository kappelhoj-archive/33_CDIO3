package entity;

<<<<<<< HEAD
public class Territory extends Ownerable 
{
=======
public class Territory extends Ownable {
>>>>>>> branch 'implement' of https://github.com/ArvidLangsoe/33_CDIO3.git
	private int rent;
	
	/**
	 * Territory constructor
	 * @param name
	 * @param price
	 * @param owner
	 * @param rent
	 */
	public Territory(String name, int price, Player owner, int rent)
	{
		super(name, price, owner);
		this.rent = rent;
	}
}
