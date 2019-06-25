import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String ERROR_MESSAGE = "Invalid Operation!";

    private static ListIterator listIterator;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] splitted = line.split("\\s+");
            switch (splitted[0]) {
                case "Create":
                    String[] arr = new String[splitted.length - 1];
                    System.arraycopy(splitted, 1, arr, 0, splitted.length - 1);
                    try {
                        listIterator = new ListIterator(arr);
                    } catch (OperationNotSupportedException e) {
                        System.out.println(ERROR_MESSAGE);
                        return;
                    }
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        listIterator.print();
                    } catch (OperationNotSupportedException e) {
                        System.out.println(ERROR_MESSAGE);
                        return;
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
            }
        }
    }
}
