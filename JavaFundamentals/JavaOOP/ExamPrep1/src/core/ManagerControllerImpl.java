package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import java.awt.desktop.QuitStrategy;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private static final String MAGIC_TYPE_CARD = "Magic";
    private static final String TRAP_TYPE_CARD = "Trap";

    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        if (type.equals(Beginner.class.getSimpleName())) {
            player = new Beginner(new CardRepositoryImpl(), username);
       } else if (type.equals(Advanced.class.getSimpleName())) {
            player = new Advanced(new CardRepositoryImpl(), username);
       }
        this.playerRepository.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        if (MAGIC_TYPE_CARD.equals(type)) {
            card = new MagicCard(name);
        } else if (TRAP_TYPE_CARD.equals(type)) {
            card = new TrapCard(name);
        }

        this.cardRepository.add(card);
        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(username);
        Player player = this.playerRepository.find(username);

        player.getCardRepository().add(card);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);
        this.battlefield.fight(attacker, enemy);
        return String.format(FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this.playerRepository.getPlayers()
                .forEach(sb::append);
        return sb.toString().trim();
    }
}
