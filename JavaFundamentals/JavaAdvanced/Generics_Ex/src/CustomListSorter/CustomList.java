package CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public long size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public void set(int index, T element){
        this.data.set(index, element);
    }

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public List<T> getData() {
        return data;
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index){
        if (index >= 0 && index < this.data.size()) {
            return this.data.remove(index);
        }
        throw new IllegalArgumentException();
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        T tmp = this.data.get(indexOne);
        this.data.set(indexOne, this.data.get(indexTwo));
        this.data.set(indexTwo, tmp);
    }

    public int countGreaterThan(T element) {
        int counter = 0;
        for (T el : this.data) {
            if (el.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(max) > 0) {
                max = this.data.get(i);
            }
        }
        return max;
    }

    public T getMin() {
        T max = this.data.get(0);
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(max) < 0) {
                max = this.data.get(i);
            }
        }
        return max;
    }
}
