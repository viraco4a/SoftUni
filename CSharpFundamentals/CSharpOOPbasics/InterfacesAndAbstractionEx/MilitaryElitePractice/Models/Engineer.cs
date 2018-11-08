using MilitaryElitePractice.Contracts;
using MilitaryElitePractice.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class Engineer : SpecialisedSoldier, IEngineer
    {
        public ICollection<IRepair> Repairs { get; private set; }

        public Engineer(int id, string firstName, string lastName, decimal salary, Corps corps)
            : base(id, firstName, lastName, salary, corps)
        {
            this.Repairs = new List<IRepair>();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb
                .AppendLine(base.ToString())
                .AppendLine($"Corps: {Corps}")
                .AppendLine("Repairs:")
                .AppendLine("  " + string.Join("\n  ", Repairs));

            return sb.ToString().TrimEnd();
        }
    }
}
