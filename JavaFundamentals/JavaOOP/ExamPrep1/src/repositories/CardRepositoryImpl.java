package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static common.ConstantMessages.CARD_IS_NULL;

public class CardRepositoryImpl implements CardRepository {
    private Map<String, Card> cards;

    public CardRepositoryImpl() {
        this.cards =  new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException(CARD_IS_NULL);
        }
        if (this.cards.containsKey(card.getName())) {
            throw new IllegalArgumentException(String.format(
                    "Card %s already exists!",
                    card.getName()
            ));
        }
        this.cards.put(card.getName(), card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException(CARD_IS_NULL);
        }
        if (cards.containsKey(card.getName())) {
            this.cards.remove(card.getName());
            return true;
        }
        return false;
    }

    @Override
    public Card find(String name) {
        return this.cards.get(name);
    }
}
