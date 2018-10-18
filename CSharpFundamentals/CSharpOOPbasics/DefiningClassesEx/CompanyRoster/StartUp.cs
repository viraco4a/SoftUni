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

            var topDepartment = company.GroupBy(s => s.Department)
                   .OrderByDescending(x => x.Average(s => s.Salary))
                   .FirstOrDefault();

            Console.WriteLine($"Highest Average Salary: {topDepartment.Key}");
            foreach (var employee in topDepartment.OrderByDescending(s => s.Salary))
            {
                Console.WriteLine($"{employee.Name} {employee.Salary:f2} {employee.Email} {employee.Age}");
            }

        }

        private static void ReadInput(List<Employee> company)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var splitted = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string name = splitted[0];
                decimal salary = decimal.Parse(splitted[1]);
                string position = splitted[2];
                string department = splitted[3];

                Employee employee = new Employee(name, salary, position, department);

                switch (splitted.Length)
                {
                    case 5:
                        if (splitted[4].Contains('@'))
                        {
                            employee.Email = splitted[4];
                        }
                        else
                        {
                            employee.Age = int.Parse(splitted[4]);
                        }
                        break;
                    case 6:
                        employee.Email = splitted[4];
                        employee.Age = int.Parse(splitted[5]);
                        break;
                }

                if (!company.Contains(employee))
                {
                    company.Add(employee);
                }
            }
        }
    }
}
