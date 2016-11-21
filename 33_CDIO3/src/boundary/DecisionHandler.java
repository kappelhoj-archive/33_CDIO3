package boundary;

import desktop_resources.GUI;

public class DecisionHandler {
	
	/**
	 * Ask the player a question with 2 answer.
	 * @param msg This is the question the players has to answer
	 * @param trueButton Answer option 1
	 * @param falseButton Answer option 2
	 * @return boolean that contains the answer
	 */
	public static boolean askQuestion(String msg, String trueButton,String falseButton){
		//return true; //This line is for testing purposes
		
		//Send the player a message with 2 possible answers using the GUI.
		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);
	}
}
