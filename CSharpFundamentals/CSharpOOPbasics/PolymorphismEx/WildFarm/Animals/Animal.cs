using WildFarm.Animals.Contracts;
using WildFarm.Foods;

namespace WildFarm.Animals
{
    public abstract class Animal : IAnimal
    {
        private string name;
        private int foodEaten;
        private double weight;

        public Animal(string name, double weight)
        {
            this.Name = name;
            this.Weight = weight;
        }

        public double Weight
        {
            get { return weight; }
            set { weight = value; }
        }

        public int FoodEaten
        {
            get { return foodEaten; }
            set { foodEaten = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public abstract void ProduceSound();

        public abstract void Eat(Food food);
    }
}
