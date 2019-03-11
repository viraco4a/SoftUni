import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    private static ArrayDeque<Integer> elements = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] tockens = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int elementsToAdd = tockens[0];
        int elementsToPoll = tockens[1];
        int elementsToCheck = tockens[2];

        if (elementsToAdd == elementsToPoll){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < elementsToAdd; i++) {
            elements.offer(input[i]);
        }

        for (int i = 0; i < elementsToPoll; i++) {
            elements.poll();
        }

        int min = Integer.MAX_VALUE;

        while (!elements.isEmpty()){
            int current = elements.poll();
            if (current == elementsToCheck) {
                System.out.println("true");
                return;
            }
            if (current < min){
                min = current;
            }
        }

        System.out.println(min);
    }
}
