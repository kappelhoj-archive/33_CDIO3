package controller;

import boundary.DecisionHandler;
import entity.Player;
import entity.text.DecisionText;

public class DecisionController {

	// Prepare a true false question for the user
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
