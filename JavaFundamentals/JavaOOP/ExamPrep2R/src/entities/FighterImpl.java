package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double FIGHTER_DEFAULT_HEALTH = 200.0;
    private static final double FIGHTER_DEFAULT_ATTACK_MODIFIER = 50.0;
    private static final double FIGHTER_DEFAULT_DEFENSE_MODIFIER = 25.0;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, FIGHTER_DEFAULT_HEALTH);
        this.aggressiveMode = false;
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.aggressiveMode = false;
            super.setAttackPoints(super.getAttackPoints() - FIGHTER_DEFAULT_ATTACK_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + FIGHTER_DEFAULT_DEFENSE_MODIFIER);
        } else {
            this.aggressiveMode = true;
            super.setAttackPoints(super.getAttackPoints() + FIGHTER_DEFAULT_ATTACK_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - FIGHTER_DEFAULT_DEFENSE_MODIFIER);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" *Aggressive Mode(%s)",
                this.getAggressiveMode() ? "ON" : "OFF");
    }
}
