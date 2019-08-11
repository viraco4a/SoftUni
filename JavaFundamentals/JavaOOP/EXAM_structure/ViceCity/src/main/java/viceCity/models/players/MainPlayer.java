package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";
    private static final int MAIN_PLAYER_HEALTH = 100;

    public MainPlayer() {
        super(MAIN_PLAYER_NAME, MAIN_PLAYER_HEALTH);
    }

    @Override
    public boolean isAlive() {
        return super.getLifePoints() > 0;
    }
}
