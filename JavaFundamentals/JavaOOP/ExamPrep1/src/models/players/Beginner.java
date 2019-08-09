package models.players;

import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int BEGINNER_DEFAULT_HEALTH_POINTS = 50;

    protected Beginner(CardRepository cardRepository, String username) {
        super(cardRepository, username, BEGINNER_DEFAULT_HEALTH_POINTS);
    }
}
