package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CardRank rank = CardRank.valueOf(reader.readLine().toUpperCase());
        CardSuit suit = CardSuit.valueOf(reader.readLine().toUpperCase());

        Card card = new Card(suit, rank);

        System.out.printf("Card name: %s of %s; Card power: %d",
                card.getRank(),
                card.getSuit(),
                card.getPower());
    }
}
