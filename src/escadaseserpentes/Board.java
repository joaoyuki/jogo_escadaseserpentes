package escadaseserpentes;

import java.util.Arrays;

public class Board implements Printable{
	
	private static final int POSICAO_INICIAL = 0;
	private Space[] spaces;
	private Space spaceHome;
	private Space spaceStartHere;
	
	private Counter winnerCounter;
	
	public Board(int numSpaces) {
		
		spaces = new Space[numSpaces + 2];
		
		for (int i = 0; i < spaces.length; i++) {
			if(i ==  POSICAO_INICIAL) {
				spaces[i] = new Space(0, Type.STAR_HERE);
				spaceStartHere = spaces[i];
			} else if (i == spaces.length - 1) {
				spaces[i] = new Space(i, Type.HOME);
				spaceHome = spaces[i];
			} else {
				spaces[i] = new Space(i, Type.REGUALR);
			}
		}
		
	}

	@Override
	public String toString() {
		return "Board [spaces=" + Arrays.toString(spaces) + "]";
	}

	@Override
	public void print() {
		System.out.println("TABULEIRO");
		for (Space space : spaces) {
			System.out.println(space + " ");
		}
		System.out.println();
		
	}

	public Space[] getSpaces() {
		return spaces;
	}

	public void setSpaces(Space[] spaces) {
		this.spaces = spaces;
	}

	public Space getSpaceHome() {
		return spaceHome;
	}

	public void setSpaceHome(Space spaceHome) {
		this.spaceHome = spaceHome;
	}

	public Space getSpaceStartHere() {
		return spaceStartHere;
	}

	public void setSpaceStartHere(Space spaceStartHere) {
		this.spaceStartHere = spaceStartHere;
	}

	public void setupeCounter(Counter[] counters) {
		for (Counter counter : counters) {
			counter.goTo(spaceStartHere);
			
		}
	}

	public void move(Counter counter, int diceNumber) {

		Space space = counter.getCurrentSpace();
		int newSpaceNumber = space.getNumber() + diceNumber;
		
		Space newSpace;
		
		if(newSpaceNumber >= spaceHome.getNumber()) {
			newSpace = spaceHome;
			winnerCounter = counter;
		} else {
			newSpace = spaces[newSpaceNumber];
		}
		
		counter.goTo(newSpace);
		System.out.format("Jogador '%s' foi para a casa %s\n", counter.getName(), newSpaceNumber);
		
		Transition transition = newSpace.getTransition();
		
		if (transition != null) {
			System.out.format("Jogador '%s' encontrou uma %s na casa %s\n ", counter.getName(), transition.getType(), newSpace);
			counter.goTo(transition.getSpaceTo());
			System.out.format("Jogador '%s' foi para a casa %s\n", counter.getName(), transition.getSpaceTo());
		}
	}
	
	public boolean gameFinished() {
		return winnerCounter != null;
	}
	
	public Counter getWinnerCounter() {
		return winnerCounter;
	}
	
	public void addTransition(int from, int to) {
		
		Space spaceFrom = spaces[from];
		Space spaceTo = spaces[to];
		
		Transition transition = new Transition(spaceFrom, spaceTo);
		spaceFrom.setTransition(transition);
	}
	
}
