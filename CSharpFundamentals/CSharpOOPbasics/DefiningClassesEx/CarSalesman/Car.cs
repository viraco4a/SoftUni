using System;
using System.Collections.Generic;
using System.Text;

namespace CarSalesman
{
    public class Car
    {
        private string model;
        private Engine engine;
        private string weight;
        private string color;

        public Car(string model, Engine engine)
        {
            this.Model = model;
            this.Engine = engine;
            this.Weight = "n/a";
            this.Color = "n/a";
        }

        public string Color
        {
            get { return color; }
            set { color = value; }
        }

        public string Weight
        {
            get { return weight; }
            set { weight = value; }
        }

        public Engine Engine
        {
            get { return engine; }
            set { engine = value; }
        }

        public string Model
        {
            get { return model; }
            set { model = value; }
        }

        public override string ToString()
        {
            return $"{this.Model}:\n" +
                   $"  {this.Engine.Model}:\n" +
                   $"    Power: {this.Engine.Power}\n" +
                   $"    Displacement: {this.Engine.Displacement}\n" +
                   $"    Efficiency: {this.Engine.Efficiency}\n" +
                   $"  Weight: {this.Weight}\n" +
                   $"  Color: {this.Color}";
        }
    }
}
