package boundary;

import desktop_resources.GUI;

public class DecisionHandler {
	//Ask a true false question to the user
	public static boolean askQuestion(String msg, String trueButton,String falseButton){
		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);
	}
}
