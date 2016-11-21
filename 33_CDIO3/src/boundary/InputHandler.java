package boundary;

import desktop_resources.GUI;

public class InputHandler {

	/**
	 * Method that ask the player to input a String.
	 * 
	 * @param msg
	 *            Message for the user
	 * @return The user string input
	 */
	public static String AskForString(String msg) {
		return GUI.getUserString(msg);
	}

	/**
	 * Method that ask the player to enter an integer.
	 * 
	 * @param msg
	 *            The question for the player.
	 * @param min
	 *            The minimal value.
	 * @param max
	 *            The maximum value.
	 * @return The integer input
	 */
	public static int AskForInt(String msg, int min, int max) {
		return GUI.getUserInteger(msg, min, max);
	}

}
