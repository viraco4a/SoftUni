using System;
using System.Linq;
using System.Collections.Generic;

namespace GraphDFS
{
    class Program
    {

        private static bool[] visited;
        private static List<int>[] graph;

        static void Main()
        {
            graph = new List<int>[]
            {
                new List<int>() { 3, 6 },
                new List<int>() { 2, 3, 4, 5, 6 },
                new List<int>() { 1, 4, 5 },
                new List<int>() { 0, 1, 5 },
                new List<int>() { 1, 2, 6 },
                new List<int>() { 1, 2, 3 },
                new List<int>() { 0, 1, 4 }
            };

            visited = new bool[graph.Length];

            for (int i = 0; i < visited.Length; i++)
            {
                DFS(i);
            }

        }

        private static void DFS(int node)
        {
            if (!visited[node])
            {
                visited[node] = true;
                foreach (var child in graph[node])
                {
                    DFS(child);
                }
                Console.Write($"{node} ");
            }
        }
    }
}
