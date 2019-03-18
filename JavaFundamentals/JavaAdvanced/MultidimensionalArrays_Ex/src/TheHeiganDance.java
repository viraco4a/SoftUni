import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheHeiganDance {
    private static boolean[][] playground = new boolean[15][];
    private static final int matrixSize = 15;
    private static int playerRow = 7;
    private static int playerCol = 7;
    private static int potentialRow = 7;
    private static int potentialCol = 7;
    private static double heiganHP = 3000000;
    private static double playerHP = 18500;
    private static final double cloudDamage = 3500;
    private static final double eruptionDamage = 6000;
    private static boolean playerDead;
    private static boolean heiganDead;
    private static boolean isHit;
    private static boolean cloud;
    private static String deadBy = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        initializePlayground();

        double damage = Double.parseDouble(reader.readLine());

        while (!false){
            String[] attack = reader.readLine().split("\\s+");

            String type = attack[0];

            int attackedRow = Integer.parseInt(attack[1]);
            int attackedCol = Integer.parseInt(attack[2]);

            playerAttack(damage);

            if (heiganDead) {
                applySecondClound();
                System.out.println("Heigan: Defeated!");
                if (playerDead) {
                    System.out.printf("Player: Killed by %s%n", deadBy);
                } else {
                    System.out.printf("Player: %.0f%n", playerHP);
                }
                System.out.printf("Final position: %s, %s%n", playerRow, playerCol);
                return;
            } else {
                heiganAttack(attackedRow, attackedCol, type);
                if (playerDead) {
                    System.out.printf("Heigan: %.2f%n", heiganHP);
                    System.out.printf("Player: Killed by %s%n", deadBy);
                    System.out.printf("Final position: %s, %s%n", playerRow, playerCol);
                    return;
                }
            }
        }
    }

    private static void heiganAttack(int attackedRow, int attackedCol, String type) {
        applySecondClound();
        dealDamage(attackedRow, attackedCol, true);
        if (playground[playerRow][playerCol]) {
            move(-1, 0);
            if (isHit) {
                move(0, 1);
            }
            if (isHit) {
                move(1, 0);
            }
            if (isHit) {
                move(0, -1);
            }
            if (isHit) {
                playerRow = potentialRow;
                playerCol = potentialCol;
                if (type.equals("Cloud")) {
                    applyCloud();
                } else {
                    playerHP -= eruptionDamage;
                    if (playerHP <= 0 && !playerDead) {
                        playerDead = true;
                        deadBy = "Eruption";
                    }
                }
            }
        }
        dealDamage(attackedRow, attackedCol, false);
    }

    private static void applyCloud() {
        playerHP -= cloudDamage;
        if (playerHP <= 0) {
            playerDead = true;
            deadBy = "Plague Cloud";
        }
        cloud = true;
    }

    private static void move(int row, int col) {
        if (isValid(playerRow + row, playerCol + col)){
            if (!playground[playerRow + row][playerCol + col]) {
                potentialRow = playerRow + row;
                potentialCol = playerCol + col;
                playerRow += row;
                playerCol += col;
                isHit = false;
                return;
            }
        }
        isHit = true;
    }

    private static void dealDamage(int attackedRow, int attackedCol, boolean isDamage) {
        for (int row = attackedRow - 1; row <= attackedRow + 1; row++) {
            for (int col = attackedCol - 1; col <= attackedCol + 1; col++) {
                if (isValid(row, col)){
                    playground[row][col] = isDamage;
                }
            }
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < playground.length && col >= 0 && col < playground[row].length;
    }

    private static void applySecondClound() {
        if (cloud) {
            playerHP -= cloudDamage;
            if (playerHP <= 0) {
                playerDead = true;
                deadBy = "Plague Cloud";
            }
        }
        cloud = false;
    }

    private static void playerAttack(double damage) {
        heiganHP -= damage;
        if (heiganHP <= 0) {
            heiganDead = true;
        }
    }

    private static void initializePlayground() {
        for (int i = 0; i < matrixSize; i++) {
            playground[i] = new boolean[matrixSize];
        }
    }
}
