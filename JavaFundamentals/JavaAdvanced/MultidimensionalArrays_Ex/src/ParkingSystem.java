import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, List<Integer>> parkingSpots = new HashMap<>();

        String[] dimensions = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        for (int row = 0; row < rows; row++) {
            parkingSpots.put(row, new ArrayList<>(Arrays.asList(0)));
        }

        String input = reader.readLine();

        while (!"stop".equals(input)) {
            int[] coodinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int entryRow = coodinates[0];
            int targetRow = coodinates[1];
            int targetCol = coodinates[2];

            if (!parkingSpots.get(targetRow).contains(targetCol)) {
                parkingSpots.get(targetRow).add(targetCol);
                int steps = Math.abs(entryRow - targetRow) + targetCol + 1;
                System.out.println(steps);
            } else if (parkingSpots.get(targetRow).size() == cols) {
                System.out.printf("Row %d full%n", targetRow);
            } else {
                int counter = 1;

                while (true) {
                    int steps = targetCol - counter;

                    if (!parkingSpots.get(targetRow).contains(steps) && steps > 0) {
                        print(parkingSpots, entryRow, targetRow, steps);
                        break;
                    }

                    steps = targetCol + counter;

                    if (!parkingSpots.get(targetRow).contains(steps) && steps < cols) {
                        print(parkingSpots, entryRow, targetRow, steps);
                        break;
                    }

                    counter++;
                }
            }
            input = reader.readLine();
        }
    }

    private static void print(Map<Integer, List<Integer>> parkingSpots, int entryRow, int targetRow, int steps) {
        parkingSpots.get(targetRow).add(steps);
        int totalSteps = Math.abs(entryRow - targetRow) + steps + 1;
        System.out.println(totalSteps);
    }
}
