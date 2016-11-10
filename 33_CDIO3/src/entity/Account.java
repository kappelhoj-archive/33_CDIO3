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
	public boolean changeBalance(int rent) {
		/**
		 * This part of the method simply adds or subtracts the field value from
		 * the player' balance.
		 */
		if(balance + rent < balance){
			return true;
		}
		else if(balance < 0) {
			balance = -1;
			return false;
		}
		else {
			balance = balance + rent;
			return true;
		}
	}

}

