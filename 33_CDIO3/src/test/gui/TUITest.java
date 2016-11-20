package test.gui;

import boundary.TUI;

//Overall run-test of the games TUI, to see if the TUI correctly reads and interprets the player names.
public class TUITest {
	public static void main(String[] args) {
		TUI tui = new TUI();
		String[] players = tui.gameStart();
		System.out.println(players.length);
		for (String player : players) {
			System.out.println(player);
		}
	}
}
