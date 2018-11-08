﻿using MilitaryElite.Interfaces;

namespace MilitaryElite
{
    public class Repair : IRepair
    {
        public string PartName { get; private set; }
        public int HoursWorked { get; private set; }

        public Repair(string partName, int hoursWorked)
        {
            PartName = partName;
            HoursWorked = hoursWorked;
        }

        public override string ToString()
        {
            return $"Part Name: {PartName} Hours Worked: {HoursWorked}";
        }
    }
}
