package entity;

public class Account {
	// Instance variables
	private int balance;

	/**
	 * Object Account constructor.
	 * @param balance The balance which the account should start with.
	 */
	public Account(int balance) {
		this.balance = balance;
	}

	/**
	 * Method getBalance returns the balance of the Account.
	 * @return balance balance of an account.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Method changeBalance calculates the new balance based on the parameter
	 * value.
	 * @param value The value that the balance of the account should be changed
	 * with. If the parameter is positive the method adds value to
	 * the balance. If the parameter is negative the method
	 * subtracts value from balance.
	 * @return The method return true if the change of balance succeeded. False
	 * otherwise.
	 */
	public void changeBalance(int value) 
	{
		// Checks if the balance overflows
		if (balance + value < balance && value > 0) 
		{
		}
		// Checks if the balance underflows
		else if (balance + value > balance && value < 0) 
		{
		}
		// Changes balance
		else 
		{
			balance = balance + value;
		}

	}
	
	/**
	 * OBS: This method is only used for testing.
	 * Method setBalance sets the balance of the Account.
	 */
	public void setBalance(int value) {
		balance = value;
	}
}