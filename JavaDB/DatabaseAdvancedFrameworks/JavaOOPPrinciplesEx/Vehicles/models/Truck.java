package Vehicles.models;

public class Truck extends Vehicle {
    private static final double AC_CONSUMPTION = 1.6;
    private static final double TANK_HOLE_EFFECT = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.setFuelConsumption(AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters * TANK_HOLE_EFFECT);
    }

    @Override
    public String toString() {
        return "Truck" + super.toString();
    }
}
