import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, double[]> students = new TreeMap<>();

        int studentsCount = Integer.parseInt(reader.readLine());

        while (studentsCount-- > 0){
            String studentName = reader.readLine();
            double[] studentGrades = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            students.put(studentName, studentGrades);
        }

        for (Map.Entry<String, double[]> kvp : students.entrySet()) {
            double grade = calcAverage(kvp.getValue());
            System.out.printf("%s is graduated with %s%n", kvp.getKey(), grade);
        }
    }

    private static double calcAverage(double[] value) {
        double average = 0;
        for (double v : value) {
            average += v;
        }
        average /= value.length;
        return average;
    }
}
