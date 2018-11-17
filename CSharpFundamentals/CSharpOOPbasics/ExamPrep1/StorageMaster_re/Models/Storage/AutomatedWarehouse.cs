using StorageMaster.Models.Vehicles;
using System.Collections.Generic;

namespace StorageMaster.Models.Storage
{
    public class AutomatedWarehouse : Storage
    {
        private const int CAPACITY = 1;
        private const int GARAGE_SLOTS = 2;
        private static IEnumerable<Vehicle> DEFAULT_VEHICLES = new Vehicle[]
        {
            new Truck()
        };

        public AutomatedWarehouse(string name)
            : base(name, CAPACITY, GARAGE_SLOTS, DEFAULT_VEHICLES) { }
    }
}
