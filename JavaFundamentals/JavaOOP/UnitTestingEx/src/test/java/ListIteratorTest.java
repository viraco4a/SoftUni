import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private ListIterator emptyListIterator;
    private String[] strings;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        this.strings = new String[] {"one", "two", "three"};
        this.listIterator = new ListIterator(this.strings);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void isConstructorCorrect() {
        Assert.assertEquals(3, this.listIterator.getCharacters().size());
    }

    @Test
    public void isConstructorCorrectPartTwo() {
        Assert.assertEquals("two", this.listIterator.getCharacters().get(1));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorGetsNullArray() throws OperationNotSupportedException {
        this.emptyListIterator = new ListIterator(null);
    }

    @Test
    public void doesHasNextWorksProperlyAndReturnsTrue() {
        this.listIterator.move();
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void doesHasNextWorksProperlyAndReturnsFalse() {
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void doesMoveWorksProperly() {
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertEquals("three", this.listIterator.getCharacters().get(2));
    }

    @Test
    public void doesMoveWorksProperlyAndReturnsTrue() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void doesMoveWorksProperlyAndReturnsFalse() {
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void checkPrintOperation() throws OperationNotSupportedException {
        this.listIterator.move();
        this.listIterator.print();
        Assert.assertEquals("two\r\n", systemOutRule.getLog());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkPrintOperationFails() throws OperationNotSupportedException {
        this.emptyListIterator = new ListIterator(null);
        this.emptyListIterator.print();
    }
}
