using System;
using System.Text;
using System.Text.RegularExpressions;

namespace Mankind
{
    public class Student : Human
    {
        private const int FACULTY_MIN = 5;
        private const int FACULTY_MAX = 10;
        private string facultyNumber;

        public Student(string firstName, string lastName, string facultyNumber)
    : base(firstName, lastName)
        {
            this.FacultyNumber = facultyNumber;
        }

        public string FacultyNumber
        {
            get { return facultyNumber; }
            private set
            {
                string pattern = @"^[A-Za-z0-9]{5,10}$";
                if (!Regex.IsMatch(value, pattern))
                {
                    throw new ArgumentException("Invalid faculty number!");
                }
                facultyNumber = value;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(base.ToString());
            sb.AppendLine($"Faculty number: {this.FacultyNumber}");
            return sb.ToString().TrimEnd();
        }
    }
}
