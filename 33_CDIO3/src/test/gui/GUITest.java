package test.gui;

import boundary.GUIHandler;
import entity.DiceCup;

public class GUITest {
	public static void main(String[] args) {
		String[] names = { "Bo", "Bob", "Lis", "Bente", "Anton", "Hans-Peter" };
		GUIHandler gui = new GUIHandler(names);
		DiceCup d = new DiceCup();

		// Test if all the cars move
		for (int i = 0; i < names.length; i++) {
			gui.showTurnStart(names[i]);
			d.shakeCup();

			gui.landOnOwnable(names[i], d.getDiceValue()[0] + d.getDiceValue()[1], d.getDiceValue(), "Territory");
		}

		// Check to see if we can change the balance of a player, and it appears
		// on screen.
		gui.changePlayerBalance("Bo", 2000);

		// Test landOnOwned
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Territory", "Lis", 700);
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Fleet", "Lis", 4000);
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Labor Camp", "Lis", 4000);
		gui.showLaborCampResult("Bo", d.getDiceValue(), "Lis", 100 * (d.getDiceValue()[0] + d.getDiceValue()[1]));
		
		//Test landOnOther
		gui.landOnRefuge("Bo", 1, 4000, d.getDiceValue());
		gui.landOnTax("Bo", 1, 2000, 30000, d.getDiceValue());

		//Buy Field Messages
		gui.askPlayerBuyField("Bo", 1);
		gui.boughtField("Bo", 1, 5000);
		gui.cantAffordField(1);
		gui.setOwnerOfField("Bo", 1);
		
		//Lose and win game
		gui.loseGame("Bo");
		gui.endGame("Bo");
		
		// Set field owned , set field not owned
		gui.setOwnerOfField("Bo", 1);
		gui.setOwnerOfField("Bo", 2);
		gui.removeOwnerOfField(2);

	}
}
