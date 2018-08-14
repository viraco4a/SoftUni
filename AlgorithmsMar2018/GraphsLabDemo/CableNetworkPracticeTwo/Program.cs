using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

namespace CableNetworkPracticeTwo
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

        private static HashSet<int> spanningTree;

        private static int totalBudget;

        private static int usedBudget = 0;

        static void Main()
        {
            totalBudget = int.Parse(Console.ReadLine().Split()[1]);
            var totalNodes = int.Parse(Console.ReadLine().Split()[1]);
            var totalEdges = int.Parse(Console.ReadLine().Split()[1]);
            graph = new Dictionary<int, List<Edge>>();
            spanningTree = new HashSet<int>();

            for (int i = 0; i < totalEdges; i++)
            {
                var input = Console.ReadLine().Split();
                var edge = new Edge
                {
                    First = int.Parse(input[0]),
                    Second = int.Parse(input[1]),
                    Cost = int.Parse(input[2])
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

                if (input.Length > 3)
                {
                    spanningTree.Add(edge.First);
                    spanningTree.Add(edge.Second);
                }
            }

            Prim();

            Console.WriteLine($"Budget used: {usedBudget}");
        }

        private static void Prim()
        {
            var queue = new OrderedBag<Edge>(
                Comparer<Edge>.Create((f, s) => f.Cost - s.Cost));

            queue.AddMany(spanningTree.SelectMany(s => graph[s]));

            while (queue.Count != 0)
            {
                var min = queue.RemoveFirst();

                var nonTreeNode = -1;

                if (spanningTree.Contains(min.First) 
                    && !spanningTree.Contains(min.Second))
                {
                    nonTreeNode = min.Second;
                }

                if (spanningTree.Contains(min.Second)
                && !spanningTree.Contains(min.First))
                {
                    nonTreeNode = min.First;
                }

                if (nonTreeNode == -1)
                {
                    continue;
                }

                if (totalBudget >= min.Cost)
                {
                    totalBudget -= min.Cost;
                    usedBudget += min.Cost;
                }
                else
                {
                    break;
                }

                spanningTree.Add(nonTreeNode);
                queue.AddMany(graph[nonTreeNode]);
            }
        }
    }
}
