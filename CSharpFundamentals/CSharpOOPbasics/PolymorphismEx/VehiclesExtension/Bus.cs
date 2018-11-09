namespace Vehicles
{
    public class Bus : Vehicle
    {
        private const double A_C_CONSUMPTION_CAR_FULL = 1.4;
        private const double A_C_CONSUMPTION_CAR_EMPTY = 0;
        public bool IsEmpty { get; set; }

        public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity)
            : base(fuelQuantity, fuelConsumption, tankCapacity)
        {
        }

        public override void Drive(double distance)
        {
            if (IsEmpty)
            {
                this.FuelConsumption += A_C_CONSUMPTION_CAR_EMPTY;
                base.Drive(distance);
                this.FuelConsumption -= A_C_CONSUMPTION_CAR_EMPTY;
            }
            else
            {
                this.FuelConsumption += A_C_CONSUMPTION_CAR_FULL;
                base.Drive(distance);
                this.FuelConsumption -= A_C_CONSUMPTION_CAR_FULL;
            }
        }
    }
}
