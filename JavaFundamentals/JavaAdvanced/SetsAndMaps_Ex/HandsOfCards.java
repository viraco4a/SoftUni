import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    private static Map<String, HashSet<String>> players = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        dealCards(reader);
        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {
            int value = calculateValue(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), value);
        }
    }

    private static int calculateValue(HashSet<String> deck) {
        for (String card : deck) {
            //TODO
        }
    }

    private static void dealCards(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while ("JOKER".equals(input)) {
            String[] splitted = input.split(":");
            String name = splitted[0];
            String[] currentCards = splitted[1].split(", ");
            HashSet<String> local = convertArrayToSet(currentCards);
            if (!players.containsKey(name)){
                players.put(name, new HashSet<>());
            }
            addCardsToPlayer(name, local);
            input = reader.readLine();
        }
    }

    private static void addCardsToPlayer(String name, HashSet<String> local) {
        HashSet<String> totalCards = players.get(name);
        totalCards.addAll(local);
        players.put(name, totalCards);
    }

    private static HashSet<String> convertArrayToSet(String[] currentCards) {
        HashSet<String> result = new HashSet<>();
        Collections.addAll(result, currentCards);
        return result;
    }
}
