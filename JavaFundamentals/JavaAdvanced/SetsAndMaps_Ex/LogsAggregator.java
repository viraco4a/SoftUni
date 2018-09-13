import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    private static Map<String, Integer> userTimes = new TreeMap<>();
    private static Map<String, TreeSet<String>> users = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readUsers(reader);
        for (Map.Entry<String, Integer> entry : userTimes.entrySet()) {
            System.out.printf("%s: %d [%s]%n", entry.getKey(), entry.getValue(),
                    String.join(", ", users.get(entry.getKey())));
        }
    }

    private static void readUsers(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] splitted = reader.readLine().split(" ");
            String ip = splitted[0];
            String user = splitted[1];
            int time = Integer.parseInt(splitted[2]);
            if (!userTimes.containsKey(user)){
                userTimes.put(user, 0);
                users.put(user, new TreeSet<>());
            }
            userTimes.put(user, userTimes.get(user) + time);
            TreeSet<String> local = users.get(user);
            local.add(ip);
            users.put(user, local);
        }
    }
}
