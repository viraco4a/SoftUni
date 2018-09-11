import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> resources = new LinkedHashMap<>();
        for (int i = 0; ; i+=2) {
            String resource = reader.readLine();
            if ("stop".equals(resource)){
                break;
            }
            int amount = Integer.parseInt(reader.readLine());
            if (!resources.containsKey(resource)){
                resources.put(resource, 0L);
            }
            resources.put(resource, resources.get(resource) + amount);
        }
        for (String res : resources.keySet()) {
            System.out.printf("%s -> %d%n", res, resources.get(res));
        }
    }
}
