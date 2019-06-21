package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    private static CustomStack<Integer> stack = new CustomStack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("(, )|( )", 2);
            String command = tokens[0];
            switch (command) {
                case "Push":
                    String[] elementsToPushStr = tokens[1].trim().split(",\\s+");
                    int[] elementsToPush = Arrays.stream(elementsToPushStr).mapToInt(Integer::parseInt).toArray();
                    for (Integer element : elementsToPush) {
                        stack.push(element);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
