using System;

namespace FoodShortage
{
    public class Citizen : ITraceble, IBreedable, IBuyer
    {
        private const int FOOD = 10;
        private string name;
        public int Age { get; private set; }
        public string Id { get; private set; }
        public string Birthday { get; private set; }
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

        public Citizen(string name, int age, string id, string birthday)
        {
            Name = name;
            Age = age;
            Id = id;
            Birthday = birthday;
        }

        public void BuyFood()
        {
            this.Food += FOOD;
        }
    }
}
