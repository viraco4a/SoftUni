import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int position = scanner.nextInt();

        int mask = number >> position;
        int result = 1 & mask;
        System.out.println(result);
    }
}
