import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] input = reader.readLine().split(" ");
        int S = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);
        String[] arr = reader.readLine().split(" ");
        for (String s : arr) {
            queue.offer(Integer.parseInt(s));
        }
        for (int i = 0; i < S; i++) {
            queue.pop();
        }
        if (queue.contains(X)){
            System.out.println("true");
        } else if (!queue.isEmpty()){
            System.out.println(Collections.min(queue));
        } else {
            System.out.println("0");
        }

    }
}
