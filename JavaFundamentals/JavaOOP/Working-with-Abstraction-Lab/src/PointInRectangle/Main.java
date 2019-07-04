package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = getInts(reader);

        Point bottomLeft = new Point(input[0], input[1]);
        Point topRight = new Point(input[2], input[3]);
        Rectangle rectangle = new Rectangle();
        rectangle.setBottomLeft(bottomLeft);
        rectangle.setTopRight(topRight);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int[] tockens = getInts(reader);
            Point point = new Point(tockens[0], tockens[1]);
            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getInts(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
