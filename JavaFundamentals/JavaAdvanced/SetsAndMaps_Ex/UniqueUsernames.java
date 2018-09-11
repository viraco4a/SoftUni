import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> userNames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            userNames.add(input);
        }
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}
