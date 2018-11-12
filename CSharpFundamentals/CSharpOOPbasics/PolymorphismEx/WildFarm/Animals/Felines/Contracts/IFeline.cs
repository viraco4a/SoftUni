using WildFarm.Animals.Mammals.Contracts;

namespace WildFarm.Animals.Felines.Contracts
{
    public interface IFeline : IMammal
    {
        string Breed { get; }
    }
}
