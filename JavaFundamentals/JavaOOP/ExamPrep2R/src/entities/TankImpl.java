package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double TANK_DEFAULT_HEALTH = 100.0;
    private static final double TANK_DEFAULT_ATTACK_MODIFIER = 40.0;
    private static final double TANK_DEFAULT_DEFENSE_MODIFIER = 30.0;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, TANK_DEFAULT_HEALTH);
        this.defenseMode = false;
        this.toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.defenseMode = false;
            this.setDefensePoints(this.getDefensePoints() - TANK_DEFAULT_DEFENSE_MODIFIER);
            this.setAttackPoints(this.getAttackPoints() + TANK_DEFAULT_ATTACK_MODIFIER);
        } else {
            this.defenseMode = true;
            this.setDefensePoints(this.getDefensePoints() + TANK_DEFAULT_DEFENSE_MODIFIER);
            this.setAttackPoints(this.getAttackPoints() - TANK_DEFAULT_ATTACK_MODIFIER);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" *Defense Mode(%s)",
                this.getDefenseMode() ? "ON" : "OFF");
    }
}
