namespace MilitaryElite.Interfaces
{
    using MilitaryElite.Enums;

    public interface ISpecializedSoldier : IPrivate
    {
        Corps Corps { get; }
    }
}
