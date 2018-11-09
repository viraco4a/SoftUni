using System;

namespace Vehicles
{
    public abstract class Vehicle
    {
        public double FuelQuantity { get; private set; }
        public double FuelConsumption { get; set; }

        public Vehicle(double fuelQuantity, double fuelConsumption)
        {
            FuelQuantity = fuelQuantity;
            FuelConsumption = fuelConsumption;
        }

        public void Drive(double distance)
        {
            if (distance * FuelConsumption <= FuelQuantity)
            {
                Console.WriteLine($"{this.GetType().Name} travelled {distance} km");
                FuelQuantity -= distance * FuelConsumption;
            }
            else
            {
                Console.WriteLine($"{this.GetType().Name} needs refueling");
            }
        }
        public virtual void Refuel(double fuel)
        {
            this.FuelQuantity += fuel;
        }
    }
}
