package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] numbers;

    public Lake(int... numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        private int pointer;

        @Override
        public boolean hasNext() {
            if (this.pointer % 2 == 0) {
                return true;
            }
            return this.pointer < numbers.length;
        }

        @Override
        public Integer next() {
            int item = numbers[this.pointer];
            this.pointer += 2;
            if (this.pointer % 2 == 0 && this.pointer >= numbers.length) {
                this.pointer = 1;
            }

            return item;
        }
    }
}
