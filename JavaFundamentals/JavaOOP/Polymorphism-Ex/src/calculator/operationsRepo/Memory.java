package calculator.operationsRepo;

import java.nio.channels.SelectionKey;
import java.util.ArrayDeque;
import java.util.Deque;

public class Memory {
    private Deque<Integer> memory;
    private String lastOperation;

    public Memory() {
        this.memory = new ArrayDeque<>();
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public String getLastOperation() {
        return this.lastOperation;
    }

    public void addToMemory(int element) {
        this.memory.push(element);
    }

    public int memoryRecall() {
        int value = -1;
        if (!this.memory.isEmpty()) {
            value = this.memory.pop();
        }
        return value;
    }
}
