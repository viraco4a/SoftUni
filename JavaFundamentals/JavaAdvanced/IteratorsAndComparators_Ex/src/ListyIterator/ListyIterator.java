package ListyIterator;

import java.util.*;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> items;
    private int pointer;

    public ListyIterator(T... elements) {
        this.setItems(elements);
        pointer = 0;
    }

    public void setItems(T... elements) {
        if (elements.length > 0) {
            this.items = Arrays.asList(elements);
        } else {
            this.items = new ArrayList<>();
        }
    }

    public boolean move() {
        if (this.hasNext()) {
            pointer++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return pointer < this.items.size() - 1;
    }

    public T print() {
        if (this.items.size() != 0) {
            return this.items.get(pointer);
        }
        throw new IllegalArgumentException("Invalid Operation!");
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder();
        this.items.stream().forEach(e -> sb.append(e).append(" "));
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListyIteratorIterator();
    }

    private final class ListyIteratorIterator implements Iterator<T> {

        private int pointer;

        @Override
        public boolean hasNext() {
            return this.pointer < items.size();
        }

        @Override
        public T next() {
            T item = items.get(this.pointer);
            if (this.hasNext()) {
                this.pointer++;
            }
            return item;
        }
    }

}
