import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer ELEMENT = 69;
    private static final Integer MAX_SIZE = 16;
    private static final Integer PERSON_ID = 43;
    private static final String PERSON_USERNAME = "Tywin";
    private static final int SECOND_PERSON_ID = 4;
    private static final String SECOND_PERSON_USERNAME = "Lannister";
    private static final int NEGATIVE_ID = -5;

    private Database database;
    private Integer[] numbers;
    private Person person;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        this.numbers = new Integer[] {1, 2, 3};
        this.database = new Database(numbers);
        this.person = new Person(PERSON_ID, PERSON_USERNAME);
    }

    @Test
    public void isEmptyConstructorCorrect() {
        Assert.assertEquals(16, this.database.getNumbers().length);
    }

    @Test
    public void isConstructorCorrect() {
        Assert.assertEquals(2, (long)this.database.getNumbers()[1]);
    }

    @Test
    public void isConstructorDefinesSizeCorrectly() {
        Assert.assertEquals(3, (long)this.database.getCurrentSize());
    }

    @Test
    public void testIfAddingIsWorkingProperly() throws OperationNotSupportedException {
        this.database.add(ELEMENT);
        Assert.assertEquals(ELEMENT, this.database.getNumbers()[this.database.getCurrentSize() - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIsAddingMoreThanPossibleElementsIsPossible() throws OperationNotSupportedException {
        for (int i = 0; i < MAX_SIZE; i++) {
            this.database.add(i);
        }
    }

    @Test
    public void testIfRemovingIsCorrect() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertNull(this.database.getNumbers()[this.database.getCurrentSize()]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIsRemovingEmptyArrayOfNumbersGivesException() throws OperationNotSupportedException {
        for (int i = 0; i < MAX_SIZE; i++) {
            this.database.remove();
        }
    }

    @Test
    public void testFetchingElements() {
        Assert.assertArrayEquals(this.numbers, this.database.fetch());
    }

    @Test
    public void testPersonIsCorrectlyAdded() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        Assert.assertEquals(this.person, this.database.getPeople()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPeopleListIsFullTryAdding() throws OperationNotSupportedException {
        for (int i = 0; i < MAX_SIZE + 1; i++) {
            this.database.addPerson(this.person);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToAddExistingPersonException() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        this.database.addPerson(this.person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToAddInvalidPersonId() throws OperationNotSupportedException {
        Person person = new Person(NEGATIVE_ID, PERSON_USERNAME);
        this.database.addPerson(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToAddInvalidPersonUsername() throws OperationNotSupportedException {
        Person person = new Person(PERSON_ID, null);
        this.database.addPerson(person);
    }

    @Test
    public void testPersonIsCorrectlyRemoved() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        Person secondPerson = new Person(SECOND_PERSON_ID, SECOND_PERSON_USERNAME);
        this.database.addPerson(secondPerson);
        this.database.removePerson();
        Assert.assertNull(this.database.getPeople()[1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToRemovePersonFromEmptyPeopleArray() throws OperationNotSupportedException {
        this.database.removePerson();
    }

    @Test
    public void testFindingByUserName() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        Person secondPerson = new Person(SECOND_PERSON_ID, SECOND_PERSON_USERNAME);
        this.database.addPerson(secondPerson);
        Assert.assertEquals(secondPerson, this.database.findByUsername(SECOND_PERSON_USERNAME));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToLookForNullUserName() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToLookForMissingPerson() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        this.database.findByUsername(SECOND_PERSON_USERNAME);
    }

    @Test
    public void testFindingById() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        Person secondPerson = new Person(SECOND_PERSON_ID, SECOND_PERSON_USERNAME);
        this.database.addPerson(secondPerson);
        Assert.assertEquals(this.person, this.database.findById(PERSON_ID));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToLookByIdForMissingPerson() throws OperationNotSupportedException {
        this.database.addPerson(this.person);
        this.database.findById(SECOND_PERSON_ID);
    }
}