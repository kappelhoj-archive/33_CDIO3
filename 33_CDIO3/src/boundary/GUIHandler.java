package boundary;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import game.GameText;

public class GUIHandler {
	Field[] fields = new Field[11];
	 
	/**
	 * Intialize the board on the screen
	 * @param players
	 */
	GUIController(String[] players) {
		//Creates 11 fields
		for (int i = 0; i < 11; i++)
			fields[i] = new Street.Builder()
			.setTitle(GameText.fieldTitles[i])
			.setSubText(GameText.fieldSubText[i])
			.setDescription(GameText.fieldShortDescription[i])
			.build();

		//Create the board and add the 11 fields.
		GUI.create(fields);
		//Creates cars for the 2 players.
		Car[] cars=createCars();
		GUI.addPlayer(players[0],1000,cars[0]);
		GUI.addPlayer(players[1],1000,cars[1]);
		//Sets the dice to some random value
		GUI.setDice(1,1+varians(),5+varians(), 1,2+varians(),7+varians());
	}
	/**
	 * Creates 2 cars one for each player.
	 * @return
	 */
	 private Car[] createCars(){
		 Car[] carArray =new Car[2];
			carArray[0]=new Car.Builder()
					.primaryColor(Color.BLUE)
					.secondaryColor(Color.WHITE)
					.typeUfo()
					.patternFill()
					.build();
			carArray[1]=new Car.Builder()
					.primaryColor(Color.RED)
					.secondaryColor(Color.WHITE)
					.typeUfo()
					.patternFill()
					.build();
			return carArray;
	 }
	/**
	 * Move a player to a Field
	 * @param playerName Player name.
	 * @param position Position to move player to.
	 */
	private void movePlayer(String playerName,int position){
		//Remove all the cars of the player
		GUI.removeAllCars(playerName);
		//Place a new car on the new position.
		GUI.setCar(position, playerName);
	}
	/**
	 * Alerts the player of whose turn it is.
	 * @param playerName
	 * @param extraTurn
	 */
	public void startTurn(String playerName,boolean extraTurn){
		if(extraTurn)
			GUI.getUserButtonPressed(GameText.extraTurnText(playerName)+"\n\n\n\n\n\n","Roll");
		else
			GUI.getUserButtonPressed(GameText.turnText(playerName)+"\n\n\n\n\n\n","Roll");
	}
	
	/**
	 *  Gets information on the current turn and updates the GUI. 
	 * @param playerName
	 * @param playerBalance
	 * @param playerPosition
	 * @param currentDice
	 */
	public void getTurn(String playerName,int playerBalance,int playerPosition,int[] currentDice){	
		//Set the dice face values. 
		GUI.setDice(currentDice[0],1+varians(),4+varians(), currentDice[1],2+varians(),7+varians());
		//Moves the player to the new position
		movePlayer(playerName,playerPosition-1);
		//Gives the user some text.
		GUI.getUserButtonPressed(GameText.rollText(playerName, currentDice)+"\n"+GameText.fieldDescription[playerPosition-2]+"\n","Ok");
		//Change the balance.
		GUI.setBalance(playerName, playerBalance);
		
	}
	/**
	 * Gives a random value between -1 and 1. Used to make the dice rolls appear random.
	 */
	public int varians(){
		return (int)(Math.round(Math.random()*2-1));
	}
	
	/**
	 * A message that appear when the game ends.
	 * @param playerName
	 */
    public void endGame(String playerName){	
    	GUI.getUserButtonPressed(GameText.winnerText(playerName),"X"); 
	}
}
