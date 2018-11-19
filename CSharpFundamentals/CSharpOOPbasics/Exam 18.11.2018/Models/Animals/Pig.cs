namespace AnimalCentre.Models
{
    public class Pig : Animal
    {
        public Pig(string name, int energy, int happiness, int procedureTime)
            : base(name, energy, happiness, procedureTime) { }

        public override string ToString()
        {
            string local = $"    Animal type: {this.GetType().Name} ";
            return local + base.ToString();
        }
    }
}
