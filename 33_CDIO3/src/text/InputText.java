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
	public static String[] information = { "Welcome to 'Rodatam'. \n",
			"Enter the number of players who wants to play. The number must be between 2 and 6.\n", "Please enter the name of player %d \n",
			gameRulesText(), "A player has been randomly selected to start the game. Good luck to you all \n" };

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
		gameRules = gameRules + "- All players start with a fund of 30.000. \n"
				+ "- When you lose all your money, you are out of the game. \n"
				+ "- The last remaining player wins the game.\n"
				+ "- You begin a turn by rolling the dice. You then move to the designated field dictated by the eyes on the dice.\n"
				+ "- There are 5 different types of fields. When you land on them, they will have a different effect on your funds, and the games continued progress.\n"
				+ "- You can hover over fields to read what effects they apply.";

		return gameRules;
	}

}
