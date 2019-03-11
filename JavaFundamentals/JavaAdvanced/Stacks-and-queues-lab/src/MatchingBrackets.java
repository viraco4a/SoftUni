import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        ArrayDeque<Integer> expressionsStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                expressionsStack.push(i);
            } else if (input.charAt(i) == ')'){
                int startIndex = expressionsStack.pop();
                String expression = input.substring(startIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
