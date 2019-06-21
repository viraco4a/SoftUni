package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = getData(reader);
        Tuple<String, String> name = new Tuple<>(firstLine[0], firstLine[1]);
        String address = firstLine[2];
        Tuple<Tuple<String, String>, String> first = new Tuple<>(name, address);

        StringBuilder sb = new StringBuilder();
        sb.append(first.getItem1().getItem1())
                .append(" ")
                .append(first.getItem1().getItem2())
                .append(" -> ")
                .append(first.getItem2())
                .append(System.lineSeparator());
        System.out.println(sb.toString().trim());

        String[] secondLine = getData(reader);
        String secondName = secondLine[0];
        int beers = Integer.parseInt(secondLine[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(secondName, beers);
        System.out.println(secondTuple.getItem1() + " -> " + secondTuple.getItem2());
        String[] thirdLine = getData(reader);
        int number = Integer.parseInt(thirdLine[0]);
        double floatNum = Double.parseDouble(thirdLine[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, floatNum);
        System.out.println(thirdTuple.getItem1() + " -> " + thirdTuple.getItem2());
    }

    private static String[] getData(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }
}
