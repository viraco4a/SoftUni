package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

import static common.ConstantMessages.*;

public class BattleFieldImpl implements Battlefield {
    private static final int BEGINNER_HEALTH_BONUS = 40;
    private static final int CARD_DAMAGE_BONUS = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException(PLAYER_IS_DEAD);
        }

        applyBeginnerBonus(attackPlayer);
        applyBeginnerBonus(enemyPlayer);

        getHealthPointsFromDeck(attackPlayer);
        getHealthPointsFromDeck(enemyPlayer);

        processFight(attackPlayer, enemyPlayer);
    }

    private void processFight(Player attackPlayer, Player enemyPlayer) {
        while (true) {
            int attackPlayerDamagePoints = attackPlayer
                    .getCardRepository()
                    .getCards()
                    .stream()
                    .mapToInt(Card::getDamagePoints)
                    .sum();

            enemyPlayer.takeDamage(attackPlayerDamagePoints);

            if (enemyPlayer.isDead()) {
                return;
            }

            int enemyPlayerDamagePoints = enemyPlayer
                    .getCardRepository()
                    .getCards()
                    .stream()
                    .mapToInt(Card::getDamagePoints)
                    .sum();

            attackPlayer.takeDamage(enemyPlayerDamagePoints);

            if (attackPlayer.isDead()) {
                return;
            }
        }
    }

    private void getHealthPointsFromDeck(Player player) {
        int bonusHealth = player.getCardRepository()
                .getCards()
                .stream()
                .mapToInt(Card::getHealthPoints)
                .sum();
        player.setHealth(player.getHealth() + bonusHealth);
    }

    private void applyBeginnerBonus(Player player) {
        if (!Beginner.class.getSimpleName().equals(player.getClass().getSimpleName())) {
            return;
        }

        player.setHealth(player.getHealth() + BEGINNER_HEALTH_BONUS);

        player.getCardRepository()
                .getCards()
                .forEach(c -> {
                    c.setDamagePoints(c.getDamagePoints() + CARD_DAMAGE_BONUS);
                });
    }
}
