import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpaceStationEstablishment {
    private static final String BLACK_HOLE = "O";
    private static final String EMPTY_SPACE = "-";
    private static final String PLAYER = "S";

    private static String[][] matrix;
    private static int dimension;
    private static int playerRow = 0;
    private static int playerCol = 0;
    private static int blackHoleRow1 = 0;
    private static int blackHoleCol1 = 0;
    private static int blackHoleRow2 = 0;
    private static int blackHoleCol2 = 0;
    private static int stars;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readMatrix(reader);

        boolean lost = false;
        boolean energyCollected = false;
        while (true) {
            String command = reader.readLine().toLowerCase();
            switch (command) {
                case "right":
                    matrix[playerRow][playerCol] = EMPTY_SPACE;
                    if (!isValidIndex(playerRow, playerCol + 1)) {
                        lost = true;
                    } else {
                        switch (matrix[playerRow][playerCol + 1]) {
                            case BLACK_HOLE:
                                if (blackHoleRow1 == playerRow) {
                                    playerRow = blackHoleRow2;
                                    playerCol = blackHoleCol2;
                                } else {
                                    playerRow = blackHoleRow1;
                                    playerCol = blackHoleCol1;
                                }
                                matrix[blackHoleRow1][blackHoleCol1] = EMPTY_SPACE;
                                matrix[blackHoleRow2][blackHoleCol2] = EMPTY_SPACE;
                                break;
                            case EMPTY_SPACE:
                                playerCol++;
                                break;
                            default:
                                int star = Integer.parseInt(matrix[playerRow][playerCol + 1]);
                                stars += star;
                                playerCol++;
                                if (stars >= 50) {
                                    energyCollected = true;
                                }
                                break;
                        }
                        matrix[playerRow][playerCol] = PLAYER;
                    }
                    break;
                case "left":
                    matrix[playerRow][playerCol] = EMPTY_SPACE;
                    if (!isValidIndex(playerRow, playerCol - 1)) {
                        lost = true;
                    } else {
                        switch (matrix[playerRow][playerCol - 1]) {
                            case BLACK_HOLE:
                                if (blackHoleRow1 == playerRow) {
                                    playerRow = blackHoleRow2;
                                    playerCol = blackHoleCol2;
                                } else {
                                    playerRow = blackHoleRow1;
                                    playerCol = blackHoleCol1;
                                }
                                matrix[blackHoleRow1][blackHoleCol1] = EMPTY_SPACE;
                                matrix[blackHoleRow2][blackHoleCol2] = EMPTY_SPACE;
                                break;
                            case EMPTY_SPACE:
                                playerCol--;
                                break;
                            default:
                                int star = Integer.parseInt(matrix[playerRow][playerCol - 1]);
                                stars += star;
                                playerCol--;
                                if (stars >= 50) {
                                    energyCollected = true;
                                }
                                break;
                        }
                        matrix[playerRow][playerCol] = PLAYER;
                    }
                    break;
                case "up":
                    matrix[playerRow][playerCol] = EMPTY_SPACE;
                    if (!isValidIndex(playerRow - 1, playerCol)) {
                        lost = true;
                    } else {
                        switch (matrix[playerRow - 1][playerCol]) {
                            case BLACK_HOLE:
                                if (blackHoleRow1 == playerRow) {
                                    playerRow = blackHoleRow2;
                                    playerCol = blackHoleCol2;
                                } else {
                                    playerRow = blackHoleRow1;
                                    playerCol = blackHoleCol1;
                                }
                                matrix[blackHoleRow1][blackHoleCol1] = EMPTY_SPACE;
                                matrix[blackHoleRow2][blackHoleCol2] = EMPTY_SPACE;
                                break;
                            case EMPTY_SPACE:
                                playerRow--;
                                break;
                            default:
                                int star = Integer.parseInt(matrix[playerRow - 1][playerCol]);
                                stars += star;
                                playerRow--;
                                if (stars >= 50) {
                                    energyCollected = true;
                                }
                                break;
                        }
                        matrix[playerRow][playerCol] = PLAYER;
                    }
                    break;
                case "down":
                    matrix[playerRow][playerCol] = EMPTY_SPACE;
                    if (!isValidIndex(playerRow + 1, playerCol)) {
                        lost = true;
                    } else {
                        switch (matrix[playerRow + 1][playerCol]) {
                            case BLACK_HOLE:
                                if (blackHoleRow1 == playerRow) {
                                    playerRow = blackHoleRow2;
                                    playerCol = blackHoleCol2;
                                } else {
                                    playerRow = blackHoleRow1;
                                    playerCol = blackHoleCol1;
                                }
                                matrix[blackHoleRow1][blackHoleCol1] = EMPTY_SPACE;
                                matrix[blackHoleRow2][blackHoleCol2] = EMPTY_SPACE;
                                break;
                            case EMPTY_SPACE:
                                playerRow++;
                                break;
                            default:
                                int star = Integer.parseInt(matrix[playerRow + 1][playerCol]);
                                stars += star;
                                playerRow++;
                                if (stars >= 50) {
                                    energyCollected = true;
                                }
                                break;
                        }
                        matrix[playerRow][playerCol] = PLAYER;
                    }
                    break;
            }
            if (lost) {
                System.out.println("Bad news, the spaceship went to the void.");
                break;
            }
            if (energyCollected) {
                System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                break;
            }
        }

        System.out.printf("Star power collected: %s%n", stars);

        printMatrix();
    }

    private static boolean isValidIndex(int row, int col) {
        return row >= 0 && col >= 0 && row < dimension && col < dimension;
    }

    private static void printMatrix() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        dimension = Integer.parseInt(reader.readLine());
        matrix = new String[dimension][dimension];
        int blackHoleCounter = 0;
        for (int i = 0; i < dimension; i++) {
            String line = reader.readLine();
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = Character.toString(line.charAt(j));
                if (matrix[i][j].equals(PLAYER)) {
                    playerRow = i;
                    playerCol = j;
                } else if (matrix[i][j].equals(BLACK_HOLE)) {
                    if (blackHoleCounter == 0) {
                        blackHoleRow1 = i;
                        blackHoleCol1 = j;
                    } else {
                        blackHoleRow2 = i;
                        blackHoleCol2 = j;
                    }
                    blackHoleCounter++;
                }
            }
        }
    }
}
