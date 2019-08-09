import common.InputInterpreter;
import core.Engine;
import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ManagerController managerController = new ManagerControllerImpl();
        InputInterpreter inputInterpreter = new InputInterpreter();

        Engine engine = new Engine(managerController, inputInterpreter);
        engine.run();
    }
}
