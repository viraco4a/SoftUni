import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] first = scanner.next().toCharArray();
        char[] second = scanner.next().toCharArray();
        int len1 = first.length;
        int len2 = second.length;
        int result = 0;
        if (len1 >= len2){
            result = Calculate(first, second, len2, len1 - len2);
        } else {
            result = Calculate(first, second, len1, len2 - len1);
        }
        System.out.println(result);
    }

    private static int Calculate(char[] first, char[] second, int shorter, int diff) {
        int result = 0;
        for (int i = 0; i < shorter; i++) {
            result += (int)first[i] * (int)second[i];
        }
        if (diff > 0){
            if (second.length == shorter){
                for (int i = shorter; i < first.length; i++) {
                    result += first[i];
                }
            } else {
                for (int i = shorter; i < second.length; i++) {
                    result += second[i];
                }
            }
        }
        return result;
    }
}
