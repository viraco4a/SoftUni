import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] plants = reader.readLine().split(" ");

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();
        indexesStack.push(0);

        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            int maxDays = 0;

            while (indexesStack.size() > 0 && Integer.valueOf(plants[indexesStack.peek()]) >=
            Integer.valueOf(plants[i])){
                maxDays = Math.max(maxDays, days[indexesStack.pop()]);
            }

            if (indexesStack.size() > 0){
                days[i] = maxDays + 1;
            }
            indexesStack.push(i);
        }
        System.out.println(max(days));
    }

    private static int max(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max){
                max = day;
            }
        }
        return max;
    }
}
