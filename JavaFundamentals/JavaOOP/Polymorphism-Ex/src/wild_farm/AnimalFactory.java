package wild_farm;

public class AnimalFactory {
    public Animal getAnimal (String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        Double weight = Double.valueOf(tokens[2]);
        String livingRegion = tokens[3];
        switch (type) {
            case "Cat":
                String breed = tokens[4];
                return new Cat(name, type, weight, 0, livingRegion, breed);
            case "Tiger":
                return new Tiger(name, type, weight, 0, livingRegion);
            case "Zebra":
                return new Zebra(name, type, weight, 0, livingRegion);
            case "Mouse":
                return new Mouse(name, type, weight, 0, livingRegion);
        }

        return null;
    }
}
