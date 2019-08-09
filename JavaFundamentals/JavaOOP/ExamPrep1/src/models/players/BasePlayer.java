package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.*;

public abstract class BasePlayer implements Player {
    private static final int HEALTH_POINTS_MIN = 0;
    private static final int DAMAGE_POINTS_MIN = 0;

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setCardRepository(cardRepository);
        this.setUsername(username);
        this.setHealth(health);
        this.setDead(false);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < HEALTH_POINTS_MIN) {
            throw new IllegalArgumentException(PLAYER_HEALTH_BELOW_ZERO);
        }
        this.health = healthPoints;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(PLAYER_USER_NULL_OR_EMPTY);
        }
        this.username = username;
    }

    private void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < DAMAGE_POINTS_MIN) {
            throw new IllegalArgumentException(DAMAGE_POINTS_LESS_THAN_ZERO);
        }
        this.health -= damagePoints;

        if (health <= HEALTH_POINTS_MIN) {
            this.setHealth(HEALTH_POINTS_MIN);
            this.setDead(true);
        }
    }
}
