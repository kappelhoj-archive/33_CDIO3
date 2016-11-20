package test.gui;

import boundary.GUIHandler;
import entity.DiceCup;

public class GUITest {
	public static void main(String[] args) {
		String[] names = { "Bo", "Bob", "Lis", "Bente", "Anton", "Hans-Peter" };
		GUIHandler gui = new GUIHandler(names);
		DiceCup d = new DiceCup();

		// Test if all the cars move correctly.
		for (int i = 0; i < names.length; i++) {
			gui.showTurnStart(names[i]);
			d.shakeCup();

			gui.landOnOwnable(names[i], d.getDiceValue()[0] + d.getDiceValue()[1], d.getDiceValue(), "Territory");
		}

		// Check to see if we can change the balance of a player, and if it appears correctly
		// on the GUI-screen.
		gui.changePlayerBalance("Bo", 2000);

		// Tests the landOnOwned method, to see if the GUI correctly reads the owned fields of a player.
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Territory", "Lis", 700);
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Fleet", "Lis", 4000);
		gui.landOnOwned("Bo", 1, d.getDiceValue(), "Labor Camp", "Lis", 4000);
		gui.showLaborCampResult("Bo", d.getDiceValue(), "Lis", 100 * (d.getDiceValue()[0] + d.getDiceValue()[1]));
		
		//Tests the landOnOther method.
		gui.landOnRefuge("Bo", 1, 4000, d.getDiceValue());
		gui.landOnTax("Bo", 1, 2000, 30000, d.getDiceValue());

		//Tests the BuyField Messages, to see if they work properly with a specified player and amount.
		gui.askPlayerBuyField("Bo", 1);
		gui.boughtField("Bo", 1, 5000);
		gui.cantAffordField(1);
		gui.setOwnerOfField("Bo", 1);
		
		//Tests if the correct win and lose messages appear on the screen.
		gui.loseGame("Bo");
		gui.endGame("Bo");
		
		// Tests to see if the field is correctly set to be owned to the right player,
		// and if the field is correctly removed again when called via the removeOwnerOfField-method.
		gui.setOwnerOfField("Bo", 1);
		gui.setOwnerOfField("Bo", 2);
		gui.removeOwnerOfField(2);

	}
}
