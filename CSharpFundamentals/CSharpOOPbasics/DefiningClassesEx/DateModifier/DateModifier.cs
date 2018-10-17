using System;
using System.Collections.Generic;
using System.Text;
using System.Globalization;

namespace DefiningClasses
{
    public class DateModifier
    {
        private DateTime firstDate;
        private DateTime secondDate;

        public DateTime FirstDate
        {
            get
            {
                return this.firstDate;
            }
            set
            {
                this.firstDate = value;
            }
        }
        public DateTime SecondDate
        {
            get
            {
                return this.secondDate;
            }
            set
            {
                this.secondDate = value;
            }
        }

        public int CalcDifference(string first, string second)
        {
            DateTime firstD = DateTime.ParseExact(first, "yyyy MM dd", CultureInfo.InvariantCulture);
            DateTime secondD = DateTime.ParseExact(second, "yyyy MM dd", CultureInfo.InvariantCulture);
            return (int)Math.Abs((secondD - firstD).TotalDays);
        }
    }
}
