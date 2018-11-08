using MilitaryElitePractice.Contracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class Spy : Soldier, ISpy
    {
        public int CodeNumber { get; private set; }

        public Spy(int id, string firstName, string lastName, int codeNumber)
            : base(id, firstName, lastName)
        {
            this.CodeNumber = codeNumber;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb
                .AppendLine(base.ToString())
                .AppendLine($"Code Number: {CodeNumber}");

            return sb.ToString().TrimEnd();
        }
    }
}
