package entity;

public class Account {

	private int balance = 1000;
	
	/**
	 * Method to getBalance returns the balance of the Account.
	 * @return Balance value of an account.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Method to calculate the new balance based on the int fieldValue.
	 * @param Field's gold value.
	 */
	public boolean changeBalance(int fieldValue) {
		/**
		 * This part of the method simply adds or subtracts the field value from
		 * the player' balance.
		 */
		balance = balance + fieldValue;
		if (balance < 0) {
			balance = 0;
			return false;
		} else if (balance > 3000)
			balance = 3000;
		return true;
	}

}

