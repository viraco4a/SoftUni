import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("[ .,;:!()\"'\\\\/\\[\\]]+");
        List<String> upper = new ArrayList<>();
        List<String> lower = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        for (String word : words) {
            boolean isMixed = false;
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))){
                    isMixed = true;
                    break;
                }
            }
            if (word.toUpperCase().equals(word) && !isMixed && !word.isEmpty()){
                upper.add(word);
            } else if (word.toLowerCase().equals(word) && !isMixed && !word.isEmpty()){
                lower.add(word);
            } else if (!word.isEmpty()){
                mixed.add(word);
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lower));
        System.out.println("Mixed-case: " + String.join(", ", mixed));
        System.out.println("Upper-case: " + String.join(", ", upper));
    }
}
