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
		
		String msg = "";
		//Checks if the field is Ownable.
		if(field.getType().equals("Refuge") || field.getType().equals("Tax") )
		{
			if (field.getType().equals("Tax"))
			{
				boolean playerPayDecision = game.askForDecision("Tax", ((Tax)field).getTaxAmount());
				player.setPayDecision(playerPayDecision);
			}
			field.landOnField(player);
		}
		else 
		{
			if (((Ownable)field).getOwner() == null)
			{
				boolean playerPayDecision = game.askForDecision("buy", 0);
				
				if(playerPayDecision == true)
				{
					((Ownable)field).buyField(player);
					if (((Ownable)field).isFieldOwned())
					{
						msg = msg + "Bought";
					}
					else
					{
						msg = msg + "Not bought";
					}
				}
			}
			else
			{
				if(field.getType().equals("Labor Camp"))
				{
					int diceSum = game.askForDiceRoll();
					((LaborCamp)field).setDiceSum(diceSum);	
					msg = msg + field.getRent();
				}
				field.landOnField(player);
			}
		}
		if (player.getAccountBalance() < 0)
		{
			player.setPlayerHasLost(true);
		}
		return msg;
	}
}
