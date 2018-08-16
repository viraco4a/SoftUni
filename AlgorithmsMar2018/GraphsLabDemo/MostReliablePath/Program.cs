using System;
using System.Linq;
using System.Collections.Generic;
using Wintellect.PowerCollections;

namespace MostReliablePath
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

        static void Main()
        {
            var nodes = int.Parse(Console.ReadLine().Split(' ')[1]);
            var path = Console.ReadLine().Split(' ');
            var edges = int.Parse(Console.ReadLine().Split(' ')[1]);
            var start = int.Parse(path[1]);
            var end = int.Parse(path[3]);

            graph = new Dictionary<int, List<Edge>>();

            for (int i = 0; i < edges; i++)
            {
                var edgeParts = Console.ReadLine().Split(' ');
                var edge = new Edge
                {
                    First = int.Parse(edgeParts[0]),
                    Second = int.Parse(edgeParts[1]),
                    Cost = int.Parse(edgeParts[2])
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

            var percentages = Enumerable.Repeat<double>(-1, graph.Count).ToArray();

            percentages[start] = 100;

            var visited = new bool[graph.Count];
            visited[start] = true;

            var prev = new int[graph.Count];
            prev[start] = -1;

            var queue = new OrderedBag<int>(
                Comparer<int>.Create((f, s) => (int)(percentages[s] - percentages[f])));

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
                            Comparer<int>.Create((f, s) => (int)(percentages[s] - percentages[f])));
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
