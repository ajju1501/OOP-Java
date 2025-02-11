import java.util.ArrayList;
import java.util.Scanner;

class Card {
    int value;

    public Card(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }

    public int displayCard() {
        return this.value;
    }
}

class Deck {
    ArrayList<Card> cards;
    int currentIndex;

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
        this.currentIndex = 0;
    }

    public void intializeDeck(){
        cards.add(new Card(7));
            for (int j=1;j<14;j++){
                Card c = new Card(j);
                cards.add(c);
            }
    }

    public Card drawCard() {
        if (currentIndex < cards.size()) {
            Card c = cards.get(currentIndex);
            currentIndex++;
            return c;
        }
        return null;
    }

    public void resetDeck() {
        this.currentIndex = 0;
    }
}

class Hand {
    ArrayList<Card> cardsInHand;
    int totalValue;

    public Hand(ArrayList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
        this.totalValue = 0;
    }

    public void addCard(Card card) {
        this.cardsInHand.add(card);
        this.totalValue += card.getValue();
    }

    public void calculateScore() {
        totalValue = 0;
        int aceCount = 0;
        for (Card card : cardsInHand) {
            if (card.getValue() == 1) {
                aceCount++;
                totalValue += 11;
            } else {
                totalValue += card.getValue();
            }
        }
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10;
            aceCount--;
        }

    }
    public int getTotalValue() {
        calculateScore();
        return this.totalValue;
    }

    public void displayHand() {
        String res = "";
        for (Card c : cardsInHand) {
            res += c.displayCard() + " ";
        }
        System.out.println(res);
    }

    public boolean isBlackjack() {
        return (this.getTotalValue() == 21) && (cardsInHand.size() == 2);
    }

    public boolean hasBusted() {
        return this.getTotalValue() > 21;
    }
}

class Player {
    Hand hand;
    boolean standing;

    public Player(Hand hand) {
        this.hand = hand;
        this.standing = false;
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    public void stand() {
        this.standing = true;

    }

    public int getScore() {
        return hand.getTotalValue();
    }

    public boolean hasBlackjack() {
        return hand.isBlackjack();
    }

    public boolean hasBusted() {
        return hand.hasBusted();
    }

    public void displayHand() {
        hand.displayHand();
    }
}

class Dealer {
    Hand hand;

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    public void hit(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    public void playTurn(Scanner scanner, Deck deck) {

        String nextLine = scanner.nextLine();
        if (nextLine.equals("h")) {
            this.hit(deck);
            System.out.print("Dealer chooses to hit. (h/s): ");
            displayHand();
            System.out.println("Dealer's total score: " + this.getScore());
            return;
        }

        return;

    }

    public int getScore() {
        return hand.getTotalValue();
    }

    public void displayHand() {
        hand.displayHand();
    }

    public boolean hasBusted() {
        return hand.hasBusted();
    }

    public boolean hasBlackjack() {
        return hand.isBlackjack();
    }
}

class Game {
    Deck deck;
    Player player;
    Dealer dealer;

    public Game() {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(7));
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                continue;
            }
            cards.add(new Card(i));
        }
        this.deck = new Deck(cards);
        this.player = new Player(new Hand(new ArrayList<Card>()));
        this.dealer = new Dealer(new Hand(new ArrayList<Card>()));
    }


    public void startGame() {
        System.out.println("Game starts:");
        System.out.println("Player's turn:");
        player.hit(deck);
        player.hit(deck);
        dealer.hit(deck);
        dealer.hit(deck);
        player.displayHand();
        System.out.println("Your total score: " + player.getScore());

    }


    public void playerTurn(Scanner scanner) {

        if (!player.standing) {

            String nextLine = scanner.nextLine();
            if (nextLine.equals("s")) {
                player.stand();
                System.out.println("Do you want to hit or stand? (h/s): Dealer's turn:");
                dealer.displayHand();
                System.out.println("Dealer's total score: " + dealer.getScore());
                return;
            }

            player.hit(deck);
            if (player.getScore() > 21) {
                return;
            }
            System.out.println("Do you want to hit or stand? (h/s): Player's turn:");
            player.displayHand();
            System.out.println("Your total score: " + player.getScore());
            return;

        }

    }
    public void dealerTurn(Scanner scanner) {

        dealer.playTurn(scanner, deck);
    }

    public void determineWinner() {

        if (player.hasBusted()) {

            System.out.println("Do you want to hit or stand? (h/s): Player busts!");
            System.out.println("Player's hand: ");
            player.displayHand();
            System.out.println("Player has busted!");
            return;

        }
        if (dealer.hasBusted()) {
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.println("Dealer has busted!");
            return;

        }
        if (player.getScore() > dealer.getScore()) {
            System.out.println("Dealer chooses to hit. (h/s): Dealer's final hand: ");
            dealer.displayHand();
            System.out.println("Dealer's total score: " + dealer.getScore());
            System.out.println();
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.print("Player wins!");
            return;
        }
        if (player.getScore() < dealer.getScore()) {
            System.out.println();
            System.out.println("Final results:");
            player.displayHand();
            dealer.displayHand();
            System.out.print("Dealer wins!");
            return;
        }

    }

    public void playGame(Scanner scanner) {
        startGame();

        while (scanner.hasNextLine()) {
            playerTurn(scanner);
            if (player.standing) {

                dealerTurn(scanner);
            }
            if (player.hasBusted()) {
                determineWinner();
                return;

            }

        }
        determineWinner();
    }
}

public class Solution {
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame(new Scanner(System.in));
    }
}