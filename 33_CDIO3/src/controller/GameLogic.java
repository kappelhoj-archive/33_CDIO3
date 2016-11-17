package controller;
import entity.Player;
import entity.fields.*;

public class GameLogic 
{
	/**
	 * 
	 * @param player
	 * @param field
	 * @param game
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
