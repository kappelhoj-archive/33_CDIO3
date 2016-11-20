package entity.text;

public class DecisionText extends Text {
	/**
	 * Argument 0, do you want to buy this field, input: String playerName,
	 * String fieldName, int price<br>
	 * Argument 1, do you want to pay constant tax or 10%, input: String fieldName, int tax
	 */
	public static String[] questions = { "Do you, %s, want to buy %s for %d? \n",
			"Because you landed on %s you will have to pay tax, you can choose to pay %d or pay 10%% of your fortune \n"

	};

}
