package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");

            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String departmentName = line[3];
            Employee employee = new Employee(name, salary, position, departmentName);
            String email;
            int age;
            if (line.length == 5) {
                if (line[4].contains("@")){
                    email = line[4];
                    employee.setEmail(email);
                } else {
                    age = Integer.parseInt(line[4]);
                    employee.setAge(age);
                }
            } else if (line.length == 6){
                email = line[4];
                age = Integer.parseInt(line[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            if (!departments.containsKey(departmentName)) {
                Department department = new Department(departmentName);
                departments.put(departmentName, department);
            }

            departments.get(departmentName).addEmployee(employee);
        }

        departments.values().forEach(Department::calculateAverageSalary);

        double max = 0.0;
        String departmentMax = "";
        for (Department department : departments.values()) {
            double local = department.getAverageSalary();
            if (local > max) {
                max = local;
                departmentMax = department.getName();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", departmentMax);

        Comparator<Employee> comparator = (e1, e2) ->
                Double.compare(e2.getSalary(), e1.getSalary());

        departments.get(departmentMax).getEmployees().stream()
                .sorted(comparator)
                .forEach(e -> System.out.println(e.toString()));
    }
}
