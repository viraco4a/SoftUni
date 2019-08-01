package vehicles_extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private static final Double AC_FUEL_INCREASE_BUS = 1.4;

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public boolean isValidDistance(Double distance) {
        return distance <= this.getFuelQuantity() / (this.getFuelConsumption() + AC_FUEL_INCREASE_BUS);
    }

    @Override
    public void drive(Double distance) {
        if (isValidDistance(distance)) {
            DecimalFormat format = new DecimalFormat("#.##");
            Double consumption = this.getFuelConsumption() + AC_FUEL_INCREASE_BUS;
            Double fuel = this.getFuelQuantity() - distance * consumption;
            this.setFuelQuantity(fuel);
            System.out.println(String.format("Bus travelled %s km", format.format(distance)));
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    public void driveEmpty(Double distance) {
        if (isValidDistance(distance)) {
            DecimalFormat format = new DecimalFormat("#.##");
            Double consumption = this.getFuelConsumption();
            Double fuel = this.getFuelQuantity() - distance * consumption;
            this.setFuelQuantity(fuel);
            System.out.println(String.format("Bus travelled %s km", format.format(distance)));
        } else {
            System.out.println("Bus needs refueling");
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
