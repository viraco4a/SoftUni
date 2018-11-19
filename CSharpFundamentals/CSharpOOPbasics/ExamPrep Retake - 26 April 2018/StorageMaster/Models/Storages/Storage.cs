using StorageMaster.Models.Products;
using StorageMaster.Models.Vehicles;
using System;
using System.Collections.Generic;
using System.Linq;

namespace StorageMaster.Models.Storages
{
    public abstract class Storage
    {
        private List<Product> products;
        private Vehicle[] garage;

        public string Name { get; private set; }
        public int Capacity { get; private set; }
        public int GarageSlots { get; private set; }


        protected Storage(string name, int capacity, int garageSlots, IEnumerable<Vehicle> vehicles)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.GarageSlots = garageSlots;
            this.products = new List<Product>();
            this.garage = new Vehicle[this.GarageSlots];
            this.FillGarageWithInitialVehicles(vehicles);
        }

        public IReadOnlyCollection<Product> Products => this.products.AsReadOnly();
        public IReadOnlyCollection<Vehicle> Garage => Array.AsReadOnly(this.garage);
        public bool IsFull => this.Products.Sum(s => s.Weight) >= this.Capacity;

        public Vehicle GetVehicle(int garageSlot)
        {
            if (garageSlot >= this.GarageSlots)
            {
                throw new InvalidOperationException("Invalid garage slot!");
            }

            Vehicle vehicle = this.garage[garageSlot];
            if (vehicle == null)
            {
                throw new InvalidOperationException("No vehicle in this garage slot!");
            }

            return vehicle;
        }

        public int SendVehicleTo(int garageSlot, Storage deliveryLocation)
        {
            Vehicle vehicle = this.GetVehicle(garageSlot);

            int index = deliveryLocation.AddVehicleToGarage(vehicle);

            this.garage[garageSlot] = null;

            return index;
        }

        public int UnloadVehicle(int garageSlot)
        {
            if (this.IsFull)
            {
                throw new InvalidOperationException("Storage is full!");
            }

            Vehicle vehicle = this.GetVehicle(garageSlot);

            int unloadedProducts = 0;
            while (!this.IsFull && !vehicle.IsEmpty)
            {
                this.products.Add(vehicle.Unload());
                unloadedProducts++;
            }

            return unloadedProducts;
        }

        private int AddVehicleToGarage(Vehicle vehicle)
        {
            int freeGarageSlotIndex = Array.IndexOf(this.garage, null);

            if (freeGarageSlotIndex == -1)
            {
                throw new InvalidOperationException("No room in garage!");
            }

            this.garage[freeGarageSlotIndex] = vehicle;

            return freeGarageSlotIndex;
        }

        private void FillGarageWithInitialVehicles(IEnumerable<Vehicle> vehicles)
        {
            int index = 0;
            foreach (Vehicle vehicle in vehicles)
            {
                this.garage[index] = vehicle;
                index++;
            }
        }
    }
}
