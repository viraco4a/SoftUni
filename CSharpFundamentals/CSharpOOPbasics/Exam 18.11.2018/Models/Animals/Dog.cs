﻿namespace AnimalCentre.Models
{
    public class Dog : Animal
    {
        public Dog(string name, int energy, int happiness, int procedureTime)
            : base(name, energy, happiness, procedureTime) { }

        public override string ToString()
        {
            string local = $"    Animal type: {this.GetType().Name} ";
            return local + base.ToString();
        }
    }
}
