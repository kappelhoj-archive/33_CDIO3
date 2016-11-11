package boundary;

import java.util.Scanner;


import boundary_entity.GameText;

public class TUI {

	// public static void main(String[] args)
	// {
	// System.out.println("Please specify number of players: ");
	//
	// int numbPlayer = 0;
	// String[] playerNames;
	//
	// /**
	// * Error-detection method. Checks if the player number inserted is
	// * within the game bounds.
	// */
	// while (numbPlayer < 2 || numbPlayer > 6)
	// {
	// // Checks if the input is correctly an integer.
	// Scanner keyb = new Scanner(System.in);
	// numbPlayer = keyb.nextInt();
	// if (!keyb.hasNextInt())
	// {
	// System.out.println(GameText.invalidInputText());
	// }
	// // Checks if the number is correctly between 2 and 6.
	// if (numbPlayer < 2 || numbPlayer > 6)
	// {
	// System.out.println(GameText.invalidPlayerNumberText());
	// }
	// }
	// /**
	// * Adding number of players into an array called "numberPlayerArray".
	// */
	// playerNames = new String[numbPlayer];
	//
	// for (int i = 0; i < numbPlayer; i++)
	// {
	// String playerName;
	// Scanner keyb = new Scanner(System.in);
	//
	// playerName = keyb.nextLine();
	// playerNames[i] = playerName;
	// }
	// /**
	// * Error-detecting method. Checks if a newly inserted name is the same
	// * as an older name already inserted into the array.
	// */
	// Scanner keya = new Scanner(System.in);
	// playerNames[0] = keya.nextLine();
	// System.out.println(GameText.firstPlayerText(playerNames));
	// for (int i = 1; i < numbPlayer; i++)
	// {
	// boolean nameEqual = true;
	// playerNames[i] = null;
	//
	// Scanner keyb = new Scanner(System.in);
	//
	// while (nameEqual)
	// {
	// playerNames[i] = keyb.nextLine();
	// for (int j = 0; j < i; j++)
	// {
	// if (playerNames[j].equals(playerNames[i]))
	// {
	// System.out.println(GameText.playerNameTakenText(playerNames[i]));
	// nameEqual = true;
	// break;
	// }
	// else
	// {
	// nameEqual = false;
	// }
	// }
	// }
	// }
	// }

	
	public String[] gameStart(){
		System.out.println(GameText.welcomeText());
		int numbPlayer=askNumberOfPlayers();
		String[] playerNames=getPlayerNames(numbPlayer);
		
		System.out.println(GameText.gameRulesText());
		return playerNames;
		
	}
	
	public int askNumberOfPlayers() {
		// Create a scanner
		Scanner keyb = new Scanner(System.in);
		// Ask for the amount of players
		System.out.println(GameText.playerNumberText());

		int numbPlayer = 0;

		while (numbPlayer < 2 || numbPlayer > 6) {
			// Checks if the input is correctly an integer.

			numbPlayer = keyb.nextInt();
			if (!keyb.hasNextInt()) {
				System.out.println(GameText.invalidInputText());
			}

			// Checks if the number is correctly between 2 and 6.
			if (numbPlayer < 2 || numbPlayer > 6) {
				System.out.println(GameText.invalidPlayerNumberText());
			}

		}
		keyb.close();
		return numbPlayer;
	}

	public String[] getPlayerNames(int numbPlayer) {
		String[] playerNames;
		Scanner keya = new Scanner(System.in);
		playerNames = new String[numbPlayer];

		System.out.println(GameText.enterPlayerNameText(1));
		playerNames[0] = keya.nextLine();

		for (int i = 1; i < numbPlayer; i++) {
			System.out.println(GameText.enterPlayerNameText(i + 1));
			boolean nameEqual = true;
			playerNames[i] = null;

			while (nameEqual) {
				playerNames[i] = keya.nextLine();
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
		keya.close();
		return playerNames;
	}
}
