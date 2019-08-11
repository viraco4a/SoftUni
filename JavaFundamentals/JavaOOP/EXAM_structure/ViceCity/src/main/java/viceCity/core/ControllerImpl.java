package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER = "Vercetti";

    private Player mainPlayer;
    private Set<Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashSet<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        try {
            Class klass = Class.forName("viceCity.models.guns." + type);
            Constructor constructor = klass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);

            Gun gun = (Gun) constructor.newInstance(name);

            this.guns.offer(gun);
            return String.format(GUN_ADDED, name, type);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return GUN_TYPE_INVALID;
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = this.guns.poll();
        if (MAIN_PLAYER.equals(name)) {
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), MAIN_PLAYER);
        }
        if (!civilPlayerExists(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Player player = getCivilPlayer(name);
        player.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    private Player getCivilPlayer(String name) {
        for (Player civilPlayer : this.civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                return civilPlayer;
            }
        }
        return null;
    }

    private boolean civilPlayerExists(String name) {
        for (Player civilPlayer : this.civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String fight() {
        return null;
    }
}
