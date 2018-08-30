import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    private static char[][] matrix;
    private static char[][] rotMatrix;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("[\\(\\)]");
        int angle = Integer.parseInt(split[1]);
        angle = angle % 360;
        createMatrix(scanner);
        rotate(angle);
        print();
    }

    private static void rotate(int angle) {
        int matRow = 0;
        int matCol = 0;
        switch (angle){
            case 0:
                rotMatrix = matrix;
                break;
            case 90:
                rotMatrix = new char[matrix[0].length][matrix.length];
                for (int row = 0; row < rotMatrix.length; row++) {
                    matRow = matrix.length - 1;
                    for (int col = 0; col < rotMatrix[0].length; col++) {
                        rotMatrix[row][col] = matrix[matRow][matCol];
                        matRow--;
                    }
                    matCol++;
                }
                break;
            case 180:
                rotMatrix = new char[matrix.length][matrix[0].length];
                matRow = matrix.length - 1;
                matCol = matrix[0].length - 1;
                for (int row = 0; row < rotMatrix.length; row++) {
                    for (int col = 0; col < rotMatrix[0].length; col++) {
                        rotMatrix[row][col] = matrix[matRow - row][matCol - col];
                    }
                }
                break;
            case 270:
                rotMatrix = new char[matrix[0].length][matrix.length];
                matCol = matrix[0].length - 1;
                for (int row = 0; row < rotMatrix.length; row++) {
                    matRow = 0;
                    for (int col = 0; col < rotMatrix[0].length; col++) {
                        rotMatrix[row][col] = matrix[matRow][matCol];
                        matRow++;
                    }
                    matCol--;
                }
                break;
        }
    }

    private static void print() {
        for (int row = 0; row < rotMatrix.length; row++) {
            for (int col = 0; col < rotMatrix[0].length; col++) {
                System.out.print(rotMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void createMatrix(Scanner scanner) {
        ArrayList<String> list = new ArrayList<>();
        int max = 0;
        String input = scanner.nextLine();
        while (!"END".equals(input)){
            list.add(input);
            int local = input.length();
            if (local > max){
                max = local;
            }
            input = scanner.nextLine();
        }
        matrix = new char[list.size()][max];
        for (int row = 0; row < list.size(); row++) {
            for (int col = 0; col < max; col++) {
                if (col < list.get(row).length()){
                    matrix[row][col] = list.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
