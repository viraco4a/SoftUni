import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountSameValuesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(" ");
        Map<String, Integer> numbers = new HashMap<>();

        for (String key : arr) {
            if (!numbers.containsKey(key)){
                numbers.put(key, 0);
            }
            numbers.put(key, numbers.get(key) + 1);
        }

        for (String key : numbers.keySet()) {
            System.out.printf("%s - %d times%n", key, numbers.get(key));
        }
    }
}
