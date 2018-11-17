﻿using StorageMaster.Models.Vehicles;
using System.Collections.Generic;

namespace StorageMaster.Models.Storage
{
    public class Warehouse : Storage
    {
        private const int CAPACITY = 10;
        private const int GARAGE_SLOTS = 10;
        private static IEnumerable<Vehicle> DEFAULT_VEHICLES = new Vehicle[]
        {
            new Semi(),
            new Semi(),
            new Semi()
        };

        public Warehouse(string name)
            : base(name, CAPACITY, GARAGE_SLOTS, DEFAULT_VEHICLES) { }
    }
}
