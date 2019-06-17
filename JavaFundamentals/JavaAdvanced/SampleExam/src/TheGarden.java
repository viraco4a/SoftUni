import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGarden {
    private static String[][] matrix;
    private static int carrots;
    private static int potatoes;
    private static int lettuce;
    private static int harmedVegetables;
    private static int rows;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        rows = readMatrix(reader);

        String line;
        while (!"End of Harvest".equals(line = reader.readLine())) {
            String[] splitted = line.split("\\s+");
            String command = splitted[0];
            int row = Integer.parseInt(splitted[1]);
            int col = Integer.parseInt(splitted[2]);
            if (!isValid(row, col)){
                continue;
            }
            if (command.equals("Harvest")) {
                String vegetable = matrix[row][col];
                switch (vegetable){
                    case "C":
                        carrots++;
                        break;
                    case "L":
                        lettuce++;
                        break;
                    case "P":
                        potatoes++;
                        break;
                        default:
                            break;
                }
                matrix[row][col] = " ";
            } else {
                String direction = splitted[3].toLowerCase();
                switch (direction){
                    case "up":
                        for (int i = row; i >= 0; i -= 2) {
                            if (isValid(i, col)) {
                                if (!matrix[i][col].equals(" ")){
                                    harmedVegetables++;
                                    matrix[i][col] = " ";
                                }
                            }
                        }
                        break;
                    case "down":
                        for (int i = row; i < rows; i += 2) {
                            if (isValid(i, col)) {
                                if (!matrix[i][col].equals(" ")){
                                    harmedVegetables++;
                                    matrix[i][col] = " ";
                                }
                            }
                        }
                        break;
                    case "left":
                        for (int i = col; i >= 0; i -= 2) {
                            if (isValid(row, i)) {
                                if (!matrix[row][i].equals(" ")){
                                    harmedVegetables++;
                                    matrix[row][i] = " ";
                                }
                            }
                        }
                        break;
                    case "right":
                        for (int i = col; i < matrix[row].length; i += 2) {
                            if (isValid(row, i)) {
                                if (!matrix[row][i].equals(" ")){
                                    harmedVegetables++;
                                    matrix[row][i] = " ";
                                }
                            }
                        }
                        break;
                }
            }
        }

        printMatrix(rows);

        System.out.printf("Carrots: %s%n", carrots);
        System.out.printf("Potatoes: %s%n", potatoes);
        System.out.printf("Lettuce: %s%n", lettuce);
        System.out.printf("Harmed vegetables: %s%n", harmedVegetables);
    }

    private static boolean isValid(int row, int col) {
        if (row >= 0 && col >= 0 && row < rows) {
            return col < matrix[row].length;
        }
        return false;
    }

    private static int readMatrix(BufferedReader reader) throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        matrix = new String[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().split("\\s+");
        }
        return rows;
    }

    private static void printMatrix(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
