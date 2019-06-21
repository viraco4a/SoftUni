package GenericCountMethodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double number = Double.parseDouble(reader.readLine());
            box.add(number);
        }
        Double other = Double.parseDouble(reader.readLine());

        int count = box.count(other);

        System.out.println(count);
    }
}
