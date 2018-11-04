using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace PizzaCalories
{
    public class Pizza
    {
        private string name;
        private Dough dough;
        private List<Topping> toppings;

        public Pizza(string name)
        {
            this.Name = name;
            toppings = new List<Topping>();
        }

        private List<Topping> Toppings
        {
            get { return toppings; }
            set { this.toppings = value; }
        }

        public Dough Dough
        {
            get { return dough; }
            set { this.dough = value; }
        }

        public string Name
        {
            get { return name; }
            private set
            {
                if (string.IsNullOrEmpty(value) || value.Length > 15)
                {
                    throw new ArgumentException("Pizza name should be between 1 and 15 symbols.");
                }
                name = value;
            }
        }

        public void AddTopping(Topping topping)
        {
            if (this.toppings.Count > 10)
            {
                throw new ArgumentException("Number of toppings should be in range [0..10].");
            }
            Toppings.Add(topping);
        }

        public override string ToString()
        {
            double calories = this.Dough.Calories();
            calories += this.Toppings.Sum(s => s.Calories());
            return $"{this.Name} - {calories:F2} Calories.";
        }
    }
}
