import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phonebook = new HashMap<>();

        String input = reader.readLine();
        while (!"search".equals(input)){
            String[] splitted = input.split("-");
            phonebook.put(splitted[0], splitted[1]);
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!"stop".equals(input)){
            if (phonebook.containsKey(input)){
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = reader.readLine();
        }
    }
}
