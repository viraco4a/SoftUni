package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER = "Vercetti";

    private Player mainPlayer;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        if (!this.civilPlayers.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        Player player = new CivilPlayer(name);
        this.civilPlayers.put(name, player);
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
        if (!this.civilPlayers.containsKey(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Player player = this.civilPlayers.get(name);
        player.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        return null;
    }
}
