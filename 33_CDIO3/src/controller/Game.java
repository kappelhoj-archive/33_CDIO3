package controller;

import boundary.GUIHandler;
import boundary.TUI;
import entity.*;
import entity.fields.*;

public class Game {
	int turn;
	Player[] players;
	GUIHandler gui;
	TUI tui;
	DiceCup dice;
	GameBoard gameBoard;

	public Game() {
		// Creates a DiceCup
		dice = new DiceCup();
		// Creates the game board
		gameBoard = new GameBoard();
		// Start the TUI
		this.tui = new TUI();
		// Ask for the player names
		String[] playerNames = tui.gameStart();
		// Initialize the gui and players
		this.gui = new GUIHandler(playerNames);
		this.players = new Player[playerNames.length];

		for (int i = 0; i < players.length; i++) {
			this.players[i] = new Player(playerNames[i]);
		}
		// Pick a random player to start.
		turn = (int) (Math.random() * players.length);

	}

	public void showLandText(Field field) {
		String type = field.getType();
		switch (type) {
		case "Territory":
		case "Fleet":
		case "Labor Camp":
			if (((Ownable) field).getOwner() != null
					&& ((Ownable) field).getOwner().getPlayerName().equals(players[turn].getPlayerName()))
				gui.landOnOwned(players[turn].getPlayerName(), players[turn].getPosition(), dice.getDiceValue(), type,
						((Ownable) field).getOwner().getPlayerName(), field.getRent());
			else
				gui.landOnOwnable(players[turn].getPlayerName(), players[turn].getPosition(), dice.getDiceValue(),
						type);
			break;
		case "Refuge":
			gui.landOnRefuge(players[turn].getPlayerName(), players[turn].getPosition(), ((Refuge) field).getBonus(),
					dice.getDiceValue());
			break;
		}
	}

	public void changeTurn() {
		do {
			turn = (turn + 1) % players.length;
		} while (players[turn].getPlayerHasLost());
		gui.showTurnStart(players[turn].getPlayerName());
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
	}

	public void updateAllFieldOwners() {
		for (int i = 0; i < 21; i++) {
			if (gameBoard.getField(i + 1).getType().equals("Territory")
					|| gameBoard.getField(i + 1).getType().equals("Fleet")
					|| gameBoard.getField(i + 1).getType().equals("Labor Camp"))
				if (((Ownable) gameBoard.getField(i + 1)).getOwner() != null)
					updateFieldOwner(i + 1, (Ownable) gameBoard.getField(i + 1), true);
		}
	}

	public void updateFieldOwner(int position, Ownable field, boolean reset) {
		String name = field.getOwner().getPlayerName();
		if (reset)
			gui.removeOwnerOfField(position);
		else
			gui.setOwnerOfField(name, position);
	}

	public void playTurn() {
		movePlayer();
		showLandText(gameBoard.getField(players[turn].getPosition()));
		String message = GameLogic.landOnField(players[turn], gameBoard.getField(players[turn].getPosition()), this);
		if (message.equals("Bought")) {
			gui.boughtField(players[turn].getPlayerName(), players[turn].getPosition(),
					players[turn].getAccountBalance());
			updateFieldOwner(players[turn].getPosition(), (Ownable) gameBoard.getField(players[turn].getPosition()),
					false);
		} else if (message.equals("Not bought"))
			gui.cantAffordField(players[turn].getPosition());
		else if (message.equals("")) {
		} else {
			gui.showLaborCampResult(players[turn].getPlayerName(), dice.getDiceValue(),
					((Ownable) gameBoard.getField(players[turn].getPosition())).getOwner().getPlayerName(),
					Integer.parseInt(message));
		}

		if (players[turn].getPlayerHasLost()) {
			gameBoard.removeAllPlayerFields(players[turn].getPlayerName());
			updateAllFieldOwners();
			gui.loseGame(players[turn].getPlayerName());
		}
		updatePlayerBalances();
	}

	public void updatePlayerBalances() {
		for (int i = 0; i < players.length; i++)
			gui.changePlayerBalance(players[i].getPlayerName(), players[i].getAccountBalance());
	}

	public void runGame() {

		while (true) {
			changeTurn();

			playTurn();
		}

	}

	public boolean askForDecision(String question, int args) {
		boolean answer = false;
		switch (question) {
		case "Tax":
			answer = gui.landOnTax(players[turn].getPlayerName(), players[turn].getPosition(),
					/* Constant tax */args, players[turn].getPlayerFortune(), dice.getDiceValue());
			break;
		case "Buy":
			answer = gui.askPlayerBuyField(players[turn].getPlayerName(), players[turn].getPosition());
			break;
		}
		return answer;
	}

	public int askForDiceRoll() {
		dice.shakeCup();
		return dice.getDiceValue()[0] + dice.getDiceValue()[1];
	}

}