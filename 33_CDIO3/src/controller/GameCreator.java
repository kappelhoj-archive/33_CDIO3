package controller;


import boundary.InformationHandler;
import boundary.InputHandler;
import entity.text.InputText;

public class GameCreator {
	InformationHandler info;
	public GameCreator(){
		info=new InformationHandler();
		info.startGame();
	}

	public String[] gameStart() {
		//Show a welcome text
		InformationHandler.ShowInformation(InputText.information[0], InputText.getButtonText("ok"));
		//Receives the number of players and player names.
		String[] playerNames = getPlayerNames(askNumberOfPlayers());
		//Ads the player to the GUI
		info.addPlayers(playerNames);
		//Show the rules to the player
		InformationHandler.ShowInformation(InputText.information[3], InputText.getButtonText("ok"));
		InformationHandler.ShowInformation(InputText.information[4], InputText.getButtonText("ok"));
		//Returns the playernames to the caller.
		return playerNames;

	}
/**
 * Small method asking for the number of players wanting to play in this turn.
 * The method has a built in error-handler, which checks if the typed input actually of an integer-type,
 * and if the integer is correctly between 2 and 6.
 * @return
 */
	private int askNumberOfPlayers() {
		//Ask the players how many are playing
		int numbPlayer = 0;

		while (numbPlayer < 2 || numbPlayer > 6) {
				numbPlayer = InputHandler.AskForInt(InputText.information[1],2, 6);
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
		playerNames[0] = InputHandler.AskForString(String.format(InputText.information[2],1));

		for (int i = 1; i < numbPlayer; i++) {
			boolean nameEqual = true;
			playerNames[i] = null;

			while (nameEqual) {
				playerNames[i] = InputHandler.AskForString(String.format(InputText.information[2],i+1));
				for (int j = 0; j < i; j++) {
					if (playerNames[j].equals(playerNames[i])) {
						InformationHandler.ShowInformation(String.format(InputText.errors[1],playerNames[i]),InputText.getButtonText("ok"));
						nameEqual = true;
						break;
					} else {
						nameEqual = false;
					}
				}
			}
		}
		return playerNames;
	}
	
	
}
