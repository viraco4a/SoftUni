package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> peopleSortedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleSortedByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] splitted = reader.readLine().split("\\s+");
            Person person = new Person(splitted[0], Integer.parseInt(splitted[1]));
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
