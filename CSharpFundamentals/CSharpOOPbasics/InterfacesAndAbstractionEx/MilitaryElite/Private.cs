﻿namespace MilitaryElite
{
    using MilitaryElite.Interfaces;

    public class Private : Soldier, IPrivate
    {
        public decimal Salary { get; private set; }

        public Private(int id, string firstName, string lastName, decimal salary)
            : base(id, firstName, lastName)
        {
            Salary = salary;
        }

        public override string ToString()
        {
            return base.ToString() + $" Salary: {Salary:F2}";
        }
    }
}
