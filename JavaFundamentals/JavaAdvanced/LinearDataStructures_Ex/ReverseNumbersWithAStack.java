import java.util.ArrayDeque;
        import java.util.Arrays;
        import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] array = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int el : array) {
            stack.push(el);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
