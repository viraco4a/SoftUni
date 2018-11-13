﻿using System;

namespace WildFarm.Animals.Mammals.Factory
{
    public class MamalFactory
    {
        public Mammal CreateMamal(string type, string name, double weight,
            string livingRegion)
        {
            type = type.ToLower();

            switch (type)
            {
                case "mouse":
                    return new Mouse(name, weight, livingRegion);
                case "dog":
                    return new Dog(name, weight, livingRegion);
                default:
                    return null;
            }
        }
    }
}
