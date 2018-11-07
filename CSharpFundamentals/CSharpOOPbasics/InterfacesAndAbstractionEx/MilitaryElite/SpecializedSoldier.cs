using System;
using System.Collections.Generic;
using System.Text;
using MilitaryElite.Enums;
using MilitaryElite.Interfaces;

namespace MilitaryElite
{
    public class SpecializedSoldier : Private, ISpecializedSoldier
    {
        public Corps Corps => throw new NotImplementedException();

        public SpecializedSoldier(int id, ) //TODO
        {

        }
    }
}
