using WildFarm.Animals.Contracts;

namespace WildFarm.Animals.Mammals.Contracts
{
    public interface IMammal : IAnimal
    {
        string LivingRegion { get; }
    }
}
