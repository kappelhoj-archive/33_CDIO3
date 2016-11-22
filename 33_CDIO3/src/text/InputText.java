package text;

public class InputText extends Text {
	/**
	 * 
	 * Argument 0 is a welcome text.<br>
	 * Argument 1 ask for the number players that are going to play<br>
	 * Argument 2 ask for name of player number x. Needs: (int) <br>
	 * Argument 3 says the rules of the game<br>
	 * Argument 4 States that a random player has been chosen to start.
	 */
	public static String[] information = { "Welcome to 'Rodatam' \n",
			"Enter the number of players who wants to play between 2 and 6.\n", "Please enter the name of player %d \n",
			gameRulesText(), "A player has been randomly selected to start the game. \n" };

	/**
	 * 
	 * Error 0, invalid number of players. <br>
	 * Error 1, invalid player name.
	 */
	public static String[] errors = {
			"This is not a valid number of players, please try again with a number within 2-6 \n",
			"This player name %s is already taken, try again \n" };

	/**
	 * The method gameRules returns a string which contains the game rules.
	 * 
	 * @return String
	 */
	public static String gameRulesText() {
		String gameRules = "";
		gameRules = "The game rules are as follows: \n";
		gameRules = gameRules + "- All players start with 30000 money. \n"
				+ "- When you lose all your money you are out of the game. \n"
				+ "- The last remaining player has won the game.\n"
				+ "- You start a turn by rolling the dice. You then move forward by the amount you rolled.\n"
				+ "- There are 5 different types of fields. When you land on them they have different effects.\n"
				+ "- You can hover over fields to see what they do.";

		return gameRules;
	}

}
