import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class InfixToPostfixx {
    private static HashSet<String> operators = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] infix = reader.readLine().split("\\s");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        setOperators();

        //( 1 + 2 ) + ( 2 * 6 ) / ( 7 - 2 ) * ( x * ( 2 - 5 ) + ( 6 - 2 ) )
        //1 2 + 2 6 * 7 2 - / x 2 5 - * 6 2 - + * +
        for (String token : infix) {
            if(isNumeric(token)){
                outputQueue.offer(token);
                continue;
            }
            if (isOperator(token)){
                if (operatorStack.isEmpty()){
                    operatorStack.offer(token);
                    continue;
                }
                int precedence = getPrecedence(token);
                if ("(".equals(operatorStack.peekFirst())){
                    operatorStack.push(token);
                    continue;
                }
                int topOperatorStack = getPrecedence(operatorStack.peekFirst());
                if (precedence < topOperatorStack){
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.isEmpty() && !"(".equals(operatorStack.peekFirst())){
                        outputQueue.offer(operatorStack.pop());
                    }
                    operatorStack.push(token);
                }
                continue;
            }
            if (token.equals("(")){
                operatorStack.push(token);
                continue;
            }
            if (token.equals(")")){
                while (!"(".equals(operatorStack.peekFirst())){
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
                continue;
            }

            outputQueue.offer(token);
        }

        while (!outputQueue.isEmpty()){
            System.out.print(outputQueue.pop() + " ");
        }
        while (!operatorStack.isEmpty()){
            System.out.print(operatorStack.pop() + " ");
        }
    }

    private static int getPrecedence(String symbol) {
        return symbol.equals("*") || symbol.equals("/") ? 1 : 2;
    }

    private static boolean isOperator(String symbol) {
        return operators.contains(symbol);
    }

    private static void setOperators() {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    private static boolean isNumeric(String symbol) {
        try{
            int number = Integer.parseInt(symbol);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
