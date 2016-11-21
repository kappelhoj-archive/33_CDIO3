package controller;

import boundary.InformationHandler;
import entity.*;
import entity.fields.*;
import text.GameText;

public class Game {

	int turn;
	Player[] players;
	GameCreator gameStarter;
	DiceCup dice;
	GameBoard gameBoard;

	/**
	 * Initialize all the class variables and activate the gameStarter to ask
	 * for player names.
	 */
	public Game() {
		// Creates a DiceCup
		dice = new DiceCup();
		// Creates the game board
		gameBoard = new GameBoard();
		// Start the TUI
		gameStarter = new GameCreator();
		// Ask for the player names
		String[] playerNames = gameStarter.gameStart();
		// Initialize the gui and players
		this.players = new Player[playerNames.length];

		for (int i = 0; i < players.length; i++) {
			this.players[i] = new Player(playerNames[i]);
		}
		// Pick a random player to start.
		turn = (int) (Math.random() * players.length);
		// Deletes the gameStarter since it is unused.
		gameStarter = null;

	}

	/**
	 * Prints a text that will be shown to the player dependent on what field he
	 * lands on.
	 * 
	 * @param field
	 *            The field the player landed on.
	 */
	public void showLandText(Field field) {
		// Get the field type.
		String type = field.getType();

		// Initialze the output string
		String output = "";

		// Adds the dice roll to output
		output += String.format(GameText.turnInformation[1], players[turn].getPlayerName(), dice.getDiceValue()[0],
				dice.getDiceValue()[1]);

		// Tells the player where he landed
		output += String.format(GameText.standardFieldText[0], players[turn].getPlayerName(),
				GameText.fieldTitles[players[turn].getPosition() - 1]);

		// Tell the player what type of field that is.
		output += String.format(GameText.standardFieldText[1], GameText.fieldTitles[players[turn].getPosition() - 1],
				type);

		// Check if the field is of the ownable types
		if (type.equals("Territory") || type.equals("Fleet") || type.equals("Labor Camp")) {
			// Check if the field is owned
			if (((Ownable) field).getOwner() != null
					&& !((Ownable) field).getOwner().getPlayerName().equals(players[turn].getPlayerName())) {
				// Tells the player who owns the field
				output += String.format(GameText.rentText[0], ((Ownable) field).getOwner().getPlayerName());

				// Tell the player what he has to pay to the owner depending on
				// the field
				switch (type) {
				case "Territory":
					output += String.format(GameText.rentText[1], field.getRent(),
							((Ownable) field).getOwner().getPlayerName());
					break;
				case "Fleet":
					output += String.format(GameText.rentText[2], field.getRent(),
							((Ownable) field).getOwner().getPlayerName());
					break;
				case "Labor Camp":
					output += String.format(GameText.rentText[3], ((Ownable) field).getOwner().getPlayerName());
					break;
				default:
					break;
				}
			}
		}
		// Tells the plyer what he get for landing on a refuge field.
		switch (type) {
		case "Refuge":
			output += String.format(GameText.standardFieldText[2], ((Refuge) field).getBonus());
			break;
		default:
			break;

		}
		// Prints the output to the GUI
		stateInformationToGUI(output);
	}

	/**
	 * Changes the turn to the next player in the array that hasn't lost.
	 */
	public void changeTurn() {
		do {
			turn = (turn + 1) % players.length;
		} while (players[turn].getPlayerHasLost());
		// Print whos turn it is.
		stateInformationToGUI(String.format(GameText.turnInformation[0], players[turn].getPlayerName()));
	}

	/**
	 * Moves the player to his new position.
	 */
	public void movePlayer() {
		// Roll the dice
		dice.shakeCup();
		int sum = dice.getDiceValue()[0] + dice.getDiceValue()[1];
		// Move the player to his position and if he passes field 21 move him to
		// 1 and continue counting.
		if (players[turn].getPosition() + sum <= 21) {
			players[turn].setPosition(players[turn].getPosition() + sum);
		} else {
			int difference = 21 - players[turn].getPosition();
			players[turn].setPosition(sum - difference);
		}
		// Update the die on the GUI
		InformationHandler.showRoll(dice.getDiceValue());
		// Update the player car on the GUI
		InformationHandler.movePlayer(players[turn].getPlayerName(), players[turn].getPosition());
	}

