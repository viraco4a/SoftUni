import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");
        int firstNum = scanner.nextInt();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();
        scanner.nextLine();
        String thirdWord = scanner.nextLine();
        double sum = firstNum + secondNum + thirdNum;
        System.out.printf("%s %s %s %.0f", firstWord, secondWord, thirdWord, sum);
    }
}
