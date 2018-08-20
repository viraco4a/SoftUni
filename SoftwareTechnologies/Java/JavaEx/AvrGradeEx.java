import java.util.*;

public class AvrGradeEx {

    public static class Student {
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

        public void CalcAverageGrade(){
            double sum = 0;
            for (int i = 0; i < this.Grades.length; i++) {
                double grade = this.Grades[i];
                sum += grade;
            }

            this.AverageGrade = sum / this.Grades.length;
        }

        public static Comparator<Student> NameAndGradeComparator =
                (firstStudent, secondStudent) -> {
                    String first = firstStudent.getName();
                    String second = secondStudent.getName();
                    if (first.equals(second)){
                        double firstAvr = firstStudent.getAverageGrade();
                        double secondAvr = secondStudent.getAverageGrade();
                        if (firstAvr > secondAvr){
                            return -1;
                        }
                        if (secondAvr > firstAvr){
                            return 1;
                        }
                        return 0;
                    }

                    return first.compareTo(second);
                };

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s")[0];
            double[] grades = Arrays.stream(input.split("\\s"))
                    .skip(1)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            Student student = new Student();
            student.Name = name;
            student.Grades = grades;
            student.CalcAverageGrade();
            if (student.getAverageGrade() >= 5.0){
                students.add(student);
            }
        }

        Collections.sort(students, Student.NameAndGradeComparator);

        for (Student student : students) {
            System.out.printf("%s -> %.2f\n", student.getName(), student.getAverageGrade());
        }
    }
}
