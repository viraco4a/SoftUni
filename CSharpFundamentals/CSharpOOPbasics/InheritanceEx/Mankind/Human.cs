using System;
using System.Text;

namespace Mankind
{
    public class Human
    {
        private const int FIRST_NAME_MIN_LENGTH = 4;
        private const int LAST_NAME_MIN_LENGTH = 3;
        private string firstName;
        private string lastName;

        public Human(string firstName, string lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        protected string LastName
        {
            get { return lastName; }
            set
            {
                if (!char.IsUpper(value[0]))
                {
                    throw new ArgumentException($"Expected upper case letter! Argument: {nameof(lastName)}");
                }
                if (value.Length < LAST_NAME_MIN_LENGTH)
                {
                    throw new ArgumentException($"Expected length at least {LAST_NAME_MIN_LENGTH} symbols! Argument: {nameof(lastName)}");
                }
                lastName = value;
            }
        }

        protected string FirstName
        {
            get { return firstName; }
            set
            {
                if (!char.IsUpper(value[0]))
                {
                    throw new ArgumentException($"Expected upper case letter! Argument: {nameof(firstName)}");
                }
                if (value.Length < FIRST_NAME_MIN_LENGTH)
                {
                    throw new ArgumentException($"Expected length at least {FIRST_NAME_MIN_LENGTH} symbols! Argument: {nameof(firstName)}");
                }
                firstName = value;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine($"First Name: {this.FirstName}");
            sb.AppendLine($"Last Name: {this.LastName}");
            return sb.ToString().TrimEnd();
        }
    }
}
