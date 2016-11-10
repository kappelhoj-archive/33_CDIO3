package boundary;

import java.util.Scanner;

public class TUI {

	public static void main(String[] args) {
		System.out.println("Please specify number of players: ");

		int numbPlayer = 0;
		String[] playerNames;
		
		/**
		 * Error-detection method.
		 * Checks if the player number inserted is within the game bounds.
		 */
		while (numbPlayer<2 || numbPlayer>6){
			//Check if the input is correctly an integer.
			Scanner keyb = new Scanner(System.in);
			numbPlayer = keyb.nextInt();
			if (!keyb.hasNextInt()){
				System.out.println("This is not a valid input. Please try again.");
			}
			//Check if the number is correctly between 2 and 6.
			if (numbPlayer<2 || numbPlayer>6){
				System.out.println("This is not a valid number of players. Please try again.");
			}
		}
		/**
		 * Adding number of players into an array called "numberPlayerArray".
		 */
			playerNames = new String[numbPlayer];
			
		for (int i = 0; i < numbPlayer; i++){
			String playerName;
			
			/* Henter spiller navn fra tastatur. */
			playerNames[i]=playerName;
		}
	}
}