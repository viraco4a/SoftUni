package ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static ListyIterator<String> listyIterator;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+", 2);
            String command = tokens[0];
            switch (command) {
                case "Create":
                    if (tokens.length > 1) {
                        listyIterator = new ListyIterator<>(tokens[1].split("\\s+"));
                    } else {
                        listyIterator = new ListyIterator<String>();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.print());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    System.out.println(listyIterator.printAll());
                    break;
            }
        }
    }
}
