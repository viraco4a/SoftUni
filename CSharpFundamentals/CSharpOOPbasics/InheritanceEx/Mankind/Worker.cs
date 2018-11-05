using System;
using System.Text;

namespace Mankind
{
    public class Worker : Human
    {
        private const int MIN_SALARY = 10;
        private const int WORKING_HOURS_MIN = 1;
        private const int WORKING_HOURS_MAX = 12;
        private decimal salary;
        private double workHours;

        public Worker(string firstName, string lastName, decimal salary, double workHour)
            : base(firstName, lastName)
        {
            this.Salary = salary;
            this.WorkHours = workHour;
        }

        public double WorkHours
        {
            get { return workHours; }
            private set
            {
                if (value < WORKING_HOURS_MIN || value > WORKING_HOURS_MAX)
                {
                    throw new ArgumentException("Expected value mismatch! Argument: workHoursPerDay");
                }
                workHours = value;
            }
        }

        public decimal Salary
        {
            get { return salary; }
            private set
            {
                if (value <= MIN_SALARY)
                {
                    throw new ArgumentException("Expected value mismatch! Argument: weekSalary");
                }
                salary = value;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(base.ToString());
            sb.AppendLine($"Week Salary: {this.Salary:F2}");
            sb.AppendLine($"Hours per day: {this.WorkHours:F2}");
            sb.AppendLine($"Salary per hour: {this.CalcSalary():F2}");
            return sb.ToString().TrimEnd();
        }

        private decimal CalcSalary()
        {
            double totalHours = 5 * this.WorkHours;
            return Salary / (decimal)totalHours;
        }
    }
}
