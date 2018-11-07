using MilitaryElite.Interfaces;
using System;

namespace MilitaryElite
{
    public class Spy : Soldier, ISpy
    {
        public int CodeNumber { get; private set; }

        public Spy(int id, string firstName, string lastName, int codeNumber)
            : base (id, firstName, lastName)
        {
            CodeNumber = codeNumber;
        }

        public override string ToString()
        {
            return base.ToString() + Environment.NewLine + $"Code Number: {CodeNumber}";
        }
    }
}
