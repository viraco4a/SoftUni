import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> compounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            compounds.addAll(Arrays.asList(line));
        }
        for (String element : compounds) {
            System.out.print(element + " ");
        }
    }
}
