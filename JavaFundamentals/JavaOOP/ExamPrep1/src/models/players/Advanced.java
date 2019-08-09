package models.players;

import repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {
    private static final int ADVANCED_DEFAULT_HEALTH_POINTS = 250;

    protected Advanced(CardRepository cardRepository, String username) {
        super(cardRepository, username, ADVANCED_DEFAULT_HEALTH_POINTS);
    }
}
