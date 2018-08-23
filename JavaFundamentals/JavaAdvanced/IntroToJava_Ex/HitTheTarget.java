import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <=20 ; j++) {
                if (i + j == target){
                    Print(i, j, target, '+');
                }
            }
            for (int j = 1; j <=20 ; j++) {
                if (i - j == target){
                    Print(i, j, target, '-');
                }
            }
        }
    }

    private static void Print(int a, int b, int target, char sign) {
        if (sign == '+') {
            System.out.printf("%d + %d = %d%n", a, b, target);
        } else {
            System.out.printf("%d - %d = %d%n", a, b, target);
        }
    }
}
