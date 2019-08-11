package viceCity.models.players;

public class CivilPlayer extends BasePlayer {
    private static final int DEFAULT_CIVIL_HEALTH = 50;

    public CivilPlayer(String name) {
        super(name, DEFAULT_CIVIL_HEALTH);
    }

    @Override
    public boolean isAlive() {
        //TODO?
        return false;
    }
}
