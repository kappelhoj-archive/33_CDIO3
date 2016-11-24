package text;

public class GameText extends Text {
	/**
	 * Argument 0, tells whos turns it is. Input: String PlayerName <br>
	 * Argument 1, tells what was rolled. Input: String PlayerName, int die1,
	 * int die2.
	 */
	public static String[] turnInformation = { "It is %s's turn. \n", "%s has rolled a %d and a %d.\n" };

	/**
	 * Argument 0, you cant buy this field, input: String FieldName<br>
	 * Arguemnt 1, you bought this field, intput: String Playername, String
	 * fieldName
	 */
	public static String[] buyInfo = { "You can't afford to buy %s. \n", "Congratulation %s, you bought %s \n" };

	/**
	 * Argument 0, player has won, input: String playerName.<br>
	 * Argument 1, player has lost, input: String playerName.
	 */
	public static String[] winLose = { "Congratulations %s has won the game! \n",
			"%s lost and is out of this game. \n" };
	/**
	 * Argument 0, player landed on field, input: String playerName, String
	 * fieldName.<br>
	 * Argument 1, what type is this field, input String filedName, String
	 * fieldType<br>
	 * Argument 2, refuge specific text, input: int amount
	 */
	public static String[] standardFieldText = { "%s landed on %s \n", "%s is a %s. \n",
			"This is a Refuge field, and you will now recive %d. \n" };

	/**
	 * Argument 0, player x owns this field. input: String ownerName<br>
	 * Argument 1, territory rent. input: int rent, String ownerName<br>
	 * Argument 2, fleet rent. input: int rent, String ownerName<br>
	 * Argument 3, labor camp rent start, String ownerName<br>
	 */
	public static String[] rentText = { "%s owns this field.\n", "You now have to pay %d to %s.\n",
			"You now have to pay %d to %s. Because of how many fleets they have.\n",
			"You now have to to roll the dice and pay a hundred times the amount you roll to %s. You have to pay twice that if they have two labor camps.\n", };

}
