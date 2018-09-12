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
            int power = calculateValue(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), power);
        }
    }

    private static int calculateValue(HashSet<String> deck) {
        int power = 0; //possibly long?
        for (String card : deck) {
            int powerPower = getPowerPower(card);
            int typePower = getTypePower(card);
            power += powerPower * typePower;
        }
        return power;
    }

    private static int getPowerPower(String card) {
        if (card.length() == 2){
            char power = card.charAt(0);
            int powerPower = 0;
            switch (power){
                case 'J':
                    powerPower = 11;
                    break;
                case 'Q':
                    powerPower = 12;
                    break;
                case 'K':
                    powerPower = 13;
                    break;
                case 'A':
                    powerPower = 14;
                    break;
                default:
                    powerPower = Integer.parseInt(Character.toString(power));
                    break;
            }
            return powerPower;
        } else {
            return 10;
        }

    }

    private static int getTypePower(String card) {
        char type = card.charAt(card.length() - 1);
        int typePower = 0;
        switch (type){
            case 'S':
                typePower = 4;
                break;
            case 'H':
                typePower = 3;
                break;
            case 'D':
                typePower = 2;
                break;
            case 'C':
                typePower = 1;
                break;
        }
        return typePower;
    }

    private static void dealCards(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (!"JOKER".equals(input)) {
            String[] splitted = input.split(": ");
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
