package CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toUpperCase();

        System.out.println("Card Suits:");

        for (CardSuit suit : CardSuit.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    suit.getSuitValue(),
                    suit));
        }
    }
}
