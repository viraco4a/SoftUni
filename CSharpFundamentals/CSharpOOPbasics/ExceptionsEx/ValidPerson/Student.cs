using System.Text.RegularExpressions;

namespace ValidPerson
{
    public class Student : Person
    {
        private string email;
        public Student(string firstName, string lastName, int age, string email)
            : base(firstName, lastName, age)
        {
            this.Email = email;
        }

        public string Email
        {
            get { return this.email; }
            set
            {
                string pattern = @"[0-9]";
                if (Regex.IsMatch(value, pattern))
                {
                    throw new InvalidPersonNameException("Invalid Student email");
                }
                this.email = value;
            }
        }
    }
}
