import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {
    private static long[][] picture;
    private static int rowCount;
    private static int colCount;
    private static int blur;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreatePicture(scanner);
        ApplyMilkOfAPuppy(scanner);

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(picture[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void ApplyMilkOfAPuppy(Scanner scanner) {
        String[] coordinates = scanner.nextLine().split("\\s");
        int rowB = Integer.parseInt(coordinates[0]);
        int colB = Integer.parseInt(coordinates[1]);


        int rowStart = Math.max(0, rowB - 1);
        int colStart = Math.max(0, colB - 1);
        int rowEnd = Math.min(rowB + 1, rowCount - 1);
        int colEnd = Math.min(colB + 1, colCount - 1);
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {
                picture[row][col] += blur;
            }
        }
    }

    private static void CreatePicture(Scanner scanner) {
        blur = Integer.parseInt(scanner.nextLine());
        String[] sizes = scanner.nextLine().split("\\s");
        rowCount = Integer.parseInt(sizes[0]);
        colCount = Integer.parseInt(sizes[1]);
        picture = new long[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            int[] splitted = Arrays.stream(scanner.nextLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < colCount; col++) {
                picture[row][col] = splitted[col];
            }
        }
    }
}
