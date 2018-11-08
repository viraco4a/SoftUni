using MilitaryElitePractice.Contracts;
using MilitaryElitePractice.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElitePractice.Models
{
    public abstract class SpecialisedSoldier : Private, ISpecialisedSoldier
    {
        public Corps Corps { get; private set; }

        public SpecialisedSoldier(int id, string firstName, string lastName, decimal salary, Corps corps) 
            : base(id, firstName, lastName, salary)
        {
            this.Corps = corps;
        }
    }
}
