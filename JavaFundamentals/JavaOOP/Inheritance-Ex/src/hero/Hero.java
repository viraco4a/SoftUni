package hero;

public class Hero {
    private String username;
    private int level;

    protected Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());

    }
}
