package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] splitted = line.split("\\s+");
            Person person = new Person(splitted[0], Integer.parseInt(splitted[1]), splitted[2]);
            people.add(person);
        }

        int index = Integer.parseInt(reader.readLine());
        if (index >= people.size()) {
            System.out.println("No matches");
            return;
        }
        Person searchedPerson = people.get(index);

        int same = 0;
        for (Person person : people) {
            if (person.compareTo(searchedPerson) == 0) {
                same++;
            }
        }

        if (same != 0) {
            System.out.printf("%d %d %d%n", same, people.size() - same, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
