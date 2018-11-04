using System;

namespace PizzaCalories
{
    public class Topping
    {
        private const double MEAT = 1.2;
        private const double VEGGIES = 0.8;
        private const double CHEESE = 1.1;
        private const double SAUCE = 0.9;

        private string type;
        private int weight;

        public Topping(string type, int weight)
        {
            this.Type = type;
            this.Weight = weight;
        }

        private int Weight
        {
            get { return weight; }
            set
            {
                if (value < 1 || value > 50)
                {
                    throw new ArgumentException($"{this.Type} weight should be in the range [1..50].");
                }
                weight = value;
            }
        }

        private string Type
        {
            get { return type; }
            set
            {
                if (value.ToLower() != "meat" && 
                    value.ToLower() != "veggies" &&
                    value.ToLower() != "cheese" &&
                    value.ToLower() != "sauce")
                {
                    throw new ArgumentException($"Cannot place {value} on top of your pizza.");
                }
                type = value;
            }
        }

        public double Calories()
        {
            double mod = 0;
            switch (this.Type.ToLower())
            {
                case "meat": mod = MEAT; break;
                case "veggies": mod = VEGGIES; break;
                case "cheese": mod = CHEESE; break;
                case "sauce": mod = SAUCE; break;
            }

            return 2 * this.Weight * mod;
        }
    }
}
