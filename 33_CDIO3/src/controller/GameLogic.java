package controller;
import entity.Player;
import entity.fields.Field;

public class GameLogic 
{
	public static void landOnField(Player player, Field field)
	{
		field.landOnField(player);
	}
}
