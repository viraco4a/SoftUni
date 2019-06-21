package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public void swap(int indexOne, int indexTwo) {
        T tmp = this.data.get(indexOne);
        this.data.set(indexOne, this.data.get(indexTwo));
        this.data.set(indexTwo, tmp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.data) {
            sb.append(element.getClass().getCanonicalName())
                    .append(": ")
                    .append(element)
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
