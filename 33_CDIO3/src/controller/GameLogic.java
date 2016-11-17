package controller;
import entity.Player;
import entity.fields.*;

public class GameLogic 
{
	/**
	 * Method landOnField Decides what to be done when a player lands on a field
	 * @param player The player to land on the field.
	 * @param field The field which the player has landed on.
	 * @param game The game that is played.
	 */
	public static String landOnField(Player player, Field field, Game game)
	{
		boolean notOwnableFields = field.getType().equals("Refuge") || field.getType().equals("Tax");
		String msg = "";
		
		//Checks if the given field is a Refue/Tax field. (a.k.a. is not a ownable field)
		if(notOwnableFields)
		{
			//If the given field is a tax field, ask the given player if he wants to pay 10% or a specific amount.
			if (field.getType().equals("Tax"))
			{
				boolean playerPayDecision = game.askForDecision("Tax", ((Tax)field).getTaxAmount());
				player.setPayDecision(playerPayDecision);
			}
			field.landOnField(player);
		}
		//Checks if the given field is a Fleet/Territory/LaborCamp field. (a.k.a is a ownable field).
		else 
		{
			//If the field is not owned.
			if (!((Ownable)field).isFieldOwned())
			{
				//Ask the given player if he wants to buy the field that is not owned.
				boolean buyField = game.askForDecision("Buy", 0);
				
				//Checks if the player wants to buy the field.
				if(buyField)
				{
					
					((Ownable)field).buyField(player);
					//Check if the player actually bought the field, needed because he might not have money to buy it.
					if (((Ownable)field).isFieldOwned())
					{
						msg = msg + "Bought";
					}
				}
				else
				{
					msg = msg + "Not bought";
				}
			}
			//If the field is owned
			else
			{
				//If the given is a Labor camp field. ask for the game for the diceSum to calculate the rent.
				if(field.getType().equals("Labor Camp"))
				{
					int diceSum = game.askForDiceRoll();
					((LaborCamp)field).setDiceSum(diceSum);	
					msg = msg + field.getRent();
				}
				field.landOnField(player);
			}
		}
		//Checks if the player who had to pay has lost.
		if (player.getAccountBalance() < 0)
		{
			player.setPlayerHasLost(true);
		}
		return msg;
	}
}
