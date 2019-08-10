package core;

import common.Command;
import core.interfaces.MachinesManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Engine implements Runnable {
    private BufferedReader reader;
    private MachinesManager machinesManager;

    public Engine(MachinesManager machinesManager) {
        this.machinesManager = machinesManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();
                if (Command.Over.name().equals(result)) {
                    break;
                }
            } catch (IOException | IllegalArgumentException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        Command command = Command.valueOf(tokens[0]);
        String result = null;

        switch (command) {
            case Hire:
                result = hire(data);
                break;
            case Report:
                result = report(data);
                break;
            case ManufactureTank:
                result = manufactureTank(data);
                break;
            case ManufactureFighter:
                result = manufactureFighter(data);
                break;
            case Engage:
                result = engage(data);
                break;
            case Attack:
                result = attack(data);
                break;
            case DefenseMode:
                result = defenseMode(data);
                break;
            case AggressiveMode:
                result = aggressiveMode(data);
                break;
            case Over:
                result = Command.Over.name();
                break;
        }
        return result;
    }

    private String aggressiveMode(String[] data) {
        String machineName = data[0];
        return this.machinesManager.toggleFighterAggressiveMode(machineName);
    }

    private String defenseMode(String[] data) {
        String machineName = data[0];
        return this.machinesManager.toggleTankDefenseMode(machineName);
    }

    private String attack(String[] data) {
        String attackingMachineName = data[0];
        String defendingMachineName = data[1];
        return this.machinesManager.attackMachines(
                attackingMachineName, defendingMachineName);
    }

    private String engage(String[] data) {
        String pilotName = data[0];
        String machineName = data[1];
        return this.machinesManager.engageMachine(pilotName, machineName);
    }

    private String manufactureFighter(String[] data) {
        String fighterName = data[0];
        double attackPoints = Double.parseDouble(data[1]);
        double defensePoints = Double.parseDouble(data[2]);
        return this.machinesManager.manufactureFighter(
                fighterName, attackPoints, defensePoints);
    }

    private String manufactureTank(String[] data) {
        String tankName = data[0];
        double attackPoints = Double.parseDouble(data[1]);
        double defensePoints = Double.parseDouble(data[2]);
        return this.machinesManager.manufactureTank(
                tankName, attackPoints, defensePoints);
    }

    private String report(String[] data) {
        String pilotName = data[0];
        return this.machinesManager.pilotReport(pilotName);
    }

    private String hire(String[] data) {
        String pilotName = data[0];
        return this.machinesManager.hirePilot(pilotName);
    }
}
