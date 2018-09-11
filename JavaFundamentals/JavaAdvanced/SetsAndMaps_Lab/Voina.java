import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Voina {
    private static Set<Integer> firstHand = new LinkedHashSet<>();
    private static Set<Integer> secondHand = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        ReadCards();
        for (int i = 0; i < 50; i++) {
            if (firstHand.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if (secondHand.isEmpty()){
                System.out.println("First player win!");
                return;
            }
            int first = firstHand.iterator().next();
            int second = secondHand.iterator().next();
            firstHand.remove(first);
            secondHand.remove(second);
            if (first > second){
                firstHand.add(first);
                firstHand.add(second);
            } else if (second > first) {
                secondHand.add(first);
                secondHand.add(second);
            }
        }
        if (firstHand.size() > secondHand.size()){
            System.out.println("First player win!");
        } else if (secondHand.size() > firstHand.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void ReadCards() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split(" ");
        String[] second = reader.readLine().split(" ");
        for (String card : first) {
            firstHand.add(Integer.parseInt(card));
        }
        for (String card : second) {
            secondHand.add(Integer.parseInt(card));
        }
    }
}
