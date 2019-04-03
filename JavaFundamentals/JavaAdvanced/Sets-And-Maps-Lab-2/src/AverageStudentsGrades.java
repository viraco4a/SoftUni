import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            double finalGrade = 0;
            int counter = 0;
            List<Double> grades = students.get(name);

            for (Double num : grades) {
                finalGrade += num;
                counter++;
            }

            double avr = finalGrade / counter;
            students.get(name).add(0, avr);
        }
        System.out.println(); //TODO
    }
}
