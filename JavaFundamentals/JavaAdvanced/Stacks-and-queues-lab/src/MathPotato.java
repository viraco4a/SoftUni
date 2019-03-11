import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");
        int count = Integer.parseInt(reader.readLine());

        int cycle = 1;

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Collections.addAll(childrenQueue, names);

        while (childrenQueue.size() > 1){
            for (int i = 0; i < count - 1; i++) {
                String leftChildren = childrenQueue.poll();
                childrenQueue.offer(leftChildren);
            }
            if (isPrime(cycle)){
                String child = childrenQueue.peek();
                System.out.printf("Prime %s%n", child);
            } else {
                String child = childrenQueue.poll();
                System.out.printf("Removed %s%n", child);
            }
            cycle++;
        }

        String winner = childrenQueue.poll();

        System.out.printf("Last is %s", winner);
    }

    private static boolean isPrime(int number){
        if (number == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
