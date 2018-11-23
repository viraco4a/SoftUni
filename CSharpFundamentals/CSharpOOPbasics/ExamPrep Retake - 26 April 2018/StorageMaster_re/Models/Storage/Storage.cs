﻿using StorageMaster.Models.Products;
using StorageMaster.Models.Vehicles;
using System;
using System.Collections.Generic;
using System.Linq;

namespace StorageMaster.Models.Storage
{
    public abstract class Storage
    {
        public string Name { get; private set; }
        public int Capacity { get; private set; }
        public int GarageSlots { get; private set; }
        private Vehicle[] garage;
        private List<Product> products;

        protected Storage(string name, int capacity, int garageSlots, IEnumerable<Vehicle> vehicles)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.GarageSlots = garageSlots;
            this.garage = new Vehicle[this.GarageSlots];
            this.products = new List<Product>();
            ConstructVehicle(vehicles);
        }

        public bool IsFull => this.Products.Sum(s => s.Weight) >= this.Capacity;

        public IReadOnlyCollection<Product> Products => this.products.AsReadOnly();
        public IReadOnlyCollection<Vehicle> Garage => Array.AsReadOnly(this.garage);

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

            int index = deliveryLocation.PutVehicle(vehicle);

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

            int unloadedProductsCount = 0;

            while (!this.IsFull && !vehicle.IsEmpty)
            {
                Product product = vehicle.Unload();
                this.products.Add(product);
                unloadedProductsCount++;
            }

            return unloadedProductsCount;
        }

        private int PutVehicle(Vehicle vehicle)
        {
            int index = Array.IndexOf(this.garage, null);

            if (index == -1)
            {
                throw new InvalidOperationException("No room in garage!");
            }

            this.garage[index] = vehicle;

            return index;
        }

        private void ConstructVehicle(IEnumerable<Vehicle> vehicles)
        {
            int index = 0;
            foreach (Vehicle vehicle in vehicles)
            {
                this.garage[index++] = vehicle;
            }
        }
    }
}