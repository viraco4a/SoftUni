using System.Collections.Generic;

namespace MilitaryElitePractice.Contracts
{
    public interface ICommando : ISpecialisedSoldier
    {
        ICollection<IMission> Missions { get; }
    }
}
