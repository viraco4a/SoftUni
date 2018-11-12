using WildFarm.Animals.Contracts;

namespace WildFarm.Animals.Birds.Contracts
{
    public interface IBird : IAnimal
    {
        double WingSize { get; }
    }
}
