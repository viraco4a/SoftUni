package core;

import core.interfaces.MachinesManager;

public class Engine implements Runnable {
    private MachinesManager machinesManager;

    public Engine(MachinesManager machinesManager) {
        this.machinesManager = machinesManager;
    }

    public void run() {

    }
}
