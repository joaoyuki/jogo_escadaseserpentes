package escadaseserpentes;

public class Space {

	private int number;
	
	private Type type;

	public Space(int number, Type type) {
		this.number = number;
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if (type == Type.REGUALR) {
			return String.valueOf(number);
		} else {
			return number + "(" + type + ")";
		}
	}
	
}
