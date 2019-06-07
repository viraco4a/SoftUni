package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static final int BADGE_INCREASE = 1;

    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public void updateBadges() {
        this.badges += BADGE_INCREASE;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void damagePokemons() {
        for (int i = 0; i < this.pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            pokemon.takeDamage();
            if (!pokemon.isAlive) {
                pokemons.remove(pokemon);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                this.getName(),
                this.getBadges(),
                this.getPokemons().size());
    }
}
