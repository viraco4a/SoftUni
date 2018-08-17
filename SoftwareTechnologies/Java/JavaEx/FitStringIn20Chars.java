import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if (word.length() > 20){
            System.out.println(word.substring(0, 20));
        }
        else {
            padRight(word, 20, '*');
        }
    }

    private static void padRight(String word, int i, char c) {
        System.out.print(word);
        for (int j = i - word.length(); j > 0; j--) {
             System.out.print(c);
        }
    }
}
