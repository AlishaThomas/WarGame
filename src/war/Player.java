package war;

import java.util.LinkedList;
import java.util.List;
//comment
public class Player {

	private String name;
	private List<Card> hand = new LinkedList<>();
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}
	//Introduces each player at start of the game. 
	public void introducePlayer1() {
		System.out.println();
		System.out.println("Player 1: " + name);
		System.out.println();
		System.out.println("Deck Contains: ");
		for(Card card: hand) {
			System.out.println(card.describe());
		}
		System.out.println();
	}
	public void introducePlayer2() {
		System.out.println();
		System.out.println("Player 2: " + name);
		System.out.println();
		System.out.println("Deck Contains: ");
		for(Card card: hand) {
			System.out.println(card.describe());
		}
		System.out.println();
	}
	
	//Describes winner
	public String describe() {
		return  name + "; Score: " + score ;
	}
	
	
	//Draws from deck and adds card to player hand. 
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	public int handSize() {
		return hand.size();
	}

	// Removes top card from player hand. 
	public Card flip() {
		return hand.remove(0);
	}

	// Increments score by 1 each time player wins a round. 
	public void incrementScore() {
		score += 1;
	}

	public int getScore() {
		return score;
	}

	
}
