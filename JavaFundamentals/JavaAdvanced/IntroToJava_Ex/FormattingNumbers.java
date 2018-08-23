import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String hex = Integer.toHexString(a).toUpperCase();
        String bin = Integer.toBinaryString(a);
        String third = String.format("%.2f", b);
        String fourth = String.format("%.3f", c);

        String firstSpace = CreateSpaces(10 - hex.length());
        String secondZeroes = CreateZeroes (10 - bin.length());
        String thirdSpace = CreateSpaces(10 - third.length());
        String fourthSpace = CreateSpaces(10 - fourth.length());
        System.out.printf("|%s%s|%s%s|%s%s|%s%s|",
                hex, firstSpace,
                secondZeroes, bin,
                thirdSpace, third,
                fourth, fourthSpace);
    }

    private static String CreateZeroes(int count) {
        return new String(new char[count]).replace('\0', '0');

    }

    private static String CreateSpaces(int count) {
        return new String(new char[count]).replace('\0', ' ');
    }
}
