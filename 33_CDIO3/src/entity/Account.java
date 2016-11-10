package entity;

public class Account {

	private double balance = 30000;
	
	/**
	 * Method to getBalance returns the balance of the Account.
	 * @return Balance value of an account.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Method to calculate the new balance based on the int fieldValue.
	 * @param Field's gold value.
	 */
	public boolean changeBalance(double value) {
		/**
		 * This part of the method simply adds or subtracts the field value from
		 * the player' balance.
		 */
		if(balance + value < balance){
			return true;
		}
		else if(balance < 0) {
			balance = 0;
			return false;
		}
		else {
			balance = balance + value;
			return true;
		}
	}
}