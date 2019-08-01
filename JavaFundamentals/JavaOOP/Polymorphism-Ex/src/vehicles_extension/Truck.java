package vehicles_extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final Double AC_FUEL_INCREASE_TRUCK = 1.6;
    private static final Double TRUCK_REFUEL_COEFFICIENT = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public boolean isValidDistance(Double distance) {
        return distance <= this.getFuelQuantity() / (this.getFuelConsumption() + AC_FUEL_INCREASE_TRUCK);
    }

    @Override
    public void drive(Double distance) {
        if (isValidDistance(distance)) {
            DecimalFormat format = new DecimalFormat("#.##");
            Double consumption = this.getFuelConsumption() + AC_FUEL_INCREASE_TRUCK;
            Double fuel = this.getFuelQuantity() - distance * consumption;
            this.setFuelQuantity(fuel);
            System.out.println(String.format("Truck travelled %s km", format.format(distance)));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(Double fuelAmount) {
        if (fuelAmount <= 0 ) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuelAmount * TRUCK_REFUEL_COEFFICIENT);
    }
}
