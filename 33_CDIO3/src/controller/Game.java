package controller;

import boundary.GUIHandler;
import boundary.TUI;
import entity.Player;

public class Game {
	Player[] players;
	GUIHandler gui;
	TUI tui;

	public Game() {

		this.tui = new TUI();
		String[] playerNames = tui.gameStart();
		this.gui = new GUIHandler(playerNames);
		this.players = new Player[playerNames.length];
		
		for (int i = 0; i < players.length; i++) {
			this.players[i] = new Player(playerNames[i]);
		}

	}

}