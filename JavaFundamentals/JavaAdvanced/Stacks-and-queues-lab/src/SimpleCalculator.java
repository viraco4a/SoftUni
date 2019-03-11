import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        ArrayDeque<String> tockens = new ArrayDeque<>();
        Collections.addAll(tockens, input);

        while (tockens.size() > 1){
            int first = Integer.parseInt(tockens.pop());
            String operator = tockens.pop();
            int second = Integer.parseInt(tockens.pop());

            int result;

            if (operator.equals("+")){
                result = first + second;
            } else {
                result = first - second;
            }

            tockens.push(String.valueOf(result));
        }

        int sum = Integer.parseInt(tockens.pop());
        System.out.println(sum);
    }
}
