using System;
using System.Linq;
using System.Collections.Generic;

namespace TopologicalSortGraph
{
    class Program
    {

        private static List<int>[] graph;

        static void Main()
        {
            graph = new List<int>[]
            {
                new List<int>() { 1, 2 },
                new List<int>() { 3, 4 },
                new List<int>() { 5 },
                new List<int>() { 2, 5 },
                new List<int>() { 3 },
                new List<int>() { }
            };

            var result = new List<int>();
            var nodes = new HashSet<int>();

            HashSet<int> nodeWithIncomingEdges = GetPrimeNode();

            for (int i = 0; i < graph.Length; i++)
            {
                if (!nodeWithIncomingEdges.Contains(i))
                {
                    nodes.Add(i);
                }
            }

            while (nodes.Count != 0)
            {
                var currentNode = nodes.First();
                nodes.Remove(currentNode);

                result.Add(currentNode);

                var children = graph[currentNode].ToList();
                graph[currentNode] = new List<int>();

                var leftNodesWithIncomingEdges = GetPrimeNode();

                foreach (var child in children)
                {
                    if (!leftNodesWithIncomingEdges.Contains(child))
                    {
                        nodes.Add(child);
                    }
                }
            }

            if (graph.SelectMany(s => s).ToList().Any())
            {
                Console.WriteLine("Error");
            }
            else
            {
                Console.WriteLine(string.Join("->", result));
            }
        }

        private static HashSet<int> GetPrimeNode()
        {
            var nodeWithIncomingEdges = new HashSet<int>();

            graph
                .SelectMany(s => s)
                .ToList()
                .ForEach(e => nodeWithIncomingEdges.Add(e));

            return nodeWithIncomingEdges;
        }
    }
}
