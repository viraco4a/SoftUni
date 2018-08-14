using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

namespace PrimPractice
{
    class Edge
    {
        public int First { get; set; }
        public int Second { get; set; }
        public int Weight { get; set; }
    }

    class Program
    {
        private static HashSet<int> spanningTree;
        private static Dictionary<int, List<Edge>> nodeToEdges;

        static void Main()
        {
            var graph = new List<Edge>()
            {
                new Edge { First = 1, Second = 2, Weight = 4 },
                new Edge { First = 1, Second = 4, Weight = 9 },
                new Edge { First = 8, Second = 9, Weight = 7 },
                new Edge { First = 4, Second = 5, Weight = 8 },
                new Edge { First = 3, Second = 4, Weight = 20 },
                new Edge { First = 2, Second = 4, Weight = 2 },
                new Edge { First = 7, Second = 9, Weight = 10 },
                new Edge { First = 7, Second = 8, Weight = 8 },
                new Edge { First = 3, Second = 5, Weight = 7 },
                new Edge { First = 5, Second = 6, Weight = 12 },
                new Edge { First = 1, Second = 3, Weight = 5 }
            };

            var nodes = graph
                .Select(e => e.First)
                .Union(graph.Select(s => s.Second))
                .OrderBy(s => s)
                .Distinct()
                .ToHashSet();

            nodeToEdges = new Dictionary<int, List<Edge>>();

            foreach (var edge in graph)
            {
                if (!nodeToEdges.ContainsKey(edge.First))
                {
                    nodeToEdges[edge.First] = new List<Edge>();
                }

                if (!nodeToEdges.ContainsKey(edge.Second))
                {
                    nodeToEdges[edge.Second] = new List<Edge>();
                }
                nodeToEdges[edge.First].Add(edge);
                nodeToEdges[edge.Second].Add(edge);
            }

            spanningTree = new HashSet<int>();

            foreach (var node in nodes)
            {
                if (!spanningTree.Contains(node))
                {
                    Prim(node);
                }
            }
        }

        private static void Prim(int startingNode)
        {
            spanningTree.Add(startingNode);
            var priorityQueue = new OrderedBag<Edge>(Comparer<Edge>.Create((f, s) => f.Weight - s.Weight));

            priorityQueue.AddMany(nodeToEdges[startingNode]);

            while (priorityQueue.Count != 0)
            {
                var minEdge = priorityQueue.First();
                priorityQueue.Remove(minEdge);

                var nonTreeNode = -1;

                if (spanningTree.Contains(minEdge.First)
                    && !spanningTree.Contains(minEdge.Second))
                {
                    nonTreeNode = minEdge.Second;
                }

                if (spanningTree.Contains(minEdge.Second)
                    && !spanningTree.Contains(minEdge.First))
                {
                    nonTreeNode = minEdge.First;
                }

                if (nonTreeNode == -1)
                {
                    continue;
                }

                spanningTree.Add(nonTreeNode);
                Console.WriteLine($"{minEdge.First} - {minEdge.Second}");
                priorityQueue.AddMany(nodeToEdges[nonTreeNode]);
            }
        }
    }
}
