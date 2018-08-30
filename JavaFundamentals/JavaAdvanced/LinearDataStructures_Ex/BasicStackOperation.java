import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitted = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(splitted[0]);
        int S = Integer.parseInt(splitted[1]);
        int X = Integer.parseInt(splitted[2]);
        for (int i = 0; i < N; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < S; i++) {
            stack.pop();
        }
        if (stack.contains(X)){
            System.out.println("true");
        } else {
            int min;
            if (stack.isEmpty()){
                min = 0;
            } else {
                min = Integer.MAX_VALUE;
            }
            while (!stack.isEmpty()){
                int local = stack.pop();
                if (local < min) {
                    min = local;
                }
            }
            System.out.println(min);
        }
    }
}
