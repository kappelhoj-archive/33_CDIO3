package entity;

import entity.Account;

public class Player {

	private String playerName;
	private Account account = new Account();
	private boolean hasLost;
	private int amountOfFleets;

	/** 
	 * Player constructor sets the player's name to the parameter value.
	 * @param Player's name.
	 */
	public Player(String playerName)
	{
		this.playerName = playerName;
		hasLost = false;
		amountOfFleets = 0;
	}
	
	/** 
	 * Method to return the individual players name.
	 * @return Player's name. 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/** 
	 * Method changeAccountBalance changes the account balance value of the player.
	 * @param Field's gold value.
	 */
	public void changeAccountBalance(int fieldValue){
		account.changeBalance(fieldValue);
	}
	
	/** 
	 * Method getAccountBalance returns the player's account balance.
	 * @return Returns the account balance value of the player.
	 */
	public int getAccountBalance(){
		return account.getBalance();
	}
	
	public int getAmountOfFleets(){
		return amountOfFleets;
	}
}