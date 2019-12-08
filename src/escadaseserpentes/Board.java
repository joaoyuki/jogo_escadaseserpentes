package escadaseserpentes;

import java.util.Arrays;

public class Board implements Printable{
	
	private static final int POSICAO_INICIAL = 0;
	private Space[] spaces;
	private Space spaceHome;
	private Space spaceStartHere;
	
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
		
		if(newSpaceNumber > spaceHome.getNumber()) {
			newSpace = spaceHome;
		} else {
			newSpace = spaces[newSpaceNumber];
		}
		
		counter.goTo(newSpace);
		System.out.format("Jogador '%s' foi para a casa %s\n", counter.getName(), newSpaceNumber);
	}
	
	
	
}
