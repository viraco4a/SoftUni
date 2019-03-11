import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement {
    private static ArrayDeque<Integer> elements = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split("\\s+");
            switch (commands[0]){
                case "1":
                    elements.push(Integer.parseInt(commands[1]));
                    break;
                case "2":
                    elements.pop();
                    break;
                case "3":
                    printMax();
                    break;
            }
        }
    }

    private static void printMax() {
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        while (!elements.isEmpty()){
            int current = elements.pop();
            if (current > max) {
                max = current;
            }
            tmp.push(current);
        }

        while (!tmp.isEmpty()){
            elements.push(tmp.pop());
        }

        System.out.println(max);
    }
}
