package vehicles_extension;

public abstract class Vehicle{
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelConsumption(fuelConsumption);
        this.setFuelQuantity(fuelQuantity);
    }

    private void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity < 0 ) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public Double getTankCapacity() {
        return this.tankCapacity;
    }

    public abstract boolean isValidDistance(Double distance);

    public abstract void drive(Double distance);

    public abstract void refuel(Double fuelAmount);
}
