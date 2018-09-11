import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emails = new LinkedHashMap<>();

        String input = reader.readLine();
        for (int i = 0; ; i++) {
            if ("stop".equals(input)) {
                break;
            }
            String name = input;
            String email = reader.readLine();
            String[] splittedEmail = email.split("\\.");
            String domainEnd = splittedEmail[splittedEmail.length - 1];
            if ("us".equals(domainEnd) || "uk".equals(domainEnd)|| "com".equals(domainEnd)){
                input = reader.readLine();
                continue;
            }
            emails.put(name, email);
            input = reader.readLine();
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
