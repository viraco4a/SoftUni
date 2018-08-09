import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<String> vowels = new ArrayList<String>(Arrays.asList("a", "o", "e", "i", "u"));
        try {
            int number = Integer.parseInt(input);
            System.out.println("digit");
        }
        catch (Exception e)
        {
            if(vowels.contains(input)){
                System.out.println("vowel");
            } else {
                System.out.println("other");
            }
        }
    }
}
