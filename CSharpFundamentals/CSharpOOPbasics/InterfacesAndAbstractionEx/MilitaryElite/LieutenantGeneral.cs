using System;
using System.Collections.Generic;
using System.Text;
using MilitaryElite.Interfaces;
using System.Linq;

namespace MilitaryElite
{
    public class LieutenantGeneral : Private, ILieutenantGeneral
    {
        private ICollection<ISoldier> privates;

        public IReadOnlyCollection<ISoldier> Privates => (IReadOnlyCollection<ISoldier>) this.privates;

        public LieutenantGeneral(int id, string firstName, string lastName, decimal salary)
            : base(id, firstName, lastName, salary)
        {
            privates = new List<ISoldier>();
        }

        public void AddPrivate(ISoldier soldier)
        {
            this.privates.Add(soldier);
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(base.ToString());
            sb.AppendLine("Privates:");
            this.Privates.ToList().ForEach(s =>
            {
                sb.AppendLine($"  {s.ToString()}");
            });

            return sb.ToString().TrimEnd();
        }
    }
}
