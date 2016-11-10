package boundary;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import boundary_entity.GameText;

public class TUI {

	public static void main(String[] args) {
		System.out.println("Please specify number of players: ");

		int numbPlayer = 0;
		String[] playerNames;

		/**
		 * Error-detection method. Checks if the player number inserted is
		 * within the game bounds.
		 */
		while (numbPlayer < 2 || numbPlayer > 6) {
			// Check if the input is correctly an integer.
			Scanner keyb = new Scanner(System.in);
			numbPlayer = keyb.nextInt();
			if (!keyb.hasNextInt()) {
				System.out.println(GameText.invalidInputText());
			}
			// Check if the number is correctly between 2 and 6.
			if (numbPlayer < 2 || numbPlayer > 6) {
				System.out.println(GameText.invalidPlayerNumberText());
			}
		}
		/**
		 * Adding number of players into an array called "numberPlayerArray".
		 */
		playerNames = new String[numbPlayer];

		for (int i = 0; i < numbPlayer; i++) {
			String playerName;
			Scanner keyb = new Scanner(System.in);

			playerName = keyb.nextLine();
			playerNames[i] = playerName;
		}
		/**
		 * Error-detecting method. Checks if a newly inserted name is the same
		 * as an older name already inserted into the array.
		 */
		Scanner keya = new Scanner(System.in);
		playerNames[0] = keya.nextLine();
		System.out.println(GameText.firstPlayerText(playerNames));
		for (int i = 1; i < numbPlayer; i++) {
			boolean nameEqual = true;
			playerNames[i] = null;

			Scanner keyb = new Scanner(System.in);

			while (nameEqual) {
				playerNames[i] = keyb.nextLine();
				for (int j = 0; j < i; j++) {
					if (playerNames[j].equals(playerNames[i])) {
						System.out.println(GameText.playerNameTakenText(playerNames[i]));
						nameEqual = true;
						break;
					} else
						nameEqual = false;
				}
			}
		}
	}
}
