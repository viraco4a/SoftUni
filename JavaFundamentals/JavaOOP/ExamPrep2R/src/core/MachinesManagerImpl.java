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
    private static final double MINIMUM_HEALTH = 0;

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
        }

        this.machines.put(name, fighter);
        return String.format(fighterManufactured, name, attackPoints, defensePoints);

    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format(pilotNotFound, selectedPilotName);
        }

        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format(machineNotFound, selectedMachineName);
        }

        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);

        if (machine.getPilot() != null) {
            return String.format(machineHasPilotAlready, selectedMachineName);
        }

        machine.setPilot(pilot);
        pilot.addMachine(machine);

        return String.format(machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)) {
            return String.format(machineNotFound, attackingMachineName);
        }
        if (!this.machines.containsKey(defendingMachineName)) {
            return String.format(machineNotFound, defendingMachineName);
        }

        Machine attackingMachine = this.machines.get(attackingMachineName);
        Machine defendingkMachine = this.machines.get(defendingMachineName);

        attackingMachine.attack(defendingMachineName);

        if (attackingMachine.getAttackPoints() > defendingkMachine.getDefensePoints()) {
            defendingkMachine.setHealthPoints(
                    defendingkMachine.getHealthPoints() - attackingMachine.getAttackPoints()
            );
            if (defendingkMachine.getHealthPoints() < MINIMUM_HEALTH) {
                defendingkMachine.setHealthPoints(MINIMUM_HEALTH);
            }
        }
        return String.format(attackSuccessful,
                defendingMachineName,
                attackingMachineName,
                defendingkMachine.getHealthPoints()
        );
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            return String.format(pilotNotFound, pilotName);
        }
        Pilot pilot = this.pilots.get(pilotName);

        return pilot.report();

    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!this.machines.containsKey(fighterName)) {
            return String.format(machineNotFound, fighterName);
        }
        if (machines.get(fighterName) instanceof Tank) {
            return String.format(notSupportedOperation, fighterName);
        }
        Fighter fighter = (Fighter) this.machines.get(fighterName);
        fighter.toggleAggressiveMode();

        return String.format(fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!this.machines.containsKey(tankName)) {
            return String.format(machineNotFound, tankName);
        }
        if (machines.get(tankName) instanceof Fighter) {
            return String.format(notSupportedOperation, tankName);
        }
        Tank tank = (Tank) this.machines.get(tankName);
        tank.toggleDefenseMode();

        return String.format(tankOperationSuccessful, tankName);
    }
}
