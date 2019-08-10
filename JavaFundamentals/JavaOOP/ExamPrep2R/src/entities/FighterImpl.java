package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double FIGHTER_DEFAULT_HEALTH = 200.0;
    private static final double FIGHTER_DEFAULT_ATTACK_MODIFIER = 50.0;
    private static final double FIGHTER_DEFAULT_DEFENSE_MODIFIER = 25.0;

    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, FIGHTER_DEFAULT_HEALTH);
        this.aggressiveMode = false;
        this.toggleAggressiveMode();
        this.attackPointsModifier = FIGHTER_DEFAULT_ATTACK_MODIFIER;
        this.deffencePointsModifier = FIGHTER_DEFAULT_DEFENSE_MODIFIER;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.aggressiveMode = false;
            this.setAttackPoints(this.getAttackPoints() - this.attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() + this.deffencePointsModifier);
        } else {
            this.aggressiveMode = true;
            this.setAttackPoints(this.getAttackPoints() + this.attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints() - this.deffencePointsModifier);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" *Aggressive Mode(%s)",
                this.getAggressiveMode() ? "ON" : "OFF");
    }
}
