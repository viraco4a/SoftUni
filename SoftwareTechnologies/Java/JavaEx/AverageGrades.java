import java.util.*;

public class AverageGrades {

    public static class Student{
        private String Name;
        private double[] Grades;
        private double AverageGrade;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public double[] getGrades() {
            return Grades;
        }

        public void setGrades(double[] grades) {
            Grades = grades;
        }

        public double getAverageGrade() {
            return AverageGrade;
        }

        public void CalculateGrade(){
            double sum = 0.0;
            for (int i = 0; i < this.Grades.length; i++) {
                double current = this.Grades[i];
                sum += current;
            }

            this.AverageGrade = sum / this.Grades.length;
        }

        public static Comparator<Student> StuNameComparator =
                (firstStudent, secondStudent) -> {
                    String name1 = firstStudent.getName();
                    String name2 = secondStudent.getName();
                    if (name1.equals(name2)) {
                        double average1 = firstStudent.getAverageGrade();
                        double average2 = secondStudent.getAverageGrade();

                        if (average1 < average2) return 1;
                        if (average1 > average2) return -1;
                        return 0;
                    }

                    return name1.compareTo(name2);
                };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s")[0];
            double[] currenGrades = Arrays.stream(input.split("\\s"))
                    .skip(1)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            Student student = new Student();
            student.Name = name;
            student.Grades = currenGrades;
            student.CalculateGrade();
            if (student.getAverageGrade() >= 5.0){
                students.add(student);
            }
        }

        Collections.sort(students, Student.StuNameComparator);

        for (Student student : students) {
            System.out.printf("%s -> %.2f\n", student.getName(), student.getAverageGrade());
        }
    }
}
