using MilitaryElite.Enums;
using MilitaryElite.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace MilitaryElite
{
    public class Engineer : Private, IEngineer
    {
        private ICollection<IRepair> repairs;
        public IReadOnlyCollection<IRepair> Repairs => (IReadOnlyCollection<IRepair>)this.repairs;

        public Corps Corps => throw new NotImplementedException();


        public void AddRepair(IRepair repair)
        {
            throw new NotImplementedException();
        }
    }
}
