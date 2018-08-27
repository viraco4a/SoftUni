import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        Collections.addAll(stack, tokens);

        while (stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int second = Integer.parseInt(stack.pop());
            if ("+".equals(operand)){
                stack.push(String.valueOf(first + second));
            } else {
                stack.push(String.valueOf(first - second));
            }
        }
        System.out.println(stack.pop());
    }
}
