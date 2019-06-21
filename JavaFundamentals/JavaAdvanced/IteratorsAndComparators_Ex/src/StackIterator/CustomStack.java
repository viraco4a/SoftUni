package StackIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] items;
    private int size;

    public CustomStack() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CustomStack(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(T element) {
        if (this.items.length == this.size) {
            this.increaseCapacity();
        }
        this.items[this.size++] = element;
    }

    public T pop() {
        if (this.size == 0) {
            throw new NoSuchElementException("No elements");
        }
        T element = this.items[--this.size];
        this.items[this.size] = null;
        return element;
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        T[] newArray = (T[]) new Object[this.size * 2];
        System.arraycopy(this.items, 0, newArray, 0, this.size);
        this.items = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private final class MyStackIterator implements Iterator<T> {

        private int pointer;

        public MyStackIterator() {
            this.pointer = size - 1;
        }

        @Override
        public boolean hasNext() {
            return this.pointer >= 0;
        }

        @Override
        public T next() {
            return items[this.pointer--];
        }
    }
}
