package entity;

import boundary_entity.GameText;

public class GameBoard {

	public Field[] fields;
	
	public GameBoard()
	{
		int[] price = {1000,1500,2000,3000,4000,4300,4750,5000,5500,6000,8000};
		
		int[] rent = {100,300,500,700,1000,1300,1600,2000,2600,3200,4000};
		
		// Create fields array with 21 elements.
		fields = new Field[21];
		
		
		for(int i = 0 ; i < 10 ; i++)
		{
			// Add a field in every element of fields array with rent and price.
			fields[i] = new Territory(GameText.fieldTitles[i],rent[i],null, price[i]);			
		}
		
		//Refuge
		
		fields[1] = new Refuge(GameText.fieldTitles[1],5000);	
		fields[2] = new Refuge(GameText.fieldTitles[2],500);	

		//Laborcamp
		
		fields[14] = new Laborcamp(GameText.fieldTitles[14],100, null);	
		fields[15] = new Laborcamp(GameText.fieldTitles[15],100, null);	

		//Tax
		
		fields[16] = new Tax(GameText.fieldTitles[16],2000, 10);
		fields[17] = new Tax(GameText.fieldTitles[17],4000, 10);

		
		for(int j = 0; j < 3 ; j++)
		{
			fields[j] = new Fleet(GameText.fieldTitles[j],400, null);	
		}
	}
	
	/**
	 * Method getFieldPrice returns the Price of a specific field.
	 * @param Field's index in the array.
	 * @return Price of a field.
	 */
	public int getFieldPrice(int fieldIndex)
	{
		return fields[fieldIndex].getPrice();
	}
	
	/**
	 * Method getFieldRent returns the Rent of a specific field.
	 * @param Field's index in the array.
	 * @return Rent of a field.
	 */
	public int getFieldRent(int fieldIndex)
	{
		return fields[fieldIndex].getRent();
	}
	
	
	
	
	
	
	
	
}
