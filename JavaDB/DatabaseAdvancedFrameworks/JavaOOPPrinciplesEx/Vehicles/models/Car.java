package Vehicles.models;

public class Car extends Vehicle {
    private static final double AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.setFuelConsumption(AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters);
    }

    @Override
    public String toString() {
        return "Car" + super.toString();
    }
}
