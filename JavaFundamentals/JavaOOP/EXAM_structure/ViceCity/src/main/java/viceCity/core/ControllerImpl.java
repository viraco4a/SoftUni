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
    private static final int MAIN_PLAYER_DEFAULT_HEALTH = 100;
    private static final int CIVIL_DEFAULT_HEALTH = 50;

    private Player mainPlayer;
    private Set<Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;
    private int civilPlayersCounter;

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
        this.civilPlayersCounter++;
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
        boolean mainPlayerUnharmed = this.mainPlayer.getLifePoints() == MAIN_PLAYER_DEFAULT_HEALTH;
        boolean civilPlayersUnharmed = checkCivilPlayersUnharmed();
        if (mainPlayerUnharmed && civilPlayersUnharmed) {
            return FIGHT_HOT_HAPPENED;
        } else {
            this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
            int deadCivilPlayers = this.civilPlayersCounter - this.civilPlayers.size();
            int mainPlayerLifePoints = this.mainPlayer.getLifePoints();
            int leftCivilPlayers = this.civilPlayers.size();
            StringBuilder sb = new StringBuilder();
            sb
                    .append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,
                            mainPlayerLifePoints))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,
                            deadCivilPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,
                            leftCivilPlayers))
                    .append(System.lineSeparator());
            return sb.toString();
        }
    }

    private boolean checkCivilPlayersUnharmed() {
        if (this.civilPlayers.size() < civilPlayersCounter) {
            return false;
        }
        for (Player civilPlayer : this.civilPlayers) {
            if (civilPlayer.getLifePoints() < CIVIL_DEFAULT_HEALTH) {
                return false;
            }
        }
        return true;
    }
}
