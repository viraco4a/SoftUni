using System;
using System.Collections.Generic;
using System.Text;

namespace SpeedRacing
{
    public class Car
    {
        private string model;
        private double fuelAmount;
        private double fuelConsumption;
        private int traveledDistance;

        public Car(string model, double fuelAmount, double fuelConsumption, int traveledDistance)
        {
            this.Model = model;
            this.FuelAmount = fuelAmount;
            this.FuelConsumption = fuelConsumption;
            this.TraveledDistance = traveledDistance;
        }

        public int TraveledDistance
        {
            get { return traveledDistance; }
            set { traveledDistance = value; }
        }

        public double FuelConsumption
        {
            get { return fuelConsumption; }
            set { fuelConsumption = value; }
        }

        public double FuelAmount
        {
            get { return fuelAmount; }
            set { fuelAmount = value; }
        }

        public string Model
        {
            get { return model; }
            set { model = value; }
        }

        public bool CanMove(int amountOfKm)
        {
            return amountOfKm * (this.FuelConsumption) <= this.FuelAmount;
        }
    }
}
