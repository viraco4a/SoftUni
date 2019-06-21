package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(numbers);

        String redundant = reader.readLine();

        StringBuilder sb = new StringBuilder();

        for (Integer item : lake) {
            sb.append(item).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }
}
