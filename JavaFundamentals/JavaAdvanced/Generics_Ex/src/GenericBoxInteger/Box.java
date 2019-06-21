package GenericBoxInteger;

public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.getClass().getCanonicalName() + ": " + this.data;
    }
}
