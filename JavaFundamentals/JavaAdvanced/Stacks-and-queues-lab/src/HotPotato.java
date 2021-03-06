import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");
        int count = Integer.parseInt(reader.readLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Collections.addAll(childrenQueue, names);

        while (childrenQueue.size() > 1){
            for (int i = 0; i < count - 1; i++) {
                String leftChildren = childrenQueue.poll();
                childrenQueue.offer(leftChildren);
            }
            String removed = childrenQueue.poll();
            System.out.printf("Removed %s%n", removed);
        }

        String winner = childrenQueue.poll();

        System.out.printf("Last is %s", winner);
    }
}
