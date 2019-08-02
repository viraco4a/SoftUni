package calculator;

import calculator.interfaces.Operation;
import calculator.operations.AddOperation;
import calculator.operations.DivisionOperation;
import calculator.operations.MultiplicationOperation;
import calculator.operationsRepo.Memory;

public class InputInterpreter {
    private CalculationEngine engine;
    private Memory memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new Memory();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        switch (operation) {
            case "*":
                this.memory.setLastOperation(operation);
                return new MultiplicationOperation();
            case "/":
                this.memory.setLastOperation(operation);
                return new DivisionOperation();
            case "+":
                this.memory.setLastOperation(operation);
                return new AddOperation();
            case "ms":
                this.memory.addToMemory(engine.getCurrentResult());
                break;
            case "mr":
                engine.pushNumber(this.memory.memoryRecall());
                operation = this.memory.getLastOperation();
                this.getOperation(operation);
                break;
        }

        return null;
    }
}
