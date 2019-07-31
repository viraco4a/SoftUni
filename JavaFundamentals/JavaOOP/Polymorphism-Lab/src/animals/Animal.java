package animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return this.name;
    }

    protected String getFavouriteFood() {
        return this.favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n",
                this.getName(), this.getFavouriteFood());
    }
}
