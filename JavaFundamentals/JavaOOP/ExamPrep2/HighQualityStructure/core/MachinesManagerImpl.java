package core;

import core.interfaces.MachineFactory;
import core.interfaces.MachinesManager;
import core.interfaces.PilotFactory;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = this.pilotFactory.createPilot(name);
        if (this.pilots.containsKey(name)) {
            return String.format(pilotExists, name);
        } else {
            this.pilots.put(name, pilot);
            return String.format(pilotHired, name);
        }
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
        if (this.machines.containsKey(name)) {
            return String.format(machineExists, name);
        } else {
            this.machines.put(name, tank);
            return String.format(tankManufactured, name, attackPoints, defensePoints);
        }
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        if (this.machines.containsKey(name)) {
            return String.format(machineExists, name);
        } else {
            this.machines.put(name, fighter);
            return String.format(fighterManufactured, name, attackPoints, defensePoints);
        }
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        return null;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        return null;
    }

    @Override
    public String pilotReport(String pilotName) {
        return null;
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        return null;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        return null;
    }
}
