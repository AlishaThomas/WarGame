package war;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<String> name = List.of("Diamonds","Hearts","Clubs","Spades");
	private List<String> value = List.of("Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King");
	
	private List<Card> cards;
	
	public Deck() {
		createDeck();		
	}

	private void createDeck() {
		
		cards = new LinkedList<>();
		
		//Iterates through both Lists to create deck.
		for (int suitPos = 0; suitPos < name.size(); suitPos++) {
			int rank = suitPos + 1;
			String suit = name.get(suitPos);
			
			for(String num : value) {
			Card card = new Card(suit, num, rank);
			cards.add(card);
			}
		}	
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Deck: \n");
		
		for (Card card: cards) {
			builder.append(" ").append(card).append("\n");
		}
		return builder.toString();
	}

	public void shuffle() {
		Random random = new Random();
		
		List<Card> temp = new LinkedList<>(cards);
		cards.clear();
		
		while(!temp.isEmpty()) {
			int pos = random.nextInt(temp.size());
			cards.add(temp.remove(pos));
		}
	}
	
	public int size() {
		return cards.size();
	}

	public Card draw() {
		return cards.remove(0);
	}
	

		
		
	}
	
	
	
	
	
	
	


