package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static common.OutputMessages.NULL_MACHINE_ADDED_TO_PILOT;
import static common.OutputMessages.NULL_PILOT_NAME;

public class PilotImpl implements Pilot {
    private String name;
    private Map<String, Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_PILOT_NAME);
        }
        this.name = name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException(NULL_MACHINE_ADDED_TO_PILOT);
        }
        this.machines.put(machine.getName(), machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String report() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(this.getName())
                .append(" - ")
                .append(this.getMachines().size())
                .append(" machines")
                .append(System.lineSeparator());

        if (this.getMachines().size() != 0) {
            this.getMachines().forEach(m ->
                    sb
                            .append("- ")
                            .append(m.toString())
                            .append(System.lineSeparator()
                            )
            );
        }
        return sb.toString().trim();
    }
}
