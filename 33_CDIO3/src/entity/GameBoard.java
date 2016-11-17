package entity;

import entity.fields.*;

public class GameBoard {

	// Instance variables
	private Field[] fields;

	/**
	 * Object gameBoard constructor. Constructs a gameBoard with 21 fields. 11
	 * Territory fields, 2 refuge fields, 2 labor camps, 2 tax fields and 4
	 * fleets.
	 */
	public GameBoard() {
		// Price array for the territory fields listed as in the assignment.
		int[] price = { 1000, 1500, 2000, 3000, 4000, 4300, 4750, 5000, 5500, 6000, 8000 };
		// Rent array for the territory fields listed as in the assignment.
		int[] rent = { 100, 300, 500, 700, 1000, 1300, 1600, 2000, 2600, 3200, 4000 };

		// Creates a Field array with 21 fields.
		fields = new Field[21];

		// Territory fields created.
		// Those are created from the price array and the rent array and the
		// gameText class.

		for (int i = 0; i < 11; i++) {
			fields[i] = new Territory("Territory", price[i], rent[i]);
		}

		// Refuge fields created.

		fields[11] = new Refuge("Refuge", 5000);
		fields[12] = new Refuge("Refuge", 500);

		// LaborCamp fields created.

		fields[13] = new LaborCamp("Labor Camp", 2500);
		fields[14] = new LaborCamp("Labor Camp", 2500);

		// Tax fields created.

		fields[15] = new Tax("Tax", 2000, 10);
		fields[16] = new Tax("Tax", 4000, 10);

		// Fleet fields created.

		for (int j = 0; j < 4; j++) {
			fields[17 + j] = new Fleet("Fleet", 4000);
		}
	}

	public Field getField(int position) {
		return fields[position - 1];
	}

	public void removeAllPlayerFields(String playerName) {
		for (int i = 0; i < fields.length; i++) {
			if ((fields[i].getType() != "Refuge" && fields[i].getType() != "Tax"))
				if (((Ownable) fields[i]).getOwner() != null)
					if (((Ownable) fields[i]).getOwner().getPlayerName().equals(playerName))
						((Ownable) fields[i]).removeOwner();
		}
	}

}
