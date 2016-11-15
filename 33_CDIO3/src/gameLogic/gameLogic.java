package gameLogic;
import entity.Player;
import entity.fields.Field;

public class gameLogic 
{
	public static void landOnField(Player player, Field field)
	{
		field.landOnField(player);
	}
}
