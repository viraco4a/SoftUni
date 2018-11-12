using WildFarm.Animals.Mammals.Contracts;

namespace WildFarm.Animals.Mammals
{
    public abstract class Mammal : Animal, IMammal
    {
        private string livingRegion;

        public string LivingRegion
        {
            get { return livingRegion; }
            set { livingRegion = value; }
        }

        public Mammal(string name, double weight, string livingRegion)
            : base(name, weight)
        {
            this.LivingRegion = livingRegion;
        }
    }
}
