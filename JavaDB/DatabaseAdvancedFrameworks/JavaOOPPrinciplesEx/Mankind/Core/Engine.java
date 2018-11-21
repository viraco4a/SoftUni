package Mankind.Core;

import Mankind.models.Human;
import Mankind.models.Student;
import Mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    List<Human> people;

    public Engine() {
        this.people = new ArrayList<>();
    }

    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 2; i++) {
                String[] tokens = reader.readLine().split("\\s+");
                String firstName = tokens[0];
                String lastName = tokens[1];

                if (i == 0) {
                    String facultyNum = tokens[2];
                    Human student = new Student(firstName, lastName, facultyNum);
                    people.add(student);
                } else {
                    double salary = Double.parseDouble(tokens[2]);
                    double hoursWork = Double.parseDouble(tokens[3]);
                    Human worker = new Worker(firstName, lastName, salary, hoursWork);
                    people.add(worker);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        people.forEach(p ->{
            System.out.println(p.toString());
        });
    }
}
