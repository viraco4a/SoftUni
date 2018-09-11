import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lengths = reader.readLine().split(" ");
        int n = Integer.parseInt(lengths[0]);
        int m = Integer.parseInt(lengths[1]);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        StringBuilder total = new StringBuilder();

        for (int i = 0; i < n; i++) {
            first.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < m; i++) {
            second.add(Integer.parseInt(reader.readLine()));
        }
        for (Integer element : first) {
            if (second.contains(element)){
                total.append(element);
                total.append(" ");
            }
        }
        System.out.println(total);
    }
}
