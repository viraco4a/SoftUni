import java.util.Arrays;
import java.util.Scanner;

public class SymmetricNumbers {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        for (int i = 1; i <= n; i++){
            if(isSymetrical(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isSymetrical(int number) {
        int start = number;
        int reversed = 0;
        do {
            int num = number % 10;
            reversed *= 10;
            reversed += num;
            number /= 10;
        } while (number >= 1);
        if(start == reversed){
            return true;
        }
        return false;
    }
}
