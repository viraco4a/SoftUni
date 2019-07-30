package pizza_calories;

public class Dough extends PartOfPizza {
    private FlourType flourType;
    private BakingTechnique bakingTechnique;

    public Dough(String flourType, String bakingTechnique, double weight) {
        super(weight);
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
    }

    private void setFlourType(String flourType) {
        if (!isValidFlourType(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = FlourType.valueOf(flourType);
    }

    private boolean isValidFlourType(String flourType) {
        for (FlourType value : FlourType.values()) {
            if (value.name().equals(flourType)) {
                return true;
            }
        }
        return false;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!isValidBakingTechnique(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique);
    }

    private boolean isValidBakingTechnique(String bakingTechnique) {
        for (BakingTechnique value : BakingTechnique.values()) {
            if (value.name().equals(bakingTechnique)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateCalories() {
        return CALORY_MODIFIER * this.getWeight() * this.flourType.getCalories() * this.bakingTechnique.getCalories();
    }
}
