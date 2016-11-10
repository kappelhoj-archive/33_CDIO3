package boundary_entity;

public class GameText {
	public static String[] fieldTitles={
			/*(001)*/	"Tower",
			/*(002)*/	"Crater",
			/*(003)*/	"Palace Gates",
			/*(004)*/	"Cold Desert",
			/*(005)*/	"Walled City",
			/*(006)*/	"Monastery",
			/*(007)*/	"Black Cave",
			/*(008)*/	"Huts in the Mountain",
			/*(009)*/	"The Werewall",
			/*(010)*/	"The Pit",
			/*(011)*/	"Goldmine"};
				public static String[] fieldSubText={
			/*(101)*/	"+250",
			/*(102)*/	"-100",
			/*(103)*/	"+100",
			/*(104)*/	"-20",
			/*(105)*/	"+180",
			/*(106)*/	"0",
			/*(107)*/	"-70",
			/*(109)*/	"+60",
			/*(108)*/	"-80 +T",
			/*(110)*/	"-50",
			/*(111)*/	"+650"};
				
				public static String[] fieldDescription={
			/*(201)*/   "Along your journey, you come across a dark tower.  A through exploration reveals a chest of gold. You recover treasures worth 250 gold coins.\n\n\n",
			/*(202)*/   "A huge crater blocks your further journey. It stretches on for hundreds of feet. A quick search near the mound of the crater reveals a rusty trolley and a railroad track. The tracks lead across the crater. A red imp sits in a ticketstand next to the old worn trolley. You pay the hefty price of 100 gold coins to cross the crater.\n",
			/*(203)*/	"Your path leads you to a monstrous pair of palace gates. One herculean effort later, you finally manage to open the gates, revealing a sizeable pile of gold. You fill your pockets with 100 gold coins.\n\n\n",
			/*(204)*/	"The extreme heat of the desert is quickly replaced by a bone chilling cold. Your comfortable clothes provide little protection, and you shiver throughout the night. Your shivering causes a few gold coins to drop from your pockets. You lose 20 gold coins.\n\n",
			/*(205)*/	"Your journey leads to a walled city. The ruling lord fancies your mission and is intrigue by your tales of your travels. He provides you with additional funds to continue your  travelling. You have been gifted 180 gold coins.\n\n",
			/*(206)*/	"A lone monastery break the uniformity of the surrounding land. The friendly monks can only provide a warm nights rest, and a decent meal. You gladly accept the offer. Your funds are not affected.\n\n\n",
			/*(207)*/	"A black cave scars the mountainous regions on your way. As you draw closer to the entrance, a group of bandits surround you. It's an ambush. 'Anyone who wishes to pass my mountains must first pay the toll', the leader of the bandits say. You are forced to pay the 'toll' of 70 gold coins.\n\n",
			/*(208)*/	"During a treacherous path in the woods, you come across an injured woodsman. The forester has had an accident, and can't walk on his own. He offers you pay and a meal if you help him back home. You help the forester back to his hut in the mountains, and receive 60 gold coins in return for your good deed.\n",
			/*(209)*/	"Waking up after a deep night sleep, you notice a low rumbling in the distance. Scouting the horizon, you spot a huge black mass of werewolves, of various sizes. Franticly scrambling to gather your belongings, you miss a small bag of gold in your hurry. You lose 80 gold coins to the furry menace. Your quick departure earns you a second roll of the dice.\n",
			/*(210)*/	"Enraptured by the surrounding greenery, you fail to notice the huge pit in front of you. Tumbling down the side of the  pit, your gold lined pockets scatter their contents. You lose 50 gold coins on your painful way down.\n\n",
			/*(211)*/	"In your journey, you happen to meet a friendly dwarf. He offers you a huge payment in return for helping him recover a large gold ingot lodged inside his goldmine. You spend the rest of the day working alongside the dwarf, and succesfully retrieve the shiny metal. The dwarfs rewards you a staggering 650 gold coins!\n"
			};
				public static String[] fieldShortDescription={
			/*(301)*/   "A dark tower.",
			/*(302)*/   "A huge crater.",
			/*(303)*/	"The palace gates.",
			/*(304)*/	"A cold desert.",
			/*(305)*/	"The walled city.",
			/*(306)*/	"A lone monastery.",
			/*(307)*/	"A black cave.",
			/*(308)*/	"Huts on a mountain.",
			/*(309)*/	"A werewolf wall.",
			/*(310)*/	"A large pit.",
			/*(311)*/	"A Goldmine filled with gold."
						};
				
				
				/**
				 * The method enterPlayerNames returns a string Which asks the players to enter their names.
				 * @param  The number of the player
				 * @return String
				 */
				
				public static String enterPlayerNameText(int number)
				{
					return "Please enter the name of player " + number;
				}
				
				/**
				 * The method welcomeText returns a string which contains the welcome text of the game.
				 * @return String
				 */
				
				public static String welcomeText()
				{	
					return "Welcome to 'A Tale of Tales' \n";
				}
				
				
				/**
				 * The method gameRules returns a string which contains the game rules.
				 * @return String
				 */
				public static String gameRulesText()
				{
					String gameRules = "";
					gameRules = "The game rules are as follows: \n";
					gameRules = gameRules 
						      + "- All players start with 1000 gold coins. \n"
							  + "- The first player to achieve 3000 gold coins wins the game. \n"
							  + "- A players funds are affected each turn. The amount depends on which field you land on in the current turn. \n"
							  + "- A player always lands on the field number corresponding to the sum of the dice. \n";
					return gameRules;
				}
				
				/**
				 * The firstTurn method returns a string which contains which player has 
				 * been randomly selected to start the game. 
				 * @param playerName The name of the player
				 * @return String
				 */
				public static String firstTurnText()
				{
					return "A player has been randomly selected to start the game. \n"; 
				}
				
				/**
				 * The method turn returns a string which contains whose turn it is.
				 * @param playerName The name of the player
				 * @return String
				 */
				public static String turnText(String playerName)
				{
					return "It is " + playerName + "'s turn \n";
				}
				
				/**
				 * The method extraTurn returns a string which tell who has got an extra turn.
				 * @param playerName The name of the player
				 * @return String
				 */
				public static String extraTurnText(String playerName)
				{
					return playerName + " has gained an extra turn \n";
				}
				
				/**
				 * The method rollText returns a String which contains what a particular player has rolled with the dice.
				 * @param playerName The name of the player (String).
				 * @param value A array of two dice values (Int[])
				 * @return String 
				 */
				public static String rollText(String playerName, int[] value)
				{
					return playerName + " has rolled a " + value[0] + " and a " + value[1] + "."+ "\n";
				}
				
				/**
				 * The method winnerText returns a String which contains which player has won the game
				 * @param playerName The name of the player.
				 * @return String
				 */
				public static String winnerText(String playerName)
				{
					return "Congratulations " + playerName + " has won the game! \n";
				}
}
