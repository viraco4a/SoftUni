using System;
using System.Linq;
using System.Collections.Generic;

namespace AverageStudentGrades
{
    class AverageStudentGrades
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            var students = new Dictionary<string, List<double>>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string name = input[0];
                double grade = double.Parse(input[1]);
                if (!students.ContainsKey(name))
                {
                    students.Add(name, new List<double>());
                }

                students[name].Add(grade);
            }

            foreach (var kvp in students)
            {
                string list = string.Join(" ", kvp.Value);
                Console.Write($"{kvp.Key} -> ");
                foreach (var item in kvp.Value)
                {
                    Console.Write($"{item:F2} ");
                }
                Console.WriteLine($"(avg: {Average(kvp.Value):f2})");
            }
        }

        private static double Average(List<double> list)
        {
            return list.Sum() / list.Count;
        }
    }
}