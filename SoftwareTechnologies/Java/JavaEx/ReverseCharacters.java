import java.util.Scanner;

public class ReverseCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);
        char third = scan.nextLine().charAt(0);
        char[] all = new char[3];
        all[0] = third;
        all[1] = second;
        all[2] = first;

        System.out.println(all);
    }
}
