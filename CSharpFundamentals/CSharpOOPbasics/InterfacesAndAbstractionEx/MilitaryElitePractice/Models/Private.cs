using MilitaryElitePractice.Contracts;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public class Private : Soldier, IPrivate
    {
        public decimal Salary { get; private set; }

        public Private(int id, string firstName, string lastName, decimal salary)
            : base(id, firstName, lastName)
        {
            this.Salary = salary;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb
                .Append(base.ToString())
                .Append($"Salary: {Salary:F2}");
            return sb.ToString().TrimEnd();
        }
    }
}
