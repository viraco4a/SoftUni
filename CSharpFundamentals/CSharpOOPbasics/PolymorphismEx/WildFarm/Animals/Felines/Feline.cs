using WildFarm.Animals.Felines.Contracts;

namespace WildFarm.Animals.Mammals.Felines
{
    public abstract class Feline : Mammal, IFeline
    {
        private string breed;

        public string Breed
        {
            get { return breed; }
            set { breed = value; }
        }

        public Feline(string name, double weight, string livingRegion, string breed) 
            : base(name, weight, livingRegion)
        {
            this.Breed = breed;
        }
    }
}
