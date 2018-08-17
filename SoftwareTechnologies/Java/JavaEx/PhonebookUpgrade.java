import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            if (input.equals("ListAll")){
                for (String name : phonebook.keySet()) {
                    System.out.printf("%s -> %s\n", name, phonebook.get(name));
                }
                input = scan.nextLine();
                continue;
            }
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
