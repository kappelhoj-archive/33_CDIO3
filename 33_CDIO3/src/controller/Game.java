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
			if (((Ownable) field).getOwner() != null)
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
		do{
			turn = (turn + 1) % players.length;
		}while (players[turn].getPlayerHasLost());
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
				updateFieldOwner(i + 1, (Ownable) gameBoard.getField(i + 1));
		}
	}

	public void updateFieldOwner(int position, Ownable field) {

		gui.setOwnerOfField(field.getOwner().getPlayerName(), position);
	}

	public void playTurn() {
		movePlayer();
		showLandText(gameBoard.getField(players[turn].getPosition()));
		GameLogic.landOnField(players[turn],gameBoard.getField(players[turn].getPosition()), this);

		if (players[turn].getPlayerHasLost()) {
			gameBoard.removeAllPlayerFields(players[turn].getPlayerName());
			updateAllFieldOwners();
			gui.loseGame(players[turn].getPlayerName());
		}
		gui.changePlayerBalance(players[turn].getPlayerName(), players[turn].getAccountBalance());
	}

	public void runGame() {

		while (true) {
			playTurn();
			changeTurn();
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