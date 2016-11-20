package boundary;

import desktop_resources.GUI;

public class DecisionHandler {
	public static boolean askQuestion(String msg, String trueButton,String falseButton){
		return GUI.getUserLeftButtonPressed(msg, trueButton, falseButton);
	}
}
