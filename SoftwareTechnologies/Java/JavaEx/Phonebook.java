import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] splitted = input.split("\\s");
            if (splitted[0].equals("A")){
                phonebook.put(splitted[1], splitted[2]);
            } else {
                if (!phonebook.containsKey(splitted[1])){
                    System.out.printf("Contact %s does not exist.\n", splitted[1]);
                } else {
                    System.out.printf("%s -> %s\n", splitted[1], phonebook.get(splitted[1]));
                }
            }

            input = scan.nextLine();
        }
    }
}
