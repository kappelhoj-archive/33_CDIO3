package entity.text;

public class Text {
	/**
	 * The method  returns a String of the field title.
	 * @param field name.
	 * @return String
	 */
	public static String[] fieldTitles={
/*(001)*/	"Tribe Encampment",
/*(002)*/	"Crater",
/*(003)*/	"Mountain",
/*(004)*/	"Cold Desert",
/*(005)*/	"Black cave",
/*(006)*/	"The Werewall",
/*(007)*/	"Mountain village",
/*(008)*/	"South Citadel",
/*(009)*/	"Palace gates",
/*(010)*/	"Tower",
/*(011)*/	"Castle",
/*(012)*/	"Walled city",
/*(013)*/	"Monastery",
/*(014)*/	"Huts in the  mountain",
/*(015)*/	"The pit",
/*(016)*/	"Goldmine",
/*(017)*/	"Caravan",
/*(018)*/	"Second Sail",
/*(019)*/	"Sea Grover",
/*(020)*/	"The Buccaneers",
/*(021)*/	"Privateer armade"};
	
	/**
	 * The method  returns a String of the button text.
	 * @param button name.
	 * @return String
	 */
	public static String[] fieldSubText={
/*(101)*/	"1000",
/*(102)*/	"1500",
/*(103)*/	"2000",
/*(104)*/	"3000",
/*(105)*/	"4000",
/*(106)*/	"4300",
/*(107)*/	"4750",
/*(108)*/	"5000",
/*(109)*/	"5500",
/*(110)*/	"6000",
/*(111)*/	"8000",
/*(112)*/	"+5000",
/*(113)*/	"+500",
/*(114)*/	"2500",
/*(115)*/	"2500",
/*(116)*/	"-2000(tax)",
/*(117)*/	"-4000(tax)",
/*(118)*/	"4000",
/*(119)*/	"4000",
/*(120)*/	"4000",
/*(121)*/	"4000"};
	
	/**
	 * The method  returns a String of the field description.
	 * @param description name.
	 * @return String
	 */
	public static String[] fieldShortDescription={
/*(201)*/	"Tribe Encampment has a price of 1000, and a rent of 100",
/*(202)*/	"Crater has a price of 1500, and a rent of 300",
/*(203)*/	"Mountain has a price of 2000, and a rent of 500",
/*(204)*/	"Cold Desert has a price of 3000, and a rent of 700",
/*(205)*/	"Black Cave has a price of 4000, and a rent of 1000",
/*(206)*/	"The Werewall has a price of 4300, and a rent of 1300",
/*(207)*/	"Crater has a price of 4750, and a rent of 1600",
/*(208)*/	"South Citadel has a price of 5000, and a rent of 2000",
/*(209)*/	"Palace gates has a price of 5500, and a rent of 2600",
/*(210)*/	"Tower has a price of 6000, and a rent of 3200",
/*(211)*/	"Castle has a price of 8000, and a rent of 4000",
/*(212)*/	"When you land on the Walled city you receive a bonus of 5000",
/*(213)*/	"When you land on the Monastery you receive a bonus of 500",
/*(214)*/	"Huts in the mountain is labor camp. Roll the dice and pay 100 times what you roll.",
/*(215)*/	"The pit is labor camp. Roll the dice and pay 100 times what you roll.",
/*(216)*/	"If you land on the Goldmine you have to pay 2000 or 10% og your fortune to the owner.",
/*(217)*/	"If you land on the Caravan you have to pay 4000 or 10% og your fortune to the owner.",
/*(218)*/	"When you land on Second sail you have to pay between 500-400 in rent, dependent on how many fleets the owner has.",
/*(219)*/	"When you land on Sea Grover you have to pay between 500-400 in rent, dependent on how many fleets the owner has.",
/*(220)*/	"When you land on The Buccaneers you have to pay between 500-400 in rent, dependent on how many fleets the owner has.",
/*(221)*/	"When you land on Privateer armade you have to pay between 500-400 in rent, dependent on how many fleets the owner has."};

	/**
	 * The method getButtonText returns a String of the button text.
	 * @param button name.
	 * @return String
	 */
	public static String getButtonText(String m)
	{
		switch(m)
		{
		case "Yes":
			return "Yes";
		case "No":
			return "No";
		case "10%":
			return "10%";
		case "int":
			return "int";
		case "ok":
			return "OK";
		}
		return "BUTTON ERROR";
	}
}
