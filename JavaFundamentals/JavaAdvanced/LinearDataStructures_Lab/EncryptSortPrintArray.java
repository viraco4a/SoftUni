import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int code = 0;
            for (int j = 0; j < name.length(); j++) {
                if (IsVowel(name.charAt(j))){
                    code += (int)name.charAt(j) * name.length();
                } else {
                    code += (int)name.charAt(j) / name.length();
                }
            }
            array[i] = code;
        }
        Arrays.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static boolean IsVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}
