import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();

        int N = Integer.parseInt(reader.readLine());
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] splitted = reader.readLine().split(" ");
            int type = Integer.parseInt(splitted[0]);
            switch (type){
                case 1:
                    int num = Integer.parseInt(splitted[1]);
                    stack.push(num);
                    if (num > max){
                        max = num;
                        maxStack.push(num);
                    }
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped == max){
                        maxStack.pop();
                        if (maxStack.isEmpty()){
                            max = Integer.MIN_VALUE;
                        } else {
                            max = maxStack.peek();
                        }
                    }
                    break;
                case 3:
                    sb.append(max).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb);
    }
}
