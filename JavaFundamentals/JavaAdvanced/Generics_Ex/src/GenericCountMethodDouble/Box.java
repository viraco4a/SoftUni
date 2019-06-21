package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public int count(T other) {
        int count = 0;

        for (T element : this.data) {
            if (element.compareTo(other) > 0) {
                count++;
            }
        }

        return count;
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
