package models.cards;

import models.cards.interfaces.Card;

import static common.ConstantMessages.*;

public abstract class BaseCard implements Card {
    private static final int CARD_DAMAGE_MIN = 0;
    private static final int CARD_HEALTH_MIN = 0;

    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setHealthPoints(healthPoints);
        this.setDamagePoints(damagePoints);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CARD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints < CARD_DAMAGE_MIN) {
            throw new IllegalArgumentException(CARD_DAMAGE_LESS_THAN_ZERO);
        }
        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    private void setHealthPoints(int healthPoints) {
        if (healthPoints < CARD_HEALTH_MIN) {
            throw new IllegalArgumentException(CARD_HP_LESS_THAN_ZERO);
        }
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return String.format(CARD_REPORT_INFO, this.getName(), this.getDamagePoints());
    }
}
