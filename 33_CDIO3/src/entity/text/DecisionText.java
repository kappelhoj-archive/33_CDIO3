package entity.text;

public class DecisionText extends Text{
	/**
	 * The method buyfieldText returns a String which asks if you want to buy a field.
	 * @param playerName The name of the player. 
	 * @param fieldName of the mattering field.
	 * @param price(int) of the mattering field.
	 * @return String
	 */
	public static String buyfieldText(String playerName, String fieldName, String price)
	{
		return "Do you, " + playerName + ", want to buy "+ fieldName +" for "+ price +"? \n";
	}
	/**
	 * The method taxText returns a String which tells you, landed on a tax field.
	 * @param plyerName The name of the player.
	 * @param fieldName The name of the field.
	 * @param tax The tax of the field.
	 * @return String
	 */
	public static String taxText(String playerName, String fieldName, int tax)
	{
		return playerName +" landed on " + fieldName + " you will have to pay tax, you can choose to pay "+ tax +" or pay 10% of your fortune \n";
	}
}
