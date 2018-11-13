﻿using System;
using WildFarm.Foods;

namespace WildFarm.Animals.Mammals
{
    public class Mouse : Mammal
    {
        private const double BODY_COEFFICIENT = 0.10;

        public Mouse(string name, double weight, string livingRegion)
            : base(name, weight, livingRegion)
        {
        }

        public override void Eat(Food food)
        {
            if (food is Vegetable || food is Fruit)
            {
                this.Weight += food.Quantity * BODY_COEFFICIENT;
                this.FoodEaten += food.Quantity;
            }
            else
            {
                Console.WriteLine(
                    $"{this.GetType().Name} does not eat {food.GetType().Name}!");
            }
        }

        public override void ProduceSound()
        {
            Console.WriteLine("Squeak");
        }

        public override string ToString()
        {
            return base.ToString() +
                $"{this.Weight}, {this.LivingRegion}, {this.FoodEaten}]";
        }
    }
}
