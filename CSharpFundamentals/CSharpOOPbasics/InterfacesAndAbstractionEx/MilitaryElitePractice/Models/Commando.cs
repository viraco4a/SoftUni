using MilitaryElitePractice.Contracts;
using MilitaryElitePractice.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class Commando : SpecialisedSoldier, ICommando
    {
        public ICollection<IMission> Missions { get; private set; }

        public Commando(int id, string firstName, string lastName, decimal salary, Corps corps)
            : base(id, firstName, lastName, salary, corps)
        {
            this.Missions = new List<IMission>();
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb
                .AppendLine(base.ToString())
                .AppendLine($"Corps: {Corps}")
                .AppendLine("Missions:")
                .AppendLine("  " + string.Join("\n  ", Missions));

            return sb.ToString().TrimEnd();
        }
    }
}
