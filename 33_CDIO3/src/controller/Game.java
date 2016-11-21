package controller;

import boundary.InformationHandler;
import entity.*;
import entity.fields.*;
import entity.text.GameText;

public class Game {
	int turn;
	Player[] players;
	GameCreator GameStarter;
	DiceCup dice;
	GameBoard gameBoard;

	public Game() {
		// Creates a DiceCup
		dice = new DiceCup();
		// Creates the game board
		gameBoard = new GameBoard();
		// Start the TUI
		GameStarter = new GameCreator();
		// Ask for the player names
		String[] playerNames = GameStarter.gameStart();
		// Initialize the gui and players
		this.players = new Player[playerNames.length];

		for (int i = 0; i < players.length; i++) {
			this.players[i] = new Player(playerNames[i]);
		}
		// Pick a random player to start.
		turn = (int) (Math.random() * players.length);

	}

	public void showLandText(Field field) {
		String type = field.getType();
		String output = "";
		output += String.format(GameText.turnInformation[1], players[turn].getPlayerName(), dice.getDiceValue()[0],
				dice.getDiceValue()[1]);
		output += String.format(GameText.standardFieldText[0], players[turn].getPlayerName(),
				GameText.fieldTitles[players[turn].getPosition() - 1]);
		output += String.format(GameText.standardFieldText[1], GameText.fieldTitles[players[turn].getPosition() - 1],
				type);

		if (type.equals("Territory") || type.equals("Fleet") || type.equals("Labor Camp")) {
			if (((Ownable) field).getOwner() != null
					&& !((Ownable) field).getOwner().getPlayerName().equals(players[turn].getPlayerName())) {
				output += String.format(GameText.rentText[0], ((Ownable) field).getOwner().getPlayerName());

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
		switch (type) {
		case "Refuge":
			output += String.format(GameText.standardFieldText[2], ((Refuge) field).getBonus());
			break;
		default:
			break;

		}
		stateInformationToGUI(output);
	}

	public void changeTurn() {
		do {
			turn = (turn + 1) % players.length;
		} while (players[turn].getPlayerHasLost());
		stateInformationToGUI(String.format(GameText.turnInformation[0], players[turn].getPlayerName()));
	}

	public void movePlayer() {
		dice.shakeCup();
		int sum = dice.getDiceValue()[0] + dice.getDiceValue()[1];
		if (players[turn].getPosition() + sum <= 21) {
			players[turn].setPosition(players[turn].getPosition() + sum);
		} else {
			int difference = 21 - players[turn].getPosition();
			players[turn].setPosition(sum - difference);
		}
		InformationHandler.showRoll(dice.getDiceValue());
		InformationHandler.movePlayer(players[turn].getPlayerName(), players[turn].getPosition());
	}

	public void updateAllFieldOwners() {
		for (int i = 1; i < 22; i++) {
			if (!gameBoard.getField(i).getType().equals("Refuge") && !gameBoard.getField(i).getType().equals("Tax"))
				if (((Ownable) gameBoard.getField(i)).getOwner() != null)
					if (((Ownable) gameBoard.getField(i)).getOwner().getPlayerName()
							.equals(players[turn].getPlayerName()))
						updateFieldOwner(i, (Ownable) gameBoard.getField(i), true);
		}
	}

	public void updateFieldOwner(int position, Ownable field, boolean reset) {
		String name = field.getOwner().getPlayerName();
		if (reset)
			InformationHandler.removeOwnerOfField(position);
		else
			InformationHandler.setOwnerOfField(name, position);
	}

	public void playTurn() {
		movePlayer();
		showLandText(gameBoard.getField(players[turn].getPosition()));
		String message = GameLogic.landOnField(players[turn], gameBoard.getField(players[turn].getPosition()), this);
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

		if (players[turn].getPlayerHasLost()) {
			updateAllFieldOwners();
			gameBoard.removeAllPlayerFields(players[turn].getPlayerName());

			stateInformationToGUI(String.format(GameText.winLose[1], players[turn].getPlayerName()));
		}
		updatePlayerBalances();
	}

	public void updatePlayerBalances() {
		for (int i = 0; i < players.length; i++)
			InformationHandler.changePlayerBalance(players[i].getPlayerName(), players[i].getAccountBalance());
	}

	public void runGame() {

		while (true) {
			changeTurn();

			playTurn();

			Player winner = lookForWinner();
			if (winner != null) {
				stateInformationToGUI(String.format(GameText.winLose[0], winner.getPlayerName()));
				break;
			}
		}

	}

	public void stateInformationToGUI(String msg) {
		InformationHandler.ShowInformation(msg, GameText.getButtonText("ok"));
	}

	public int askForDiceRoll() {
		dice.shakeCup();
		return dice.getDiceValue()[0] + dice.getDiceValue()[1];
	}

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