import java.util.Scanner;

public class IntegerToHEXandBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String hex = Integer.toHexString(number).toUpperCase();
        String bin = Integer.toBinaryString(number);
        System.out.println(hex);
        System.out.println(bin);
    }
}
