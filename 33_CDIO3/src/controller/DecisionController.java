package controller;

import boundary.DecisionHandler;
import entity.Player;
import entity.text.DecisionText;

public class DecisionController {

	public static boolean askForDecision(String question, int args, Player player) {
		boolean answer = false;
		switch (question) {
		case "Tax":
			answer = DecisionHandler.askQuestion(
					String.format(DecisionText.questions[1], DecisionText.fieldTitles[player.getPosition() - 1], args),
					DecisionText.getButtonText("10%")+" ("+ player.getPlayerFortune() * 0.1+")" , ""+args);
			break;
		case "Buy":
			answer = DecisionHandler.askQuestion(
					String.format(DecisionText.questions[0], player.getPlayerName(),DecisionText.fieldTitles[player.getPosition() - 1]),
					DecisionText.getButtonText("Yes"),DecisionText.getButtonText("No"));
			break;
		}
		return answer;
	}

}
