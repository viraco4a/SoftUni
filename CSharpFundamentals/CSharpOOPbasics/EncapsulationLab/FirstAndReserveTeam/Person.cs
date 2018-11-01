using System;

namespace PersonsInfo
{
    public class Person
    {
        const int MIN_LENGTH = 3;
        const decimal MIN_SALARY = 460;
        private string firstName;
        private string lastName;
        private int age;
        private decimal salary;

        public Person(string firstName, string lastName, int age, decimal salary)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.Age = age;
            this.Salary = salary;
        }

        public string FirstName
        {
            get { return firstName; }
            private set
            {
                if (value.Length < MIN_LENGTH)
                {
                    throw new ArgumentException(
                        "First name cannot contain fewer than 3 symbols!");
                }
                else
                {
                    firstName = value;
                }
            }
        }
        public string LastName
        {
            get { return lastName; }
            private set
            {
                if (value.Length < MIN_LENGTH)
                {
                    throw new ArgumentException(
                        "Last name cannot contain fewer than 3 symbols!");
                }
                else
                {
                    lastName = value;
                }
            }
        }

        public int Age
        {
            get { return age; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException(
                        "Age cannot be zero or a negative integer!");
                }
                else
                {
                    age = value;
                }
            }
        }

        public decimal Salary
        {
            get { return salary; }
            private set
            {
                if (value < MIN_SALARY)
                {
                    throw new ArgumentException(
                        "Salary cannot be less than 460 leva!");
                }
                else
                {
                    salary = value;
                }
            }
        }

        public void IncreaseSalary(decimal bonus)
        {
            if (this.Age < 30)
            {
                bonus /= 200;
            }
            else
            {
                bonus /= 100;
            }
            this.Salary += this.Salary * bonus;
        }

        public override string ToString()
        {
            return $"{this.FirstName} {this.LastName} receives {this.Salary:F2} leva.";
        }
    }
}
