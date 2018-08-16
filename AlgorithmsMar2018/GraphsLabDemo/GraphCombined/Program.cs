using System;
using System.Linq;
using System.Collections.Generic;

namespace GraphCombined
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
                new List<int>() { 0, 1, 4 },
                new List<int>() { 8 },
                new List<int>() { 7 }
            };

            visited = new bool[graph.Length];

            var components = 0;

            for (int i = 0; i < visited.Length; i++)
            {
                if (!visited[i])
                {
                    components++;
                    Console.Write($"Connected components {components}: ");
                    DFS(i);
                    //BFS(i);
                    Console.WriteLine();
                }
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

        static void BFS(int node)
        {

            if (visited[node])
            {
                return;
            }

            var queue = new Queue<int>();
            queue.Enqueue(node);
            visited[node] = true;

            while (queue.Count != 0)
            {
                var currentNode = queue.Dequeue();

                Console.Write($"{currentNode} ");

                foreach (var child in graph[currentNode])
                {
                    if (!visited[child])
                    {
                        queue.Enqueue(child);
                        visited[child] = true;
                    }
                }
            }
        }

    }
}
