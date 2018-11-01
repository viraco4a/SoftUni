namespace PersonsInfo
{
    public class Person
    {
        private string firstName;
        private string lastName;
        private int age;
        private decimal salary;

        public Person(string firstName, string lastName, int age, decimal salary)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
        }

        public string FirstName
        {
            get { return firstName; }
        }
        public string LastName
        {
            get { return lastName; }
        }

        public int Age
        {
            get { return age; }
        }

        public decimal Salary
        {
            get { return salary; }
            set { salary = value; }
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
