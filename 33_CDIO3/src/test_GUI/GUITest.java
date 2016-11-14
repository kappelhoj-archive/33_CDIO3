package test_GUI;

import boundary.GUIHandler;
import entity.DiceCup;

public class GUITest {
	public static void main(String[] args) {
		String[] names ={"Bo","Bob","Lis","Bente","Anton","Hans-Peter"};
		GUIHandler gui=new GUIHandler(names);
		DiceCup d= new DiceCup();
		
		
		//Test if all the cards move 
		for(int i=0;i<names.length;i++){
		gui.showTurnStart(names[i]);
		d.shakeCup();
		
		gui.landOnField(names[i],d.getDiceValue()[0]+d.getDiceValue()[1],d.getDiceValue(),"Territory");
		}
		
		
		//Check to see if we can change the balance
		gui.changePlayerBalance("Bo", 2000);
		//More to come
		
	}
}
