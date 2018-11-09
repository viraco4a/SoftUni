namespace Vehicles
{
    public class Car : Vehicle
    {
        private const double A_C_CONSUMPTION_CAR = 0.9;

        public Car(double fuelQuantity, double fuelConsumption) 
            : base(fuelQuantity, fuelConsumption)
        {
            base.FuelConsumption += A_C_CONSUMPTION_CAR;
        }
    }
}
