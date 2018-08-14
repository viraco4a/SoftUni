using System;
using System.Collections.Generic;

namespace MaxTasksPractice
{
    class Program
    {
        private static int[][] graph;
        private static int[] parents;
        private static int persons;

        static void Main()
        {
            CreateTheGraph();

            MaxFlowAlgorithm();

            Print();

        }

        private static void Print()
        {
            if (persons < 4)
            {
                for (int i = 1; i < graph.Length; i++)
                {
                    for (int j = i; j < graph.Length - 1; j++)
                    {
                        if (graph[i][j] == 1)
                        {
                            Console.WriteLine($"{(char)(i - 1 + 'A')}-{j - persons}");
                        }
                    }
                }
                return;
            }

            //

            for (int i = 1; i < graph.Length; i++)
            {
                for (int j = i; j < graph.Length - 1; j++)
                {
                    if (graph[j][i] == 1)
                    {
                        Console.WriteLine($"{(char)(i - 1 + 'A')}-{j - persons}");
                    }
                }
            }
        }

        private static void MaxFlowAlgorithm()
        {
            parents = new int[graph.Length];
            for (int i = 0; i < parents.Length; i++)
            {
                parents[i] = -1;
            }

            var start = 0;
            var end = graph.Length - 1;

            while (Bfs(start, end))
            {
                var currentNode = end;

                while (currentNode != start)
                {
                    var prevNode = parents[currentNode];

                    graph[prevNode][currentNode] = 0;
                    graph[currentNode][prevNode] = 1;

                    currentNode = prevNode;
                }
            }
        }

        private static bool Bfs(int start, int end)
        {
            var queue = new Queue<int>();
            var visited = new bool[graph.Length];
            visited[start] = true;
            queue.Enqueue(start);

            while (queue.Count > 0)
            {
                var node = queue.Dequeue();

                for (int child = 0; child < graph.Length; child++)
                {
                    if (!visited[child] 
                        && graph[node][child] > 0)
                    {
                        queue.Enqueue(child);
                        visited[child] = true;
                        parents[child] = node;
                    }
                }
            }

            return visited[end];
        }

        private static void CreateTheGraph()
        {
            persons = int.Parse(Console.ReadLine().Split()[1]);
            int tasks = int.Parse(Console.ReadLine().Split()[1]);
            int nodes = persons + tasks + 2;

            graph = new int[nodes][];

            for (int i = 0; i < nodes; i++)
            {
                graph[i] = new int[nodes];
            }

            for (int i = 0; i < persons; i++)
            {
                graph[0][i + 1] = 1;
            }

            for (int i = 0; i < tasks; i++)
            {
                graph[persons + 1 + i][graph.Length - 1] = 1;
            }

            for (int person = 0; person < persons; person++)
            {
                var input = Console.ReadLine();

                for (int task = 0; task < tasks; task++)
                {
                    if (input[task] == 'Y')
                    {
                        graph[person + 1][persons + task + 1] = 1;
                    }
                }
            }
        }
    }
}
