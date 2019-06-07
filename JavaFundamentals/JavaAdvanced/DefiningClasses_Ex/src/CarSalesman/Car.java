package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight = -1;
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getModel())
                .append(":")
                .append(System.lineSeparator());
        sb.append(this.getEngine().getModel())
                .append(":")
                .append(System.lineSeparator());
        sb.append("Power: ")
                .append(this.getEngine().getPower())
                .append(System.lineSeparator());
        sb.append("Displacement: ")
                .append(this.getEngine().getDisplacement() == -1
                        ? "n/a"
                        : this.getEngine().getDisplacement())
                .append(System.lineSeparator());
        sb.append("Efficiency: ")
                .append(this.getEngine().getEfficiency())
                .append(System.lineSeparator());
        sb.append("Weight: ")
                .append(this.getWeight() == -1
                        ? "n/a"
                        : this.getWeight())
                .append(System.lineSeparator());
        sb.append("Color: ")
                .append(this.getColor());

        return sb.toString();
    }
}