import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer ELEMENT = 69;
    private static final Integer MAX_SIZE = 16;

    private Database database;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[] {1, 2, 3};
        this.database = new Database(numbers);
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
}