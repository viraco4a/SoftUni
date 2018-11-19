using StorageMaster.Models.Vehicles;

namespace StorageMaster.Models.Storages
{
    public class AutomatedWarehouse : Storage
    {
        private const int CAPACITY = 1;
        private const int GARAGE_SLOTS = 2;
        private static Vehicle[] DEFAULT_VEHICLES = new Vehicle[]
        {
            new Truck()
        };

        public AutomatedWarehouse(string name)
            : base(name, CAPACITY, GARAGE_SLOTS, DEFAULT_VEHICLES) { }
    }
}
