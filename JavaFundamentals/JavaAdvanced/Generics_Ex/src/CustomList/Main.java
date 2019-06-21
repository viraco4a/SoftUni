package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> myCustomList = new CustomList<String>();
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] command = line.split("\\s+");

            switch (command[0]) {
                case "Add":
                    myCustomList.add(command[1]);
                    break;
                case "Remove":
                    myCustomList.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(myCustomList.contains(command[1]) ? "true" : "false");
                    break;
                case "Swap":
                    myCustomList.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(myCustomList.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(myCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(myCustomList.getMin());
                    break;
                case "Print":
                    myCustomList.getData().forEach(System.out::println);
                    break;
            }
        }
    }
}
