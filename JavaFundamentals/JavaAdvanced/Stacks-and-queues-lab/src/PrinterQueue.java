import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PrinterQueue {
    private static final String EXIT_COMMAND = "print";
    private static final String CANCEL_COMMAND = "cancel";
    private static final String CANCEL_IMPOSSIBLE = "Printer is on standby";
    private static final String CANCEL_OUTPUT = "Canceled ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String command = reader.readLine();

        while (!EXIT_COMMAND.equals(command)){
            if (command.equals(CANCEL_COMMAND)){
                if (!printerQueue.isEmpty()) {
                    String canceledItem = printerQueue.poll();
                    System.out.println(CANCEL_OUTPUT + canceledItem);
                } else {
                    System.out.println(CANCEL_IMPOSSIBLE);
                }
            } else {
                printerQueue.offer(command);
            }

            command = reader.readLine();
        }

        while (!printerQueue.isEmpty()) {
            String itemToPrint = printerQueue.poll();
            System.out.println(itemToPrint);
        }
    }
}
