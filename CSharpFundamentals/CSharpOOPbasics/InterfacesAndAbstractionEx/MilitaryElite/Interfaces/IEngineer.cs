using System.Collections.Generic;

namespace MilitaryElite.Interfaces
{
    public interface IEngineer : ISpecializedSoldier
    {
        IReadOnlyCollection<IRepair> Repairs { get; }
        void AddRepair(IRepair repair);
    }
}
