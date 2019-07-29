package StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    private int index;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.index = 0;
    }

    public int getIndex() {
        return this.index;
    }

    public void upgradeIndex() {
        this.index = this.data.size() - 1;
    }

    public void push(String item) {
        this.data.add(item);
        this.upgradeIndex();
    }

    public String pop() {
        String element = this.data.get(this.getIndex());
        this.data.remove(index);
        this.upgradeIndex();
        return element;
    }

    public String peek() {
        return this.data.get(this.getIndex());
    }

    public boolean isEmpty() {
        return this.getIndex() == 0;
    }
}
