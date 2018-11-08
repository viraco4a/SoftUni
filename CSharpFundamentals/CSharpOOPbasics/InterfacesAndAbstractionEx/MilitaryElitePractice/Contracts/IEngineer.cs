using System.Collections.Generic;

namespace MilitaryElitePractice.Contracts
{
    public interface IEngineer : ISpecialisedSoldier
    {
        ICollection<IRepair> Repairs { get; }
    }
}
