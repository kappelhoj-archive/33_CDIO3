package entity;

public class Account 
{
	//Instance variables
	private double balance;
	
	/**
	 * Object Account constructor.
	 * @param balance The balance which the account should start with.
	 */
	public Account(double balance)
	{
		this.balance = balance;
	}
	
	/**
	 * Method getBalance returns the balance of the Account.
	 * @return balance balance of an account.
	 */
	public double getBalance() 
	{
		return balance;
	}

	/**
	 * Method changeBalance calculates the new balance based on the parameter value.
	 * @param value The value that the balance of the account should be changed with.
	 * If the parameter is positive the method adds value to the balance.
	 * If the parameter is negative the method substracts value from balance.
	 * @return The method return true if the change of balance succeeded. False otherwise.
	 */
	public boolean changeBalance(double value) 
	{
		if(balance + value < balance) //Checks if the balance overflows
		{
			return true;
		}
		else if(balance < 0) 		  //Spørg om dette er nødvendigt? En spiller med negativ balance er jo 'død'.
		{
			balance = 0;
			return false;
		}
		else 						  //Changes balance
		{
			balance = balance + value;
			return true;
		}
	}
}