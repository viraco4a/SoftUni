using System;
using WildFarm.Animals.Mammals.Felines;
using WildFarm.Foods;

namespace WildFarm.Animals.Felines
{
    public class Cat : Feline
    {
        private const double BODY_COEFFICIENT = 0.30;

        public Cat(string name, double weight, string livingRegion, string breed) 
            : base(name, weight, livingRegion, breed)
        {
        }

        public override void Eat(Food food)
        {
            if (food is Vegetable || food is Meat)
            {
                this.Weight += food.Quantity * BODY_COEFFICIENT;
            }
            else
            {
                throw new AggregateException(
                    $"{this.GetType().Name} does not eat {food.GetType().Name}!");
            }
        }

        public override void ProduceSound()
        {
            Console.WriteLine("Meow");
        }
    }
}
