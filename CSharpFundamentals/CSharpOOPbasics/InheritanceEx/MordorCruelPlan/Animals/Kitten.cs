﻿using System;

namespace Animals
{
    public class Kitten : Cat
    {
        public Kitten(string name, int age, string gender)
            : base(name, age, gender)
        {
            this.Gender = "Female";
        }

        public override void ProduceSound()
        {
            Console.WriteLine("Meow");
        }
    }
}
