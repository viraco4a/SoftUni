import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        Collections.addAll(queue, input);
        int n = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
