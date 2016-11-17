package boundary;

import java.util.Scanner;

import boundary.entity.GameText;

public class TUI {

	/**
	 * Method to start the game. Retrieves the "game start" text and the "game Rules" text from the GameText class,
	 * and lists the name of the players entering the game round.
	 */
	
	private Scanner keyb = new Scanner(System.in);

	public String[] gameStart() {
		System.out.println(GameText.welcomeText());
		String[] playerNames = getPlayerNames(askNumberOfPlayers());

		System.out.println(GameText.gameRulesText());
		return playerNames;

	}
/**
 * Small method asking for the number of players wanting to play in this turn.
 * The method has a built in error-handler, which checks if the typed input actually of an integer-type,
 * and if the integer is correctly between 2 and 6.
 * @return
 */
	private int askNumberOfPlayers() {

		// Ask for the amount of players
		System.out.println(GameText.playerNumberText());

		int numbPlayer = 0;

		while (numbPlayer < 2 || numbPlayer > 6) {
			// Checks if the input is correctly an integer.
			if (keyb.hasNext())
				numbPlayer = keyb.nextInt();

			// Checks if the number is correctly between 2 and 6.
			if (numbPlayer < 2 || numbPlayer > 6) {
				System.out.println(GameText.invalidPlayerNumberText());
			}

		}

		return numbPlayer;
	}
/**
 * Method to create an array consisting of a list of names of the people playing.
 * The methods reads the typed in names, and adds them to the list.
 * If the name has already been added to the list, the method returns an error message, and asks for a new name.
 * @param numbPlayer
 * @return
 */
	private String[] getPlayerNames(int numbPlayer) {
		String[] playerNames;
		playerNames = new String[numbPlayer];
		System.out.println(GameText.enterPlayerNameText(1));
		playerNames[0] = keyb.next();

		for (int i = 1; i < numbPlayer; i++) {
			System.out.println(GameText.enterPlayerNameText(i + 1));
			boolean nameEqual = true;
			playerNames[i] = null;

			while (nameEqual) {
				playerNames[i] = keyb.next();
				for (int j = 0; j < i; j++) {
					if (playerNames[j].equals(playerNames[i])) {
						System.out.println(GameText.playerNameTakenText(playerNames[i]));
						nameEqual = true;
						break;
					} else {
						nameEqual = false;
					}
				}
			}
		}
		keyb.close();
		return playerNames;
	}
}
