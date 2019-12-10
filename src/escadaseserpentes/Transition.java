package escadaseserpentes;

public class Transition {

	public enum Type {
		SNAKE, LADDER
	}
	
	private Space spaceFrom;
	private Space spaceTo;
	private Type type;
	
	public Transition(Space spaceFrom, Space spaceTo) {
		super();
		this.spaceFrom = spaceFrom;
		this.spaceTo = spaceTo;
		this.type = spaceFrom.getNumber() < spaceTo.getNumber() ? Type.LADDER : Type.SNAKE;
	}

	public Space getSpaceFrom() {
		return spaceFrom;
	}

	public void setSpaceFrom(Space spaceFrom) {
		this.spaceFrom = spaceFrom;
	}

	public Space getSpaceTo() {
		return spaceTo;
	}

	public void setSpaceTo(Space spaceTo) {
		this.spaceTo = spaceTo;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
