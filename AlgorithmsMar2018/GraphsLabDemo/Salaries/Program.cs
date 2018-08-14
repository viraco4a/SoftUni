using System;
using System.Collections.Generic;
using System.Linq;

namespace Salaries
{
    //class Employee
    //{
    //    public int Salary { get; set; }
    //    public string Name { get; set; }
    //    public List<string> Children { get; set; }
    //}

    class Program
    {
        private static string[] graph;
        private static Dictionary<int, long> visited;

        static void Main()
        {
            int employeeCount = int.Parse(Console.ReadLine());
            visited = new Dictionary<int, long>();
            graph = new string[employeeCount];
            for (int i = 0; i < employeeCount; i++)
            {
                graph[i] = Console.ReadLine();
            }

            for (int col = 0; col < employeeCount; col++)
            {
                bool isBoss = false;
                for (int row = 0; row < employeeCount; row++)
                {
                    if (graph[col][row] != 'N')
                    {
                        isBoss = true;
                        break;
                    }
                }
                if (isBoss)
                {
                    DFS(col);
                }
                else if (!visited.ContainsKey(col))
                {
                    visited.Add(col, 1);
                }
            }
            Console.WriteLine(visited.Sum(n => n.Value));
        }
        
        private static void DFS(int manager)
        {
            if (visited.ContainsKey(manager))
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
                    salary += visited[employee];
                }
            }
            if (!hasChild)
            {
                salary = 1;
            }

            visited.Add(manager, salary);
        }
    }
}
