import java.util.Scanner;

public class SumNintegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++){
            int current = Integer.parseInt(scan.nextLine());
            sum += current;
        }
        System.out.println("Sum = " + sum);
    }
}
