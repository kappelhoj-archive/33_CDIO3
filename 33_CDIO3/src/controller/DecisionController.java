package controller;

import boundary.DecisionHandler;
import entity.Player;
import text.DecisionText;

public class DecisionController {

	/**
	 * Method that prepares a question for the user based on different
	 * parameters.
	 * 
	 * @param question
	 *            A string variable that describes what type of question is
	 *            asked.<br>
	 *            Current options are:<br>
	 *            "Tax"<br>
	 *            "Buy"<br>
	 * @param args
	 *            A integer variable used in some of the question, leave it
	 *            empty if not applicable
	 * @param player
	 *            The player object.
	 * @return True or false answer to the question.
	 */
	public static boolean askForDecision(String question, int args, Player player) {
		boolean answer = false;
		switch (question) {
		// Prepare a tax question
		case "Tax":
			answer = DecisionHandler.askQuestion(
					// Format the string
					String.format(DecisionText.questions[1], DecisionText.fieldTitles[player.getPosition() - 1], args),
					// Add the button text
					DecisionText.getButtonText("10%") + " (" + player.getPlayerFortune() * 0.1 + ")", "" + args);
			break;
		// Prepare a buy question
		case "Buy":

			answer = DecisionHandler.askQuestion(
					// Format the string
					String.format(DecisionText.questions[0], player.getPlayerName(),
							DecisionText.fieldTitles[player.getPosition() - 1],
							Integer.parseInt(DecisionText.fieldSubText[player.getPosition() - 1])),
					// Add the button text
					DecisionText.getButtonText("Yes"), DecisionText.getButtonText("No"));
			break;
		}
		return answer;
	}

}
