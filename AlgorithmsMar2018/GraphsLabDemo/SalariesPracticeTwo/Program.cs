using System;
using System.Collections.Generic;
using System.Linq;

namespace SalariesPracticeTwo
{
    class Program
    {
        private static List<int>[] graph;
        private static Dictionary<int, long> salaries;

        static void Main()
        {
            int employeeCount = int.Parse(Console.ReadLine());
            graph = new List<int>[employeeCount];
            salaries = new Dictionary<int, long>();
            for (int i = 0; i < employeeCount; i++)
            {
                string input = Console.ReadLine();
                graph[i] = new List<int>();
                for (int j = 0; j < input.Length; j++)
                {
                    if (input[j] == 'Y')
                    {
                        graph[i].Add(j);
                    }
                }
            }

            for (int employee = 0; employee < employeeCount; employee++)
            {
                DFS(employee);
            }

            Console.WriteLine(salaries.Sum(s => s.Value));
            
        }

        private static void DFS(int manager)
        {
            if (salaries.ContainsKey(manager))
            {
                return;
            }
            salaries[manager] = 0;
            if (graph[manager].Count > 0)
            {
                foreach (var employee in graph[manager])
                {
                    DFS(employee);
                    salaries[manager] += salaries[employee];
                }
            }
            else
            {
                salaries[manager]++;
            }
        }
    }
}