	/**
	 * Removes the ownership of the player whos turn it is.
	 */
	public void updateAllFieldOwners() {
		for (int i = 1; i < 22; i++) {
			if (!gameBoard.getField(i).getType().equals("Refuge") && !gameBoard.getField(i).getType().equals("Tax"))
				if (((Ownable) gameBoard.getField(i)).getOwner() != null)
					if (((Ownable) gameBoard.getField(i)).getOwner().getPlayerName()
							.equals(players[turn].getPlayerName()))
						updateFieldOwner(i, (Ownable) gameBoard.getField(i), true);
		}
	}

	/**
	 * Update the owner of the field.
	 * 
	 * @param position
	 *            The position of the field on the board
	 * @param field
	 *            The field i question.
	 * @param reset
	 *            Boolean determining if the owner has to be deleted from the
	 *            field.
	 */
	public void updateFieldOwner(int position, Ownable field, boolean reset) {
		String name = field.getOwner().getPlayerName();
		if (reset)
			InformationHandler.removeOwnerOfField(position);
		else
			InformationHandler.setOwnerOfField(name, position);
	}

	/**
	 * Method that plays a turn for one player
	 */
	public void playTurn() {
		// Roll the dice and move player
		movePlayer();
		// Show the player what happended
		showLandText(gameBoard.getField(players[turn].getPosition()));
		// Tell gamelogic to handle the landing.
		String message = GameLogic.landOnField(players[turn], gameBoard.getField(players[turn].getPosition()), this);
		// Do what the gameLogic tells game to do.
		if (message.equals("Bought")) {
			stateInformationToGUI(String.format(GameText.buyInfo[1], players[turn].getPlayerName(),
					GameText.fieldTitles[players[turn].getPosition() - 1]));
			updateFieldOwner(players[turn].getPosition(), (Ownable) gameBoard.getField(players[turn].getPosition()),
					false);
		} else if (message.equals("Not bought"))
			stateInformationToGUI(
					String.format(GameText.buyInfo[0], GameText.fieldTitles[players[turn].getPosition() - 1]));
		else if (message.equals("")) {
		} else {
			stateInformationToGUI(String.format(GameText.turnInformation[1], players[turn].getPlayerName(),
					dice.getDiceValue()[0], dice.getDiceValue()[1]));
			stateInformationToGUI(String.format(GameText.rentText[1], Integer.parseInt(message),
					((Ownable) gameBoard.getField(players[turn].getPosition())).getOwner().getPlayerName()));
		}
		// If the player has lost, make sure he loses all his property.
		if (players[turn].getPlayerHasLost()) {
			InformationHandler.removePlayer(players[turn].getPlayerName());
			updateAllFieldOwners();
			gameBoard.removeAllPlayerFields(players[turn].getPlayerName());
			// Changes the players balance to -1
			players[turn].changeAccountBalance(-players[turn].getAccountBalance() - 1);
			// Tell the player he lost.
			stateInformationToGUI(String.format(GameText.winLose[1], players[turn].getPlayerName()));
		}
		// Update the balance of the players.
		updatePlayerBalances();
	}

	/**
	 * Change the balance of all players.
	 */
	public void updatePlayerBalances() {
		for (int i = 0; i < players.length; i++)
			InformationHandler.changePlayerBalance(players[i].getPlayerName(), players[i].getAccountBalance());
	}

	/**
	 * Run the game.
	 */
	public void runGame() {
		// As long as no one has won, change who's turn it is and play that
		// turn.
		while (true) {
			changeTurn();

			playTurn();
			// Check if someone has won
			Player winner = lookForWinner();
			// If someone won tell them they won and break the loop.
			if (winner != null) {
				stateInformationToGUI(String.format(GameText.winLose[0], winner.getPlayerName()));
				break;
			}
		}

	}
/**
 * Prompts the InformationHandler to change the GUI
 * @param msg What the player is told.
 */
	public void stateInformationToGUI(String msg) {
		InformationHandler.ShowInformation(msg, GameText.getButtonText("ok"));
	}
/**
 * Method that makes the game reroll the dice.
 * @return
 */
	public int askForDiceRoll() {
		dice.shakeCup();
		return dice.getDiceValue()[0] + dice.getDiceValue()[1];
	}
/**
 * Method that checks if all players except one has lost the game.
 * @return Player winner
 */
	public Player lookForWinner() {
		Player winningPlayer = null;
		for (int i = 0; i < players.length; i++) {
			if (!players[i].getPlayerHasLost())
				if (winningPlayer == null)
					winningPlayer = players[i];
				else
					return null;

		}
		return winningPlayer;
	}

}