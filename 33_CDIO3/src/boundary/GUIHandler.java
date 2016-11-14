package boundary;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import boundary_entity.GameText;

public class GUIHandler {
	Field[] fields = new Field[21];
	 
	/**
	 * Intialize the board on the screen
	 * @param players
	 */
	public GUIHandler(String[] players) {
		//Creates 11 fields
		for (int i = 0; i < 21; i++)
			fields[i] = new Street.Builder() 
			.setTitle(GameText.fieldTitles[i])
			.setSubText(GameText.fieldSubText[i])
			.setDescription(GameText.fieldShortDescription[i])
			.build();

		//Create the board and add the 11 fields.
		GUI.create(fields);
		//Creates cars for the 6 players.
		Car[] cars=createCars();
		for(int i=0;i<players.length;i++)
			GUI.addPlayer(players[i],30000,cars[i]);
		//Sets the dice to some random value
		GUI.setDice(1,1);
	}
	/**
	 * Creates 2 cars one for each player.
	 * @return
	 */
	 private Car[] createCars(){
		 Car[] carArray =new Car[6];
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
			carArray[2]=new Car.Builder()
					.primaryColor(Color.GREEN)
					.secondaryColor(Color.WHITE)
					.typeTractor()
					.patternFill()
					.build();
			carArray[3]=new Car.Builder()
					.primaryColor(Color.YELLOW)
					.secondaryColor(Color.WHITE)
					.typeTractor()
					.patternFill()
					.build();
			carArray[4]=new Car.Builder()
					.primaryColor(Color.BLACK)
					.secondaryColor(Color.WHITE)
					.typeRacecar()
					.patternFill()
					.build();
			carArray[5]=new Car.Builder()
					.primaryColor(Color.WHITE)
					.secondaryColor(Color.BLACK)
					.typeRacecar()
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
	
	public void showTurnStart(String playerName){
		GUI.getUserButtonPressed(GameText.turnText(playerName), GameText.getButtonText("ok"));
	}
	private void showRoll(int[] currentDice){
		
		//Set the dice face values. 
		GUI.setDice(currentDice[0],currentDice[1]);
		//GUI.setDice(currentDice[0],1+varians(),4+varians(), currentDice[1],2+varians(),7+varians());
	}	

	public void landOnField(String playerName,int playerPosition,int[] currentDice,String fieldType){	
		showRoll(currentDice);
		//Moves the player to the new position
		movePlayer(playerName,playerPosition);
		//Gives the user some text.
		String out=GameText.rollText(playerName, currentDice);
		out+=GameText.landOnFieldText(playerName, GameText.fieldTitles[playerPosition-1]);
		out+=GameText.fieldNotOwnedText(fieldType, GameText.fieldTitles[playerPosition-1]);
		
		GUI.getUserButtonPressed(out+"\n",GameText.getButtonText("ok"));	
	}
	
	public void landOnOwnedField(String playerName,int playerPosition,int[] currentDice,String fieldType,String fieldOwner,int rent){	
		showRoll(currentDice);
		//Moves the player to the new position
		movePlayer(playerName,playerPosition);
		//Gives the user some text.
		String out=GameText.rollText(playerName, currentDice);
		out+=GameText.landOnFieldText(playerName, GameText.fieldTitles[playerPosition-1]);
		GameText.ownedFieldText(playerName,fieldType,fieldOwner,rent);
		
		GUI.getUserButtonPressed(out+"\n",GameText.getButtonText("ok"));
	}
	public void showLaborCampResult(String playerName,int[] currentDice,String fieldOwner,int rent){
		showRoll(currentDice);
		String out=GameText.rollText(playerName, currentDice);
		out+=GameText.ownedLaborCampAfterRoll(fieldOwner,rent);
		GUI.getUserButtonPressed(out,GameText.getButtonText("ok"));
	}
	
	public boolean askPlayerBuyField(String playerName,int playerPosition){
		return GUI.getUserLeftButtonPressed(GameText.buyfieldText(playerName, GameText.fieldTitles[playerPosition-1],  GameText.fieldSubText[playerPosition]), GameText.getButtonText("yes"),GameText.getButtonText("no"));
		
	}
	public void boughtField(String playerName,int playerPosition,int playerBalance){
		changePlayerBalance(playerName, playerBalance);
		GUI.getUserButtonPressed(GameText.boughtFieldText(playerName,GameText.fieldTitles[playerPosition-1]) ,GameText.getButtonText("ok"));	
	}
	public void cantAffordField(String playerName,int playerPosition){
		GUI.getUserButtonPressed(GameText.cantBuyFieldText(playerName,GameText.fieldTitles[playerPosition-1]) ,GameText.getButtonText("ok"));	

	}
	public void tellRefuge(String playerName,int playerPosition,int amount){
		GUI.getUserButtonPressed(GameText.refugeText(playerName,GameText.fieldTitles[playerPosition-1],amount) ,GameText.getButtonText("ok"));	
	}
	public boolean tellTax(String playerName,int playerPosition,int tax,int playerFortune){
		return GUI.getUserLeftButtonPressed(GameText.taxText(playerName, GameText.fieldTitles[playerPosition-1],tax), GameText.getButtonText("10%")+playerFortune*0.01,tax+"");
	}
	
	
	
	
	public void changePlayerBalance(String playerName,int playerBalance){
	//Change the balance.
			GUI.setBalance(playerName, playerBalance);
			
			
	}

	
	
	
	public void loseGame(String playerName){
		GUI.getUserButtonPressed(GameText.lostText(playerName),GameText.getButtonText("ok")); 
	}
	/**
	 * A message that appear when the game ends.
	 * @param playerName
	 */
    public void endGame(String playerName){	
    	GUI.getUserButtonPressed(GameText.winnerText(playerName),"X"); 
	}
    
	/**
	 * Gives a random value between -1 and 1. Used to make the dice rolls appear random.
	 */
	public int varians(){
		return (int)(Math.round(Math.random()*2-1));
	}
}
