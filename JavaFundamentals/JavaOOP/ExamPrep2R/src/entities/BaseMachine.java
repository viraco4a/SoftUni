package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static common.OutputMessages.*;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints,
                       double defensePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_MACHINE_NAME);
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null) {
            throw new NullPointerException(NULL_PILOT);
        }
        this.pilot = pilot;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    @Override
    public void attack(String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException(BASE_MACHINE_NULL_TARGET);
        }
        this.targets.add(target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("- ")
                .append(this.getName())
                .append(System.lineSeparator())
                .append(" *Type: ")
                .append(this.getClass().getInterfaces()[0].getSimpleName())
                .append(System.lineSeparator());
        sb
                .append(" *Health: ")
                .append(String.format("%.2f", this.getHealthPoints()))
                .append(System.lineSeparator());
        sb
                .append(" *Attack: ")
                .append(String.format("%.2f", this.getAttackPoints()))
                .append(System.lineSeparator());
        sb
                .append(" *Defense: ")
                .append(String.format("%.2f", this.getDefensePoints()))
                .append(System.lineSeparator());
        sb.append(" *Targets: ");
        if (this.getTargets().size() == 0) {
            sb.append("None");
            return sb.toString().trim() + System.lineSeparator();
        } else {
            this.getTargets().forEach(t -> sb.append(t).append(", "));
            String result = sb.toString().trim();
            return result.substring(0, result.length() - 1) + System.lineSeparator();
        }
    }
}
