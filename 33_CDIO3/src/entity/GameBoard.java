package entity;

import boundary_entity.GameText;
import entity.fields.Field;
import entity.fields.Fleet;
import entity.fields.LaborCamp;
import entity.fields.Refuge;
import entity.fields.Tax;
import entity.fields.Territory;

public class GameBoard {

	//Instance variables
	public Field[] fields;
	
	/**
	 * Object gameBoard constructor.
	 * Constructs a gameBoard with 21 fields. 
	 * 11 Territory fields, 2 refuge fields, 2 labor camps, 2 tax fields and 4 fleets.
	 */
	public GameBoard()
	{
		//Price array for the territory fields listed as in the assignment.
		int[] price = {1000,1500,2000,3000,4000,4300,4750,5000,5500,6000,8000};
		//Rent array for the territory fields listed as in the assignment.
		int[] rent = {100,300,500,700,1000,1300,1600,2000,2600,3200,4000};
		
		// Creates a Field array with 21 fields.
		fields = new Field[21];
		
		//Territory fields created.
		//Those are created from the price array and the rent array and the gameText class.
		
		for(int i = 0 ; i < 11 ; i++)
		{
			fields[i] = new Territory(GameText.fieldTitles[i],rent[i], price[i]);			
		}
		
		//Refuge fields created.
		
		fields[11] = new Refuge(GameText.fieldTitles[11],5000);	
		fields[12] = new Refuge(GameText.fieldTitles[12],500);	

		//LaborCamp fields created.
		
		fields[13] = new LaborCamp(GameText.fieldTitles[13],2500);	
		fields[14] = new LaborCamp(GameText.fieldTitles[14],2500);	

		//Tax fields created.
		
		fields[15] = new Tax(GameText.fieldTitles[15],2000, 10);
		fields[16] = new Tax(GameText.fieldTitles[16],4000, 10);

		//Fleet fields created.
		
		for(int j = 0; j < 4 ; j++)
		{
			fields[17+j] = new Fleet(GameText.fieldTitles[17+j],4000);	
		}
	}	
}
