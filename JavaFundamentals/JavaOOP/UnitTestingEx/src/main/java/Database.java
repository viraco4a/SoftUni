import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int DATABASE_SIZE = 16;

    private Integer[] numbers;
    private Person[] people;
    private int currentSize;
    private int peopleCount;

    private Database() {
        this.numbers = new Integer[DATABASE_SIZE];
        this.people = new Person[DATABASE_SIZE];
    }

    public Database(Integer[] numbers) throws OperationNotSupportedException {
        this();
        this.copyElements(numbers);
    }

    public Integer[] getNumbers() {
        return this.numbers;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private void copyElements(Integer[] numbers) throws OperationNotSupportedException {
        if (numbers.length <= DATABASE_SIZE) {
            System.arraycopy(numbers, 0, this.numbers, 0, numbers.length);
            this.currentSize = numbers.length;
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (number == null || currentSize >= DATABASE_SIZE) {
            throw new OperationNotSupportedException();
        } else {
            numbers[currentSize] = number;
            currentSize++;
        }
    }

    public void remove() throws OperationNotSupportedException {
        if (this.currentSize <= 0) {
            throw new OperationNotSupportedException();
        } else {
            this.numbers[currentSize - 1] = null;
            currentSize--;
        }
    }

    public Integer[] fetch() {
        Integer[] numbers = new Integer[this.currentSize];
        for (int i = 0; i < this.currentSize; i++) {
            numbers[i] = this.numbers[i];
        }

        return numbers;
    }

    public Person[] getPeople() {
        return people;
    }

    public void addPerson(Person currentPerson) throws OperationNotSupportedException {
        boolean canAdd = true;
        if (currentPerson.getUsername() == null || currentPerson.getId() < 0 || this.peopleCount >= 16) {
            throw new OperationNotSupportedException();
        }
        for (Person person : this.people) {
            if (person == null) {
                break;
            }
            if (person.getId() == currentPerson.getId() ||
                    person.getUsername().equals(currentPerson.getUsername())) {
                canAdd = false;
                break;
            }
        }

        if (canAdd) {
            this.people[peopleCount] = currentPerson;
            peopleCount++;
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public void removePerson() throws OperationNotSupportedException {
        if (peopleCount > 0) {
            this.people[peopleCount - 1] = null;
            peopleCount--;
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public Person findByUsername(String userName) throws OperationNotSupportedException {
        if (userName == null){
            throw new OperationNotSupportedException();
        }
        for (Person person : people) {
            if (person == null) {
                break;
            }
            if (person.getUsername().equals(userName)) {
                return person;
            }
        }
        throw new OperationNotSupportedException();
    }

    public Person findById(long id) throws OperationNotSupportedException {
        for (Person person : people) {
            if (person == null) {
                break;
            }
            if (person.getId() == id) {
                return person;
            }
        }
        throw new OperationNotSupportedException();
    }
}
