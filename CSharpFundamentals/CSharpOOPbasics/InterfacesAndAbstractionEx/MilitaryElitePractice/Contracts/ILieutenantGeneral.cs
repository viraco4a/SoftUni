using System.Collections.Generic;

namespace MilitaryElitePractice.Contracts
{
    public interface ILieutenantGeneral : IPrivate
    {
        ICollection<IPrivate> Privates { get; }
    }
}
