import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int INTEGERS_SIZE = 16;

    private Integer[] numbers;
    private int currentSize;

    public Database() {
        this.numbers = new Integer[INTEGERS_SIZE];
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
        if (numbers.length <= INTEGERS_SIZE) {
            System.arraycopy(numbers, 0, this.numbers, 0, numbers.length);
            this.currentSize = numbers.length;
        } else {
            throw new OperationNotSupportedException();
        }
    }

    public void add(Integer number) throws OperationNotSupportedException {
        if (number == null || currentSize >= INTEGERS_SIZE) {
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
}
