using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;

namespace CompanyRoster
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            var company = new List<Employee>();

            ReadInput(company);
            
            //TODO ...
        }

        private static void ReadInput(List<Employee> company)
        {
            int n = int.Parse(Console.ReadLine());
            string digitReg = @"\s[0-9]+";
            for (int i = 0; i < n; i++)
            {
                var splitted = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string name = splitted[0];
                decimal salary = decimal.Parse(splitted[1]);
                string position = splitted[2];
                string department = splitted[3];
                string email = "n/a";
                int age = -1;
                switch (splitted.Length)
                {
                    case 5:
                        Match match = Regex.Match(splitted[4], digitReg);
                        if (match.Success)
                        {
                            age = int.Parse(splitted[4]);
                        }
                        else
                        {
                            email = splitted[4];
                        }
                        break;
                    case 6:
                        Match match2 = Regex.Match(splitted[4], digitReg);
                        if (match2.Success)
                        {
                            age = int.Parse(splitted[4]);
                            email = splitted[5];
                        }
                        else
                        {
                            email = splitted[4];
                            age = int.Parse(splitted[5]);
                        }
                        break;
                }

                Employee employee = new Employee(name, salary, position, department, email, age);

                if (!company.Contains(employee))
                {
                    company.Add(employee);
                }
            }
        }
    }
}
