import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int elementsToPush = input[0];
        int elementsToPop = input[1];
        int elementToCheck = input[2];

        int[] elements = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        if (elementsToPush == elementsToPop) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(elements[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()){
            int number = stack.pop();
            if (number == elementToCheck){
                System.out.println("true");
                return;
            }
            if (number < min){
                min = number;
            }
        }

        System.out.println(min);
    }
}
