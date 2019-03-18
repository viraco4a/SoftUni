import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class RadioactiveMutantVampireBunnies {
    private static char[][] jaggedArray;
    private static int playerRow;
    private static int playerCol;
    private static boolean isOutside;
    private static boolean isDead;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimentions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];
        jaggedArray = new char[rows][];

        getJaggedArray(cols, reader);

        String directions = reader.readLine();

        movePlayer(directions);
    }

    private static void movePlayer(String directions) {
        for (int i = 0; i < directions.length(); i++)
        {
            char currentStep = directions.charAt(i);
            if (currentStep == 'U')
            {
                move(-1, 0);
            }
            else if (currentStep == 'L')
            {
                move(0, -1);
            }
            else if (currentStep == 'D')
            {
                move(1, 0);
            }
            else if (currentStep == 'R')
            {
                move(0, 1);
            }

            spread();

            if (isDead)
            {
                printJaggedArray();
                System.out.printf("dead: %s %s%n", playerRow, playerCol);
                break;
            }
            else if (isOutside)
            {
                printJaggedArray();
                System.out.printf("won: %s %s%n", playerRow, playerCol);
                break;
            }
        }
    }

    private static void move(int row, int col) {
        int targetRow = playerRow + row;
        int targetCol = playerCol + col;

        if (!isInside(targetRow, targetCol))
        {
            jaggedArray[playerRow][playerCol] = '.';
            isOutside = true;

        }
        else if (isBunny(targetRow, targetCol))
        {
            jaggedArray[playerRow][playerCol] = '.';
            playerRow += row;
            playerCol += col;
            isDead = true;
        }
        else
        {
            jaggedArray[playerRow][playerCol] = '.';

            playerRow += row;
            playerCol += col;

            jaggedArray[playerRow][playerCol] = 'P';
        }
    }

    private static void spread() {
        Deque<int[]> indexes = new ArrayDeque<>();

        for (int row = 0; row < jaggedArray.length; row++)
        {
            for (int col = 0; col < jaggedArray[row].length; col++)
            {
                if (jaggedArray[row][col] == 'B')
                {
                    indexes.offer(new int[] { row, col });
                }
            }
        }

        while (!indexes.isEmpty()) {
            int[] curretnIndex = indexes.poll();

            int targetRow = curretnIndex[0];
            int targetCol = curretnIndex[1];

            if (isInside(targetRow - 1, targetCol))
            {
                if (isPlayer(targetRow - 1, targetCol))
                {
                    isDead = true;
                }
                jaggedArray[targetRow - 1][targetCol] = 'B';
            }

            if (isInside(targetRow + 1, targetCol))
            {
                if (isPlayer(targetRow + 1, targetCol))
                {
                    isDead = true;
                }
                jaggedArray[targetRow + 1][targetCol] = 'B';
            }

            if (isInside(targetRow, targetCol - 1))
            {
                if (isPlayer(targetRow, targetCol - 1))
                {
                    isDead = true;
                }
                jaggedArray[targetRow][targetCol - 1] = 'B';
            }

            if (isInside(targetRow, targetCol + 1))
            {
                if (isPlayer(targetRow, targetCol + 1))
                {
                    isDead = true;
                }
                jaggedArray[targetRow][targetCol + 1] = 'B';
            }
        }
    }

    private static boolean isPlayer(int row, int col) {
        return jaggedArray[row][col] == 'P';
    }

    private static boolean isBunny(int targetRow, int targetCol)
    {
        return jaggedArray[targetRow][targetCol] == 'B';
    }

    private static boolean isInside(int row, int col) {
        return row >= 0 && row < jaggedArray.length && col >= 0 && col < jaggedArray[0].length;
    }

    private static void printJaggedArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jaggedArray.length; i++) {
            char[] chars = jaggedArray[i];
            for (char aChar : chars) {
                sb.append(aChar);
            }
            if (i != jaggedArray.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());
    }

    private static void getJaggedArray(int cols, BufferedReader reader) throws IOException {
        for (int row = 0; row < jaggedArray.length; row++)
        {
            String line = reader.readLine();
            jaggedArray[row] = new char[cols];
            for (int col = 0; col < cols; col++)
            {
                jaggedArray[row][col] = line.charAt(col);
                if (line.charAt(col) == 'P')
                {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}
