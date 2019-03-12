import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParenthesis {
    private static ArrayDeque<Character> stack = new ArrayDeque<>();
    private static char[] parentheses;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        parentheses = reader.readLine().toCharArray();
        if (algoBalancedParenteses()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean algoBalancedParenteses(){
        for (char symbol : parentheses) {
            if (isOpen(symbol)) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!checkMatch(stack.pop(), symbol)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean checkMatch(Character pop, char symbol) {
        return (pop == '{' && symbol == '}')
                || (pop == '[' && symbol == ']')
                || (pop == '(' && symbol == ')');
    }

    private static boolean isOpen(char c) {
        return c == '{' || c == '[' || c == '(';
    }
}
