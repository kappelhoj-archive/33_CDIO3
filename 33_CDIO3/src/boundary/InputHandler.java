package boundary;

import desktop_resources.GUI;

public class InputHandler {
		
		public String AskForString(String msg){
			return GUI.getUserString(msg);
		}
		public int AskForInt(String msg,int min, int max){
			return GUI.getUserInteger(msg,min,max);
		}
}
