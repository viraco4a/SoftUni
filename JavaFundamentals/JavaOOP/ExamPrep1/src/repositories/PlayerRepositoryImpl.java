package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static common.ConstantMessages.PLAYER_IS_NULL;

public class PlayerRepositoryImpl implements PlayerRepository {

    private Map<String, Player> players;

    public PlayerRepositoryImpl() {
        this.players = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(PLAYER_IS_NULL);
        }
        if (this.players.containsKey(player.getUsername())) {
            throw new IllegalArgumentException(String.format(
                    "Player %s already exists!",
                    player.getUsername()
            ));
        }
        this.players.put(player.getUsername(), player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(PLAYER_IS_NULL);
        }
        if (players.containsKey(player.getUsername())) {
            this.players.remove(player.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public Player find(String name) {
        return this.players.get(name);
    }
}
