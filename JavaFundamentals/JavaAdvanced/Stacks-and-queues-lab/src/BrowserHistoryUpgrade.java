import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistoryUpgrade {
    private static final String STOP_COMMAND = "Home";
    private static final String GO_BACK_COMMAND = "back";
    private static final String GO_FORWARD_COMMAND = "forward";
    private static final String STACK_EMPTY = "no previous URLs";
    private static final String QUEUE_EMPTY = "no next URLs";
    private static final int NO_BACK_VALUES = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        String current = "";

        while (!STOP_COMMAND.equals(input)){
            if (GO_BACK_COMMAND.equals(input)){
                if (browserHistoryStack.size() < NO_BACK_VALUES){
                    System.out.println(STACK_EMPTY);
                    input = reader.readLine();
                    continue;
                } else {
                    forwardQueue.push(current);
                    current = browserHistoryStack.pop();
                }
            } else if (GO_FORWARD_COMMAND.equals(input)) {
                if (forwardQueue.isEmpty()){
                    System.out.println(QUEUE_EMPTY);
                    input = reader.readLine();
                    continue;
                } else {
                    browserHistoryStack.push(current);
                    current = forwardQueue.pop();
                }
            } else {
                if (!current.equals("")){
                    browserHistoryStack.push(current);
                    if (!forwardQueue.isEmpty()){
                        forwardQueue.clear();
                    }
                }
                current = input;
            }
            System.out.println(current);
            input = reader.readLine();
        }
    }
}
