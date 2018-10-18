﻿using System;
using System.Collections.Generic;
using System.Text;

namespace Google
{
    public class Car
    {
        private string model;
        private double speed;

        public Car(string model, double speed)
        {
            this.Model = model;
            this.Speed = speed;
        }

        public double Speed
        {
            get { return speed; }
            set { speed = value; }
        }

        public string Model
        {
            get { return model; }
            set { model = value; }
        }

        public override string ToString()
        {
            return $"Car:\n{this.Model} {this.speed}";
        }
    }
}
