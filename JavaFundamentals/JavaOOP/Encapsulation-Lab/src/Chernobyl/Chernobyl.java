package Chernobyl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chernobyl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(reader.readLine());
        System.out.println(anatolyDyatlov(x));
    }

    private static String anatolyDyatlov(double x) {
        return x < 3.6
                ? "Not terrible!"
                : x > 3.6
                    ? "You are delusional, take him to the infirmary!"
                    : "3.6 - not great not terrible";
    }
}
