package CardsWithPower;

public class Card {
    private CardSuit suit;
    private CardRank rank;
    private int power;

    Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
        this.power = this.calculatePower();
    }

    private int calculatePower() {
        return this.suit.getSuitValue() + this.rank.getRank();
    }

    public int getPower() {
        return this.power;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public CardRank getRank() {
        return this.rank;
    }
}
