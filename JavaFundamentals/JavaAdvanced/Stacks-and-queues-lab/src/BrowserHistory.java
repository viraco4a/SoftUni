import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistory {
    private static final String STOP_COMMAND = "Home";
    private static final String GO_BACK_COMMAND = "back";
    private static final String STACK_EMPTY = "no previous URLs";
    private static final int NO_BACK_VALUES = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();

        while (!STOP_COMMAND.equals(input)){
            if (GO_BACK_COMMAND.equals(input)){
                if (browserHistoryStack.size() <= NO_BACK_VALUES){
                    System.out.println(STACK_EMPTY);
                } else {
                    browserHistoryStack.pop();
                    String current = browserHistoryStack.peek();
                    System.out.println(current);
                }
            } else {
                System.out.println(input);
                browserHistoryStack.push(input);
            }
            input = reader.readLine();
        }
    }
}
