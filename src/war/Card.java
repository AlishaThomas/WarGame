package war;

public class Card {
	
	private String name;
	private String value;
	private int rank;
	
	
	public Card(String name, String value, int rank) {
		this.name = name;
		this.value = value;
		this.rank = rank;
	}

	//Describes each card.
	public String describe() {
		return value + " of " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	 
	public void setValue(String value) {
		this.value = value;
	}

	public int getRank() {
		return rank;
	}
	
	
	
	
	
	
}


