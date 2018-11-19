using AnimalCentre.Models.Contracts;

namespace AnimalCentre.Models
{
    public class Cat : Animal
    {
        public Cat(string name, int energy, int happiness, int procedureTime)
            : base(name, energy, happiness, procedureTime) { }

        public override string ToString()
        {
            string local = $"    Animal type: {this.GetType().Name} ";
            return local + base.ToString();
        }
    }
}
