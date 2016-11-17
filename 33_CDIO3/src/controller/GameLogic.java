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
	public static void landOnField(Player player, Field field, Game game)
	{
		if (field.getType().equals("Labor Camp"))
		{
			int diceSum = game.askForDiceRoll();
			((LaborCamp)field).setDiceSum(diceSum);		
		}
		else if(field.getType().equals("Tax"))
		{
			boolean playerPayDecision = game.askForDecision("Tax", ((Tax)field).getTaxAmount());
			player.setPayDecision(playerPayDecision);
		}
		field.landOnField(player);
	}
}
