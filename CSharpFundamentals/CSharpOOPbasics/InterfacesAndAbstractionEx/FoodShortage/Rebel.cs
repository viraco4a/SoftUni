using System;

namespace FoodShortage
{
    public class Rebel : IBuyer
    {
        private const int FOOD = 5;
        private string name;

        public Rebel(string name, int age, string group)
        {
            Name = name;
            Age = age;
            Group = group;
        }

        public int Age { get; private set; }
        public string Group { get; set; }
        public int Food { get; private set; }

        public string Name
        {
            get { return name; }
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException();
                }
                name = value;
            }
        }

        public void BuyFood()
        {
            this.Food += FOOD;
        }
    }
}
