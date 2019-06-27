package StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getName().length() == person2.getName().length()) {
            return person1.getName().substring(0, 1)
                    .compareToIgnoreCase(person2.getName().substring(0, 1));
        }

        return person1.getName().length() - person2.getName().length();
    }
}
