using WildFarm.Animals.Birds.Contracts;

namespace WildFarm.Animals.Birds
{
    public abstract class Bird : Animal, IBird
    {
        private double wingSize;

        public double WingSize
        {
            get { return wingSize; }
            set { wingSize = value; }
        }

        public Bird(string name, double weight, double wingSize) 
            : base(name, weight)
        {
            this.WingSize = wingSize;
        }

        public override string ToString()
        {
            return base.ToString() +
                $"{this.WingSize}, {this.Weight}, {this.FoodEaten}]";
        }
    }
}
