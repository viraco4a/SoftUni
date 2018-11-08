using MilitaryElitePractice.Enums;

namespace MilitaryElitePractice.Contracts
{
    public interface ISpecialisedSoldier : IPrivate
    {
        Corps Corps { get; }
    }
}