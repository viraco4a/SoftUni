package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = getData(reader);
        Threeuple<String, String, String> first = new Threeuple<>(
                firstLine[0] + " " + firstLine[1],
                firstLine[2],
                firstLine[3]);
        System.out.println(first.toString());

        String[] secondLine = getData(reader);

        Threeuple<String, Integer, Boolean> second = new Threeuple<>(
                secondLine[0],
                Integer.parseInt(secondLine[1]),
                secondLine[2].equals("drunk"));
        System.out.println(second.toString());

        String[] thirdLine = getData(reader);

        Threeuple<String, Double, String> third = new Threeuple<>(
                thirdLine[0],
                Double.parseDouble(thirdLine[1]),
                thirdLine[2]);
        System.out.println(third.toString());
    }

    private static String[] getData(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }
}
