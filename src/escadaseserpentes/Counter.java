package escadaseserpentes;

public class Counter{
	
	private String name;
	private Space currentSpace;
	
	public Counter(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Space getCurrentSpace() {
		return currentSpace;
	}
	public void setCurrentSpace(Space currentSpace) {
		this.currentSpace = currentSpace;
	}
	public void goTo(Space spaceStartHere) {
		currentSpace = spaceStartHere;
	}
	
	public void play(Board board) {
		Dice dice = Dice.createDice();
		int diceNumber = dice.roll();
		System.out.format("Jogador '%s' jogou o dado e o resultado foi %d\n", name, diceNumber );
		board.move(this, diceNumber);
	}

}
