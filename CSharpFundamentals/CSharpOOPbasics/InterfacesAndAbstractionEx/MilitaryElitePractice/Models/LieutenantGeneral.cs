using MilitaryElitePractice.Contracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class LieutenantGeneral : Private, ILieutenantGeneral
    {
        public ICollection<IPrivate> Privates { get; private set; }

        public LieutenantGeneral(int id, string firstName, string lastName, decimal salary)
            : base(id, firstName, lastName, salary)
        {
            this.Privates = new List<IPrivate>();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb
                .AppendLine(base.ToString())
                .AppendLine("Privates:")
                .AppendLine("  " + string.Join("\n  ", Privates));

            return sb.ToString().TrimEnd();
        }
    }
}
