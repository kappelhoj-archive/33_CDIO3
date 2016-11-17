package entity;

public class Account 
{
	//Instance variables
	private int balance;
	
	/**
	 * Object Account constructor.
	 * @param balance The balance which the account should start with.
	 */
	public Account(int balance)
	{
		this.balance = balance;
	}
	
	/**
	 * Method getBalance returns the balance of the Account.
	 * @return balance balance of an account.
	 */
	public int getBalance() 
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
	public boolean changeBalance(int value) 
	{
		if(value >= 0)
		{
			if (balance + value < balance) //Checks if the balance overflows
			{
			}
			else 						  //Changes balance
			{
				balance = balance + value;
			}
			return true;
		}
		else
		{
			if(balance + value > balance) //Checks if the balance underflows
			{
				return true;
			}
			else
			{
				balance = balance + value;
				return true;
			}
		}

	}
}