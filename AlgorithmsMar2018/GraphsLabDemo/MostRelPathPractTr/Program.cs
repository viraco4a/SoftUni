using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

namespace MostRelPathPractTr
{
    class Edge
    {
        public int First { get; set; }
        public int Second { get; set; }
        public int Cost { get; set; }
    }

    class Program
    {
        private static Dictionary<int, List<Edge>> graph;

        private static double[] percentages;

        private static bool[] visited;

        private static int[] prev;

        static void Main()
        {
            var nodeCount = int.Parse(Console.ReadLine().Split()[1]);
            var pathData = Console.ReadLine().Split();
            var start = int.Parse(pathData[1]);
            var end = int.Parse(pathData[3]);
            var edgeCount = int.Parse(Console.ReadLine().Split()[1]);

            graph = new Dictionary<int, List<Edge>>();

            for (int i = 0; i < edgeCount; i++)
            {
                var input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                var edge = new Edge
                {
                    First = input[0],
                    Second = input[1],
                    Cost = input[2]
                };

                if (!graph.ContainsKey(edge.First))
                {
                    graph[edge.First] = new List<Edge>();
                }

                if (!graph.ContainsKey(edge.Second))
                {
                    graph[edge.Second] = new List<Edge>();
                }

                graph[edge.First].Add(edge);
                graph[edge.Second].Add(edge);
            }

            visited = new bool[graph.Count];
            visited[start] = true;

            prev = new int[graph.Count];
            prev[start] = -1;

            percentages = Enumerable.Repeat<double>(-1, graph.Count).ToArray();
            percentages[start] = 100;

            var queue = new OrderedBag<int>(
                Comparer<int>.Create((a, b) => (int)(percentages[b] - percentages[a])));
            queue.Add(start);

            while (queue.Count > 0)
            {
                var min = queue.RemoveFirst();
                if (percentages[min] == -1)
                {
                    break;
                }

                foreach (var child in graph[min])
                {
                    var otherNode = child.First == min
                        ? child.Second
                        : child.First;

                    if (!visited[otherNode])
                    {
                        visited[otherNode] = true;
                        queue.Add(otherNode);
                    }

                    var newPerc = percentages[min] / 100 * child.Cost;

                    if (newPerc > percentages[otherNode])
                    {
                        percentages[otherNode] = newPerc;

                        prev[otherNode] = min;

                        queue = new OrderedBag<int>(
                            queue,
                            Comparer<int>.Create((a, b) => (int)(percentages[b] - percentages[a])));
                    }
                }
            }

            var result = new List<int>();
            var current = end;
            while (current != -1)
            {
                result.Add(current);
                current = prev[current];
            }
            result.Reverse();
            Console.WriteLine($"Most reliable path reliability: {percentages[end]:F2}%");
            Console.WriteLine(string.Join(" -> ", result));
        }
    }
}
