package war;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {

		List<String> players = List.of("Al","Bob","Charlie","Doug","Ellen","Frank","Greg","Hilary");
	
	Random random = new Random();
	
	public static void main(String[] args) {
		new App().playWar();
		
	}
	
	//Chooses 2 players and processes the game. 
	private void playWar() {
		List<String> playerNames = new LinkedList<>(players);
		Player player1 = findPlayer(playerNames);
		Player player2 = findPlayer(playerNames);
		Deck deck = new Deck();

		shuffleGame(deck);
		dealGame(player1, player2, deck);
		describePlayers(player1, player2);
		processGame(player1, player2);
		determineWinner(player1, player2);
	}
	

	private void describePlayers(Player player1, Player player2) {
		player1.introducePlayer1();
		player2.introducePlayer2();
	}
	
	private void determineWinner(Player player1, Player player2) {
		Player winner = null;
		Player loser = null;
		
		if (player1.getScore() > player2.getScore()) {
			winner = player1;
			loser = player2;
			System.out.println("The winner is: " + player1.describe());
			
		}else if(player2.getScore() > player1.getScore()) {
			winner = player2;
			loser = player1;	
			System.out.println( "The winner is: " + player2.describe());
		}
		
		if (winner == null) {
			System.out.println("Draw");
		}
	}

	//Iterates through the deck 26 times for each player
	private void processGame(Player player1, Player player2) {
		int deckSize = player1.handSize() + player2.handSize();
		
		for(int i = 0; i <deckSize / 2; i++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			String winner = null;
			
			if(card1.getRank() > card2.getRank()) {
				player1.incrementScore();
				System.out.println(player1.getName() + " beats " 
					+ player2.getName() + " with a " + card1.describe() 
					+ " compared to a " + card2.describe());
				
			}else if (card2.getRank() > card1.getRank()) {
				player2.incrementScore();
				System.out.println(player2.getName() + " beats " 
						+ player1.getName() + " with a " + card2.describe() 
						+ " compared to a " + card1.describe());
			}else {
				System.out.println("It's a tie.");
			}
		}
		System.out.println();
	}	
	//Each player draws a card from the deck. 
	private void dealGame(Player player1, Player player2, Deck deck) {
		int deckSize = deck.size();
		
		for (int i = 0; i < deckSize; i++) {
			if(i % 2 == 0) {
				player1.draw(deck);
			}else {
				player2.draw(deck);
			}
		}
	}

	private void shuffleGame(Deck deck) {
		deck.shuffle();
	}

	private Player findPlayer(List<String> players) {
		
		int pos = random.nextInt(players.size());
		String name = players.remove(pos);
		return new Player(name);
	}
	
	
	
	
	
}
