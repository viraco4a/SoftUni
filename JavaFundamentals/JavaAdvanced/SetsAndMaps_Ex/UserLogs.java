import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    private static Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readUserLogs(reader);
        for (Map.Entry<String, LinkedHashMap<String, Integer>> kvp : userLogs.entrySet()) {
            System.out.printf("%s: %n", kvp.getKey());
            int counter = 0;
            int length = kvp.getValue().size();
            for (Map.Entry<String, Integer> internal : kvp.getValue().entrySet()) {
                if (++counter < length) {
                    System.out.printf("%s => %d, ", internal.getKey(), internal.getValue());
                } else {
                    System.out.printf("%s => %d.%n", internal.getKey(), internal.getValue());
                }
            }
        }

    }

    private static void readUserLogs(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (!"end".equals(input)) {
            String[] splitted = input.split("IP=| message=|user=");
            String ip = splitted[1];
            String user = splitted[3];
            if (!userLogs.containsKey(user)){
                userLogs.put(user, new LinkedHashMap<>());
            }
            if (!userLogs.get(user).containsKey(ip)){
                userLogs.get(user).put(ip, 0);
            }
            userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);
            input = reader.readLine();
        }
    }
}
