package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, Trainer> trainers = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while (!"Tournament".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            trainers.get(trainerName).addPokemon(pokemon);
        }

        while (!"End".equals(line = reader.readLine())) {
            switch (line) {
                case "Fire":
                    checkForElement("Fire");
                    break;
                case "Water":
                    checkForElement("Water");
                    break;
                case "Electricity":
                    checkForElement("Electricity");
                    break;
            }
        }

        trainers.values().stream()
                .sorted((t1, t2) -> t2.getBadges() - t1.getBadges())
                .forEach(t -> System.out.println(t.toString()));
    }

    private static void checkForElement(String element) {
        for (Trainer trainer : trainers.values()) {
            if (!hasIt(element, trainer)) {
                trainer.damagePokemons();
            } else {
                trainer.updateBadges();
            }
        }
    }

    private static boolean hasIt(String element, Trainer trainer) {
        boolean hasIt = false;
        for (Pokemon pokemon : trainer.getPokemons()) {
            if (pokemon.getElement().equals(element)) {
                hasIt = true;
                break;
            }
        }
        return hasIt;
    }
}
