package Vehicles.contracts;

public interface Mobile {
    double getFuelQuantity();
    double getFuelConsumption();
    String drive(double distance);
    void refuel(double liters);
}
