package Vehicles.models;

import Vehicles.contracts.Mobile;

import java.text.DecimalFormat;

public abstract class Vehicle implements Mobile {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption += fuelConsumption;
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double fuelToBurn = distance * this.getFuelConsumption();
        if (fuelToBurn > this.getFuelQuantity()){
            throw new IllegalArgumentException(String.format(
                    "%s needs refueling",
                    this.getClass().getSimpleName()
            ));
        }

        this.setFuelQuantity(-fuelToBurn);
        return String.format(
                "%s travelled %s km",
                this.getClass().getSimpleName(),
                new DecimalFormat("#.#############").format(distance)
        );
    }

    @Override
    public String toString() {
        return String.format(": %.2f", this.fuelQuantity);
    }
}
