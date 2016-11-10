package entity;

import entity.Account;

public class Player {

	//Instance variables
	private String playerName;
	private Account account;
	private boolean hasLost;
	private int amountOfFleets;
	private int amountOfLaborCamps;
	private int fortune;
	private boolean payDecision; //True if player chooses to pay 10 % of his fortune, false otherwise.

	/** 
	 * Player constructor sets the player's name to the parameter value.
	 * @param Player's name.
	 */
	public Player(String playerName)
	{
		this.playerName = playerName;
		account = new Account(30000);
		hasLost = false;
		amountOfFleets = 0;
		amountOfLaborCamps = 0;
		fortune = this.getAccountBalance();
	}
	
	/** 
	 * Method to return the individual players name.
	 * @return Player's name. 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	public int getPlayerFortune()
	{
		return fortune;
	}
	
	public void setPlayerFortune(int value)
	{
		fortune = fortune + value;
	}
	
	public boolean getPlayerPayDecision()
	{
		return payDecision;
	}
	
	public void setPayDecision(boolean playerPayDecision)
	{
		payDecision = playerPayDecision;
	}
	
	
	/** 
	 * Method changeAccountBalance changes the account balance value of the player.
	 * @param Field's gold value.
	 */
	public void changeAccountBalance(double fieldValue){
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
	
	public int getAmountOfLaborCamps() {
		return amountOfLaborCamps;
	}
	
	public void payRent(Player owner, int rent)
	{
		if(account.getBalance() > rent)
		{
			owner.changeAccountBalance(rent);
			owner.setPlayerFortune(rent);
			account.changeBalance(-rent);
			fortune = fortune - rent;
		}
		else
		{
			owner.changeAccountBalance(account.getBalance());
			owner.setPlayerFortune(account.getBalance());
			setPlayerHasLost(true);
		}
	}
	
	public void setPlayerHasLost(boolean condition) {
		hasLost = condition;
	}
}