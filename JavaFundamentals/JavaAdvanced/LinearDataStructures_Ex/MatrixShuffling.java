import java.util.Scanner;

public class MatrixShuffling {
    private static String[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readMatrix(scanner);
        String command = scanner.nextLine();
        while (!"END".equals(command)){
            if (!isValid(command)){
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            String[] splitted = command.split("\\s");
            swap(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]),
                    Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
            print();
            command = scanner.nextLine();
        }
    }

    private static void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int row1, int col1, int row2, int col2){
        String tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }

    private static boolean isValid(String command) {
        String[] splitted = command.split("\\s");
        if (splitted.length != 5){
            return false;
        }
        if (!"swap".equals(splitted[0])){
            return false;
        }
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        try {
            row1 = Integer.parseInt(splitted[1]);
            col1 = Integer.parseInt(splitted[2]);
            row2 = Integer.parseInt(splitted[3]);
            col2 = Integer.parseInt(splitted[4]);
        } catch (Exception e){
            return false;
        }
        return isInMatrix(row1, col1) && isInMatrix(row2, col2);
    }

    private static boolean isInMatrix(int row, int col) {
        return row >= 0 && col >= 0 &&
                row < matrix.length && col < matrix[0].length;
    }

    private static void readMatrix(Scanner scanner) {
        String[] sizes = scanner.nextLine().split("\\s");
        int r = Integer.parseInt(sizes[0]);
        int c = Integer.parseInt(sizes[1]);
        matrix = new String[r][c];
        for (int row = 0; row < r; row++) {
            String[] input = scanner.nextLine().split("\\s");
            for (int col = 0; col < c; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
