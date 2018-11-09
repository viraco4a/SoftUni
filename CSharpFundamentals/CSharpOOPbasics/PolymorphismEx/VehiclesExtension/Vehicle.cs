using System;

namespace Vehicles
{
    public abstract class Vehicle
    {
        public double FuelConsumption { get; set; }
        public double TankCapacity { get; private set; }
        private double fuelQuantity;

        public double FuelQuantity
        {
            get { return fuelQuantity; }
            set
            {
                if (value > TankCapacity)
                {
                    throw new ArgumentException($"Cannot fit {value} fuel in the tank");
                }
                else if (value <= 0)
                {
                    throw new ArgumentException("Fuel must be a positive number");
                }
                fuelQuantity = value;
            }
        }

        public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity)
        {
            TankCapacity = tankCapacity;
            FuelConsumption = fuelConsumption;
            if (tankCapacity < fuelQuantity)
            {
                fuelQuantity = 0;
            }
        }

        public virtual void Drive(double distance)
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
