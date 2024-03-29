package escadaseserpentes;

public class Counters implements Printable{

	private Counter[] counters; 
	private int currentIndex = -1; //Jogador da vez
	
	public Counters(Board board, int players) {
		counters = new Counter[players];
		char currentName = 'A';
		
		for (int i = 0; i < counters.length; i++) {
			counters[i] = new Counter(String.valueOf(currentName));
			currentName++;
		}
		
		board.setupeCounter(counters);
	}

	@Override
	public void print() {
		for (Counter counter : counters) {
			System.out.format("Jogador '%s' est� na posi��o %s\n ", counter.getName() ,counter.getCurrentSpace());
		}
	}
	
	public Counter next() {
		// Algoritimo para percorrer um array circular
		currentIndex = (currentIndex + 1) % counters.length;
		return counters[currentIndex];
	}
 	
}
