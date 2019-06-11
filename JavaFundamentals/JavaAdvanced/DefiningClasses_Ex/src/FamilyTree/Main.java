package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, Person> persons = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] tokens = reader.readLine().split("\\s+");
        String masterFirstName = tokens[0];
        String masterLastName = tokens[1];
        int masterId = 0;
        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] splittedLine = line.split("\\s+");
            if (line.contains("-")) {
                if (splittedLine[0].contains("/")) {
                    if (splittedLine[2].contains("/")) {
                        //date - date
                        String parentDate = splittedLine[0];
                        String childDate = splittedLine[2];

                        boolean newParent = true;
                        boolean newChild = true;
                        int parentId = 0;
                        int childId = 0;
                        for (Person person : persons.values()) {
                            if (person.getBirthday().equals(parentDate)) {
                                newParent = false;
                                parentId = person.getId();
                            }
                            if (person.getBirthday().equals(childDate)) {
                                newChild = false;
                                childId = person.getId();
                            }
                        }
                        arrangeParentship(newParent, newChild, parentId, childId);
                    } else {
                        //date - name
                        String parentDate = splittedLine[0];
                        String childFirstName = splittedLine[2];
                        String childLastName = splittedLine[3];

                        boolean newParent = true;
                        boolean newChild = true;
                        int parentId = 0;
                        int childId = 0;
                        for (Person person : persons.values()) {
                            if (person.getBirthday().equals(parentDate)) {
                                newParent = false;
                                parentId = person.getId();
                            }
                            if (person.getFirstName().equals(childFirstName) &&
                                    person.getLastName().equals(childLastName)) {
                                newChild = false;
                                childId = person.getId();
                            }
                        }
                        arrangeParentship(newParent, newChild, parentId, childId);
                    }
                } else {
                    if (splittedLine[3].contains("/")) {
                        //name - date
                        String parentFirstName = splittedLine[0];
                        String parentLastName = splittedLine[1];
                        String childDate = splittedLine[3];

                        boolean newParent = true;
                        boolean newChild = true;
                        int parentId = 0;
                        int childId = 0;
                        for (Person person : persons.values()) {
                            if (person.getFirstName().equals(parentFirstName) &&
                            person.getLastName().equals(parentLastName)) {
                                newParent = false;
                                parentId = person.getId();
                            }
                            if (person.getBirthday().equals(childDate)) {
                                newChild = false;
                                childId = person.getId();
                            }
                        }
                        arrangeParentship(newParent, newChild, parentId, childId);
                    } else {
                        //name - name
                        String parentFirstName = splittedLine[0];
                        String parentLastName = splittedLine[1];
                        String childFirstName = splittedLine[3];
                        String childLastName = splittedLine[4];

                        boolean newParent = true;
                        boolean newChild = true;
                        int parentId = 0;
                        int childId = 0;
                        for (Person person : persons.values()) {
                            if (person.getFirstName().equals(parentFirstName) &&
                                    person.getLastName().equals(parentLastName)) {
                                newParent = false;
                                parentId = person.getId();
                            }
                            if (person.getFirstName().equals(childFirstName) &&
                            person.getLastName().equals(childLastName)) {
                                newChild = false;
                                childId = person.getId();
                            }
                        }
                        arrangeParentship(newParent, newChild, parentId, childId);
                    }
                }
            } else {
                String firstName = splittedLine[0];
                String lastName = splittedLine[1];
                String birthday = splittedLine[2];
                boolean newPerson = true;
                boolean searchedMaster = firstName.equals(masterFirstName) && lastName.equals(masterLastName);
                for (Person person : persons.values()) {
                    boolean validName =
                            (person.getFirstName().equals(firstName)
                            && person.getLastName().equals(lastName))
                            || (person.getFirstName().equals("kur")
                            && person.getLastName().equals("kur"));
                    boolean validBirthday =
                            (person.getBirthday().equals(birthday))
                                    || (person.getBirthday().equals("kur"));
                    if (validName && validBirthday) {
                        newPerson = false;
                        if (person.getBirthday().equals("kur")) {
                            person.setBirthday(birthday);
                        } else if (person.getFirstName().equals("kur")) {
                            person.setFirstName(firstName);
                            person.setLastName(lastName);
                        }
                        if (searchedMaster) {
                            masterId = person.getId();
                        }
                    }
                }
                if (newPerson) {
                    Person person = new Person();
                    person.setFirstName(firstName);
                    person.setLastName(lastName);
                    person.setBirthday(birthday);
                    if (searchedMaster) {
                        masterId = person.getId();
                    }
                    persons.put(person.getId(), person);
                }
            }
        }

        System.out.println(persons.get(masterId).toString());
    }

    private static void arrangeParentship(boolean newParent, boolean newChild, int parentId, int childId) {
        if (newParent) {
            Person person = new Person();
            parentId = person.getId();
            persons.put(parentId, person);
        }
        if (newChild) {
            Person person = new Person();
            childId = person.getId();
            persons.put(childId, person);
        }
        exchangeParentship(parentId, childId);
    }

    private static void exchangeParentship(int parentId, int childId) {
        Person parent = persons.get(parentId);
        Person child = persons.get(childId);
        parent.addChld(child);
        child.addParent(parent);
    }
}
