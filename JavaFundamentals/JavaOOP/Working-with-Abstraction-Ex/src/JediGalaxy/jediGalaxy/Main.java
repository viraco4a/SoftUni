package JediGalaxy.jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = readInput(reader.readLine());

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        Ivo ivo = new Ivo();
        Evil evil = new Evil();
        String command = "";

        while (!"Let the Force be with you".equals(command = reader.readLine())) {
            int[] ivoS = readInput(command);
            int[] evilC = readInput(reader.readLine());

            evil.setStarterPosition(evilC[0], evilC[1]);
            evil.destroyStar(galaxy);
            ivo.setStarterPosition(ivoS[0], ivoS[1]);
            ivo.collectStars(galaxy);
        }

        System.out.println(ivo.getStars());
    }

    private static int[] readInput(String s) {
        return Arrays.stream(s.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
