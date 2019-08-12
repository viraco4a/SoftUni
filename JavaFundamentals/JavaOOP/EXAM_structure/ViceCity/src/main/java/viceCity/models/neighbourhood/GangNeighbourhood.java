package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        boolean mainPlayerOutOfBullets = false;
        for (Player civilPlayer : civilPlayers) {
            playerAttacks(mainPlayer, civilPlayer);
            if (civilPlayer.isAlive()) {
                mainPlayerOutOfBullets = true;
                break;
            }
        }
        civilPlayers = civilPlayers
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toCollection(TreeSet::new));
        if (!mainPlayerOutOfBullets) {
            return;
        }
        for (Player civilPlayer : civilPlayers) {
            playerAttacks(civilPlayer, mainPlayer);
            if (!mainPlayer.isAlive()) {
                return;
            }
        }
    }

    private void playerAttacks(Player attackingPlayer, Player defendingPlayer) {
        for (Gun gun : attackingPlayer.getGunRepository().getModels()) {
            while (true) {
                if (gun.canFire()) {
                    int damage = gun.fire();
                    defendingPlayer.takeLifePoints(damage);
                    if (!defendingPlayer.isAlive()) {
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
