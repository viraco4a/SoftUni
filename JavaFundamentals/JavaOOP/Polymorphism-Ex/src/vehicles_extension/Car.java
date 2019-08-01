package vehicles_extension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final Double AC_FUEL_INCREASE_CAR = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public boolean isValidDistance(Double distance) {
        return distance <= this.getFuelQuantity() / (this.getFuelConsumption() + AC_FUEL_INCREASE_CAR);
    }

    @Override
    public void drive(Double distance) {
        if (isValidDistance(distance)) {
            DecimalFormat format = new DecimalFormat("#.##");
            Double consumption = this.getFuelConsumption() + AC_FUEL_INCREASE_CAR;
            Double fuel = this.getFuelQuantity() -  distance * consumption;
            this.setFuelQuantity(fuel);
            System.out.println(String.format("Car travelled %s km", format.format(distance)));
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(Double fuelAmount) {
        if (fuelAmount <= 0 ) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuelAmount);
    }
}
