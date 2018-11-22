package com.company;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter username default (root): ");
//        String user = sc.nextLine();
//        user = user.equals("") ? "root" : user;
//        System.out.println();
//
//        System.out.print("Enter password default (empty):");
//        String password = sc.nextLine().trim();
//        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "usaluboa");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

//        String salaryLine = sc.nextLine();
        stmt.setDouble(1, 0);
        ResultSet rs = stmt.executeQuery();

        List<Employee> employees = toList(rs);
        employees.forEach(System.out::println);
        System.out.println(employees.get(5).salary);

        connection.close();
    }

    static List<Employee> toList(ResultSet resultSet) throws SQLException {
        List<Employee> result = new ArrayList<>();

        while(resultSet.next()){
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_ame");
            double salary = resultSet.getDouble("salary");
            Employee employee = new Employee();
            employee.firstName = firstName;
            employee.lastName = lastName;
            employee.salary = salary;
            result.add(employee);
        }

        return result;
    }

    static class Employee {
        public String firstName;
        public String lastName;
        public double salary;
    }
}