import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (number > 0){
            stack.push(number % 2);
            number /= 2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
