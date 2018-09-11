import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = reader.readLine().toCharArray();
        Map<Character, Integer> occurances = new TreeMap<>();
        for (char c : arr) {
            if (!occurances.containsKey(c)){
                occurances.put(c, 0);
            }
            occurances.put(c, occurances.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> kvp : occurances.entrySet()) {
            System.out.printf("%c: %d time/s%n", kvp.getKey(), kvp.getValue());
        }
    }
}
