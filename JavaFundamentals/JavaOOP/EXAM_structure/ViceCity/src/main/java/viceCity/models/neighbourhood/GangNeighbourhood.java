package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        boolean aliveCivils = false;
        for (Player civilPlayer : civilPlayers) {
            playerAttacks(mainPlayer, civilPlayer);
            if (civilPlayer.isAlive()) {
                aliveCivils = true;
                break;
            }
        }
        if (!aliveCivils) {
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
            if (gun.canFire()) {
                int damage = gun.fire();
                defendingPlayer.takeLifePoints(damage);
                if (!defendingPlayer.isAlive()) {
                    return;
                }
            }
        }
    }
}
