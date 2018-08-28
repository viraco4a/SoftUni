import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        Collections.addAll(queue, input);
        int n = Integer.parseInt(scanner.nextLine());
        int index = 1;

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(index)){
                System.out.printf("Prime %s%n", queue.peek());
            } else {
                System.out.printf("Removed %s%n", queue.poll());
            }
            index++;
        }
        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(Integer number){
        if (number == 1){
            return false;
        }
        if (number == 2 || number == 3){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
