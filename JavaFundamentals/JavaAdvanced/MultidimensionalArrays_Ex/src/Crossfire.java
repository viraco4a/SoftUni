import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire {
    private  static List<List<Integer>> matrix = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] diemnsions = readLine(reader);

        int rows = diemnsions[0];
        int cols = diemnsions[1];

        getMatrix(rows, cols);

        String input = reader.readLine();

        while (!"Nuke it from orbit".equals(input)) {
            int[] coordinates = readLine(input);

            int row = coordinates[0];
            int col = coordinates[1];
            int radius = coordinates[2];

            attack(row, col, radius);

            input = reader.readLine();
        }

        Print();
    }

    private static void attack(int targetRow, int targetCol, int radius) {
        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (isInside(row, targetCol)) {
                matrix.get(row).set(targetCol, 0);
            }
        }

        for (int col = targetCol - radius; col <= targetCol + radius; col++) {
            if (isInside(targetRow, col)) {
                matrix.get(targetRow).set(col, 0);
            }
        }

        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeIf(s -> s == 0);

            if (matrix.get(row).size() == 0) {
                matrix.remove(row--);
            }
        }
    }

    private static boolean isInside(int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static int[] readLine(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void Print() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> row : matrix) {
            for (Integer integer : row) {
                sb.append(integer).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static void getMatrix(int rows, int cols) {
        int counter = 1;

        for (int i = 0; i < rows; i++) {
            List<Integer> currentNumbers = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                currentNumbers.add(counter++);
            }
            matrix.add(currentNumbers);
        }
    }
}
