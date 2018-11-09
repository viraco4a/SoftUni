namespace Vehicles
{
    public class Truck : Vehicle
    {
        private const double REFUEL_PERCENTAGE = 0.95;
        private const double A_C_CONSUMPTION_TRUCK = 1.6;

        public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) 
            : base(fuelQuantity, fuelConsumption, tankCapacity)
        {
            base.FuelConsumption += A_C_CONSUMPTION_TRUCK;
        }

        public override void Refuel(double fuel)
        {
            base.Refuel(fuel * REFUEL_PERCENTAGE);
        }
    }
}
