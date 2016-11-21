package boundary;

import desktop_resources.GUI;

public class InputHandler {
		
		public static String AskForString(String msg){
			return GUI.getUserString(msg);
		}
		public static int AskForInt(String msg,int min, int max){
			return GUI.getUserInteger(msg,min,max);
		}
		
}
