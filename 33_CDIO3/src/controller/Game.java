package controller;

import boundary.GUIHandler;
import boundary.TUI;
import entity.DiceCup;
import entity.Player;

public class Game {
	int turn;
	Player[] players;
	GUIHandler gui;
	TUI tui;
	DiceCup dice;

	public Game() {
		// Creates a DiceCup
		dice = new DiceCup();
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

	public void changeTurn() {
		turn = (turn + 1) % players.length;
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

	public void playTurn() {
		movePlayer();
		gui.landOnOwnable(players[turn].getPlayerName(), players[turn].getPosition(), dice.getDiceValue(), "Territory");
	}
	

	public void runGame() {

		while (true) {
			playTurn();
			changeTurn();
		}

	}
	
	public boolean askForDecision(String question,int[] args){
		boolean answer=false;
		switch(question){
		case "Tax": 
			answer=gui.landOnTax(players[turn].getPlayerName(), players[turn].getPosition(), args[0], args[1], dice.getDiceValue());
			break;
		case "Buy":
			answer=gui.askPlayerBuyField(players[turn].getPlayerName(),players[turn].getPosition());
			break;
		}
		return answer;
	}
	public int askForDiceRoll(){
		dice.shakeCup();
		return dice.getDiceValue()[0]+dice.getDiceValue()[1]; 	
	}

}