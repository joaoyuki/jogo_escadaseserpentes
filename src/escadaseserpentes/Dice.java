package escadaseserpentes;

import java.util.Random;

public class Dice {

	private static final int MAX_DICE_NUMBER = 6;

	private static Dice uniqueDiceInstance;
	
	private Random random = new Random();
	
	private Dice() {
	}
	
	public static Dice createDice() {
		if (uniqueDiceInstance == null) {
			uniqueDiceInstance = new Dice();
		}
		return uniqueDiceInstance;
	}
	
	public int roll() {
		return random.nextInt(MAX_DICE_NUMBER) + 1;
	}
	
}
