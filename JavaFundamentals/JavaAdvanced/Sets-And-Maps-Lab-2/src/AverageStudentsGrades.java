import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AverageStudentsGrades {

    public static class Student{
        private List<Double> grades;
        private double averageGrade;
        private String name;

        public Student(String name) {
            this.name = name;
            this.grades = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Double> getGrades() {
            return grades;
        }

        public void setGrades(List<Double> grades) {
            this.grades = grades;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        public void calcGrade() {
            double sum;
            double count = this.grades.size();
            sum = grades.stream().mapToDouble(g -> g).sum();
            this.averageGrade = sum / count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Student> students = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new Student(name));
            }

            students.get(name).grades.add(grade);
        }

        StringBuilder sb = new StringBuilder();
        students.forEach((k, v) -> {
            v.calcGrade();
            sb.append(k).append(" -> ");
            v.grades.forEach(g -> {
                sb.append(String.format("%.2f ", g));
            });

            sb.append(String.format("(avg: %.2f)", v.getAverageGrade())).append(System.lineSeparator());
        });

        System.out.println(sb.toString());
    }
}
