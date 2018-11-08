using System.Collections.Generic;

namespace MilitaryElitePractice.Contracts
{
    public interface ILieutenantGeneral : IPrivate
    {
        ICollection<ISoldier> privates { get; }
    }
}
