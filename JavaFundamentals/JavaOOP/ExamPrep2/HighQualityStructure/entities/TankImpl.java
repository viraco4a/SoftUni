package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double TANK_DEFAULT_HEALTH = 100.0;
    private static final double TANK_DEFAULT_ATTACK_MODIFIER = 40.0;
    private static final double TANK_DEFAULT_DEFENSE_MODIFIER = 30.0;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, TANK_DEFAULT_HEALTH);
        this.defenseMode = false;
        this.toggleDefenseMode();
        this.attackPointsModifier = TANK_DEFAULT_ATTACK_MODIFIER;
        this.deffencePointsModifier = TANK_DEFAULT_DEFENSE_MODIFIER;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.defenseMode = false;
            this.setDefensePoints(this.getDefensePoints() - this.deffencePointsModifier);
            this.setAttackPoints(this.getAttackPoints() + this.attackPointsModifier);
        } else {
            this.defenseMode = true;
            this.setDefensePoints(this.getDefensePoints() + this.deffencePointsModifier);
            this.setAttackPoints(this.getAttackPoints() - this.attackPointsModifier);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" *Defense Mode(%s)",
                this.getDefenseMode() ? "ON" : "OFF");
    }
}
