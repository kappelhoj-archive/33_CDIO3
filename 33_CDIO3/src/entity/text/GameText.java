package entity.text;

public class GameText extends Text{
	/**
	 * The method turn returns a string which contains whose turn it is.
	 * @param playerName The name of the player
	 * @return String
	 */
	public static String turnText(String playerName)
	{
		return "It is " + playerName + "'s turn \n";
	}
	
	/**
	 * The method rollText returns a String which contains what a particular player has rolled with the dice.
	 * @param playerName The name of the player (String).
	 * @param value A array of two dice values (Int[])
	 * @return String 
	 */
	public static String rollText(String playerName, int[] value)
	{
		return playerName + " has rolled a " + value[0] + " and a " + value[1] + "."+ "\n";
	}
	/**
	 * The method cantBuyFieldText returns a String that tells you that you can't afford this field.
	 * @param playerName The name of the player.
	 * @param fieldName of the mattering field.
	 * @return String
	 */
	public static String cantBuyFieldText(String fieldName)
	{
		return "You can't afford to buy "+ fieldName +". \n";
	}
	
		
	/**
	 * The method boughtFieldText returns a String which tells you that you bought the field.
	 * @param plyerName.
	 * @param fieldName.
	 * @return String
	 */
	public static String boughtFieldText(String playerName, String fieldName)
	{
		return "Congratulation "+ playerName +" bought " + fieldName +" \n" ;
	}
	/**
	 * The method refugeText returns a String which tells you, you landed on a refuge field.
	 * @param plyerName The name of the player.
	 * @param fieldName The name of the field.
	 * @param amount The amount the player will receive on this field.
	 * @return String
	 */
	public static String refugeText(String playerName, String fieldName, int amount)
	{
		return playerName +" landed on " + fieldName + " this is a Refuge field, and you will now recive "+ amount +"  \n" ;
	}
	/**
	 * The method ownedFieldText returns a String which tells you that you landed on a owned field.
	 * @param plyerName The name of the player.
	 * @param fieldName The name of the field.
	 * @param rent The rent of the field.
	 * @return String
	 */
	public static String landOnFieldText(String playerName, String fieldName)
	{
		return playerName + " landed on "+fieldName+" \n";
	}
	
	/**
	 * The method fieldNotOwnedText returns a String which tells you, you landed on a owned field.
	 * @param fieldType The type of the field.
	 * @param fieldName The name of the field.
	 * @return String
	 */
	public static String fieldNotOwnedText(String fieldType,String fieldName)
	{
		return fieldName+" is a "+fieldType+". \n";
	}
	
	//####################################################################################
	//Pay rent to owner texts
	//####################################################################################

	
	
	/**
	 * The method ownedFieldText returns a String which tells you that you landed on a owned field, with a switchcase depending on what filed your on.
	 * @param plyerName The name of the player.
	 * @param fieldName The name of the field.
	 * @param fieldOwner The owner of the field.
	 * @param rent The rent of the field.
	 * @return String
	 */
	public static String ownedFieldText(String playerName,String fieldType,String fieldOwner,int rent)
	{
		String out=fieldOwner+" owns this field. This field is a "+fieldType+"\n";
		switch(fieldType){
		case "Territory":
			out+="You now have to pay "+rent+" to "+fieldOwner+".\n";
			break;
		case "Fleet":
			out+="You now have to pay "+rent+" to "+fieldOwner+". Because of how many fleets they have.\n";
			break;
		case "Labor Camp":
			out+="You now have to to roll the dice and pay a hundred times the amount you roll to "+fieldOwner+". You have to pay twice that if "+fieldOwner+" has two labor camps.\n";
			break;
		}
		return out;		
	}	
	
	/**
	 * The method lostText returns a String which tells you that you lost.
	 * @param playerName The name of the player.
	 * @param rent the rent of the laborcamp .
	 * @return String
	 */
	public static String ownedLaborCampAfterRoll(String fieldOwner,int rent){
		return "You now have to pay "+ rent+" to "+fieldOwner+".\n";
	}
	
	//####################################################################################
	//End game Text
	//####################################################################################

	
	
	/**
	 * The method lostText returns a String which tells you that you lost.
	 * @param playerName The name of the player.
	 * @return String
	 */
	public static String lostText(String playerName)
	{
		return playerName + " lost and is out of this game, like the rest of the world #Trump \n"+
			 "    ____       ________           __ 			\n"+
			 "   / __ \\___  / __/ __/__  ____ _/ /_		\n"+
			 "  / / / / _ \\/ /_/ /_/ _ \\/ __ `/ __/		\n"+
			 " / /_/ /  __/ __/ __/  __/ /_/ / /_		"+"	\n"+  
			 "/_____/\\___/_/ /_/  \\___/\\__,_/\\__/	"+"	\n";  
			                                      
	}		
	
	/**
	 * The method winnerText returns a String which contains which player has won the game
	 * @param playerName The name of the player.
	 * @return String
	 */
	public static String winnerText(String playerName)
	{
		return "Congratulations " + playerName + " has won the game! \n" +
				"__  __           _       __            ______ 		\n" +
				"\\ \\/ /___  __  _| |     / /___  ____  / / / / 	\n" +
				" \\  / __ \\/ / / / | /| / / __ \\/ __ \\/ / / /  	\n" +
				" / / /_/ / /_/ /| |/ |/ / /_/ / / / /_/_/_/  		\n" +
				"/_/\\____/\\____/ |__/|__/\\____/_/ /_(_|_|_)  	\n" ;
		
	}
}
