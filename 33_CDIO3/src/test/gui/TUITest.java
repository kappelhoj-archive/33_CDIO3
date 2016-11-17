package test.gui;

import boundary.TUI;

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
