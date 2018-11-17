using StorageMaster.Models.Vehicles;
using System.Collections.Generic;

namespace StorageMaster.Models.Storage
{
    public class DistributionCenter : Storage
    {
        private const int CAPACITY = 2;
        private const int GARAGE_SLOTS = 5;
        private static IEnumerable<Vehicle> DEFAULT_VEHICLES = new Vehicle[]
        {
            new Van(),
            new Van(),
            new Van()
        };

        public DistributionCenter(string name)
            : base(name, CAPACITY, GARAGE_SLOTS, DEFAULT_VEHICLES) { }
    }
}
