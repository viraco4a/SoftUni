package PokemonTrainer;

public class Pokemon {
    private static final int DAMAGE = 10;

    private String name;
    private String element;
    private int health;
    public boolean isAlive;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
        this.isAlive = true;
    }

    public void takeDamage () {
        this.health -= DAMAGE;
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }
}
