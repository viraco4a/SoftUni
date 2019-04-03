import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Voina {
    private static Set<Integer> firstDeck = new LinkedHashSet<>();
    private static Set<Integer> secondDeck = new LinkedHashSet<>();
    private static boolean firstWin = false;
    private static boolean secondWin = false;

    public static void main(String[] args) throws IOException {
        ReadData();

        for (int i = 0; i < 50; i++) {
            if (firstDeck.size() == 0) {
                secondWin = true;
                break;
            }
            if (secondDeck.size() == 0) {
                firstWin = true;
                break;
            }

            int first = firstDeck.iterator().next();
            int second = secondDeck.iterator().next();
            firstDeck.remove(first);
            secondDeck.remove(second);

            if (first > second) {
                firstDeck.add(first);
                firstDeck.add(second);
            } else if (second > first) {
                secondDeck.add(first);
                secondDeck.add(second);
            }
        }
        if (!firstWin && !secondWin) {
            if (firstDeck.size() > secondDeck.size()) {
                firstWin = true;
            } else if (secondDeck.size() > firstDeck.size()) {
                secondWin = true;
            }
        }
        PrintResult();
    }

    private static void PrintResult() {
        if (!firstWin && !secondWin) {
            System.out.println("Draw!");
        } else if (firstWin) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }

    private static void ReadData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split("\\s+");
        String[] second = reader.readLine().split("\\s+");
        for (String num : first) {
            firstDeck.add(Integer.parseInt(num));
        }
        for (String num : second) {
            secondDeck.add(Integer.parseInt(num));
        }
    }
}
