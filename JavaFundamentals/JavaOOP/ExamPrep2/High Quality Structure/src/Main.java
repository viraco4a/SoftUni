package src;

import src.core.MachinesManagerImpl;

import src.core.interfaces.MachineFactory;
import src.core.interfaces.PilotFactory;
import src.core.interfaces.MachinesManager;
import src.entities.interfaces.Machine;
import src.entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = null; //TODO change null with your implementation
        MachineFactory machineFactory = null; //TODO change null with your implementation
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

    }
}
