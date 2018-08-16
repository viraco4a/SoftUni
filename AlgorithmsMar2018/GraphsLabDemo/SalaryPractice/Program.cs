using System;
using System.Collections.Generic;
using System.Linq;

namespace SalaryPractice
{
    class Program
    {
        private static string[] graph;
        private static Dictionary<int, long> result;

        static void Main()
        {
            int employeeCount = int.Parse(Console.ReadLine());
            graph = new string[employeeCount];
            result = new Dictionary<int, long>();

            for (int i = 0; i < employeeCount; i++)
            {
                graph[i] = Console.ReadLine();
            }

            for (int col = 0; col < employeeCount; col++)
            {
                bool isBoss = false;
                for (int row = 0; row < employeeCount; row++)
                {
                    if (graph[col][row] == 'Y')
                    {
                        isBoss = true;
                        break;
                    }
                }
                if (isBoss)
                {
                    DFS(col);
                }
                else if (!result.ContainsKey(col))
                {
                    result.Add(col, 1);
                }
            }
            Console.WriteLine(result.Sum(s => s.Value));
        }

        private static void DFS(int manager)
        {
            if (result.ContainsKey(manager))
            {
                return;
            }
            long salary = 0;
            bool hasChild = false;

            for (int employee = 0; employee < graph.GetLength(0); employee++)
            {
                if (graph[manager][employee] == 'Y')
                {
                    hasChild = true;
                    DFS(employee);
                    salary += result[employee];
                }
            }
            if (!hasChild)
            {
                salary = 1;
            }

            result.Add(manager, salary);
        }
    }
}
