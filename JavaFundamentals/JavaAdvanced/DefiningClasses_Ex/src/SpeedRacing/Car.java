package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private double distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    private boolean canMove(double distance) {
        return this.getFuelAmount() / this.getFuelConsumption() >= distance;
    }

    public void move(double distance) {
        if (this.canMove(distance)) {
            this.fuelAmount -= distance * this.getFuelConsumption();
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f",
                this.getModel(),
                this.getFuelAmount(),
                this.getDistanceTraveled());
    }
}
