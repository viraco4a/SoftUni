package Vehicles.contracts;

public interface Mobile {
    double getFuelQuantity();
    double getFuelConsumption();
    void drive(double distance);
    void refuel(double liters);
}
