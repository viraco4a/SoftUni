package vehicles;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public abstract void drive(Double distance);

    public abstract void refuel(Double fuelAmount);
}
