using MilitaryElite.Enums;
using MilitaryElite.Interfaces;
using System;

namespace MilitaryElite
{
    public abstract class SpecializedSoldier : Private, ISpecializedSoldier
    {
        public Corps Corps { get; private set; }

        public SpecializedSoldier(int id, string firstName, string lastName, decimal salary, string corps)
            : base(id, firstName, lastName, salary)
        {
            ParseCorps(corps);
        }

        private void ParseCorps(string corps)
        {
            bool isValid = Enum.TryParse(typeof(Corps), corps, out object validCorps);
            if (!isValid)
            {
                throw new ArgumentException("Invalid corps!");
            }
            this.Corps = (Corps)validCorps;
        }

        public override string ToString()
        {
            return base.ToString() + Environment.NewLine + $"Corps: {Corps}";
        }
    }
}
