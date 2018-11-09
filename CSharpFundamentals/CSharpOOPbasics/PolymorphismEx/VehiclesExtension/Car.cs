namespace Vehicles
{
    public class Car : Vehicle
    {
        private const double A_C_CONSUMPTION_CAR = 0.9;

        public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) 
            : base(fuelQuantity, fuelConsumption, tankCapacity)
        {
            base.FuelConsumption += A_C_CONSUMPTION_CAR;
        }
    }
}
