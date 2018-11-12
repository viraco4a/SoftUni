using System;
using WildFarm.Animals.Mammals.Felines;
using WildFarm.Foods;

namespace WildFarm.Animals.Felines
{
    public class Tiger : Feline
    {
        private const double BODY_COEFFICIENT = 1.00;

        public Tiger(string name, double weight, string livingRegion, string breed)
            : base(name, weight, livingRegion, breed)
        {
        }

        public override void Eat(Food food)
        {
            if (food is Meat)
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
            Console.WriteLine("ROAR!!!");
        }
    }
}
