package boundary;

import java.awt.Color;

import boundary.entity.GameText;
import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class InformationHandler {
	private  Field[] fields = new Field[21];
	private Car[] cars;
	
	public void startGame(){
		// Creates 11 fields
				for (int i = 0; i < 21; i++)
					fields[i] = new Street.Builder().setTitle(GameText.fieldTitles[i]).setSubText(GameText.fieldSubText[i])
							.setDescription(GameText.fieldShortDescription[i]).build();

				// Create the board and add the 11 fields.
				GUI.create(fields);
				// Creates cars for the 6 players.
				cars = createCars();
	}
	
	public void addPlayers(String[] players){
		for (int i = 0; i < players.length; i++)
			GUI.addPlayer(players[i], 30000, cars[i]);
	}
	
	private Car[] createCars() {
		Car[] carArray = new Car[6];
		carArray[0] = new Car.Builder().primaryColor(Color.BLUE).secondaryColor(Color.BLACK).typeUfo().patternFill()
				.build();
		carArray[1] = new Car.Builder().primaryColor(Color.RED).secondaryColor(Color.BLACK).typeUfo().patternFill()
				.build();
		carArray[2] = new Car.Builder().primaryColor(Color.GREEN).secondaryColor(Color.BLACK).typeTractor()
				.patternFill().build();
		carArray[3] = new Car.Builder().primaryColor(Color.YELLOW).secondaryColor(Color.BLACK).typeTractor()
				.patternFill().build();
		carArray[4] = new Car.Builder().primaryColor(Color.BLACK).secondaryColor(Color.BLACK).typeRacecar()
				.patternFill().build();
		carArray[5] = new Car.Builder().primaryColor(Color.WHITE).secondaryColor(Color.BLACK).typeRacecar()
				.patternFill().build();
		return carArray;
	}
	
	
	
	public static void ShowInformation(String msg, String button) {
		GUI.getUserButtonPressed(msg, button);
	}
	public static void changePlayerBalance(String playerName, int playerBalance) {
		// Change the balance.
		GUI.setBalance(playerName, playerBalance);

	}
	
	public static void setOwnerOfField(String playerName, int position){
		GUI.setOwner(position, playerName);
	}
	public static void removeOwnerOfField(int position){
		GUI.removeOwner(position);
	}
	public static void movePlayer(String playerName, int position) {
		// Remove all the cars of the player
		GUI.removeAllCars(playerName);
		// Place a new car on the new position.
		GUI.setCar(position, playerName);
	}
	public static void showRoll(int[] currentDice) {
		GUI.setDice(currentDice[0], currentDice[1]);
	}

}
