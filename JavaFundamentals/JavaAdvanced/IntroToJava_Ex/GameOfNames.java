import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameOfNames {

    public static class Player{
        public String Name;
        public int Points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String playerName = scanner.nextLine();
            int playerScores = Integer.parseInt(scanner.nextLine());
            Player player = new Player();
            player.Name = playerName;
            player.Points = playerScores;
            for (int j = 0; j < playerName.length(); j++) {
                int local = (int) playerName.charAt(j);
                if (local % 2 == 0){
                    player.Points += local;
                } else {
                    player.Points -= local;
                }
            }
            players.add(player);
        }
        int max = Integer.MIN_VALUE;
        String champion = "";
        for (Player player : players) {
            if (player.Points > max){
                max = player.Points;
                champion = player.Name;
            }
        }
        System.out.printf("The winner is %s - %d points", champion, max);
    }
}
