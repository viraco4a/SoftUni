package Ferrari.models;

import Ferrari.constants.Constants;
import Ferrari.contracts.Car;

public class AbstractCar implements Car {
    private String model;
    private String driver;

    public AbstractCar(String model, String driver) {
        this.model = model;
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String brake() {
        return Constants.USING_BRAKES;
    }

    @Override
    public String gas() {
        return Constants.USING_GAS;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model, this.brake(), this.gas(), this.driver);
    }
}
