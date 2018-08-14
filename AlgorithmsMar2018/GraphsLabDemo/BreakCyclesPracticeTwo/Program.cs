using System;
using System.Collections.Generic;
using System.Linq;

namespace BreakCyclesPracticeTwo
{
    class Edge : IComparable<Edge>
    {
        public string Start { get; set; }

        public string End { get; set; }

        public int CompareTo(Edge other)
        {
            int comparator = string.Compare(this.Start, other.Start, StringComparison.Ordinal);
            if (comparator == 0)
            {
                comparator = string.Compare(this.End, other.End, StringComparison.Ordinal);
            }

            return comparator;
        }
    }

    class Program
    {
        private static Dictionary<string, List<string>> graph;
        private static List<Edge> edges;
        private static List<Edge> edgesToRemove;
        private static HashSet<string> visited;
        private static bool IsCycle;

        static void Main()
        {
            graph = new Dictionary<string, List<string>>();
            edges = new List<Edge>();
            edgesToRemove = new List<Edge>();

            ReadGraph();
            edges.Sort();

            CheckCyclicity();
            Print();
        }

        private static void Print()
        {
            Console.WriteLine($"Edges to remove: {edgesToRemove.Count}");
            foreach (Edge edge in edgesToRemove)
            {
                Console.WriteLine($"{edge.Start} - {edge.End}");
            }
        }

        private static void CheckCyclicity()
        {
            foreach (Edge edge in edges)
            {
                if (!graph[edge.Start].Contains(edge.End) || !graph[edge.End].Contains(edge.Start))
                {
                    continue;
                }
                visited = new HashSet<string>();
                IsCycle = false;
                graph[edge.Start].Remove(edge.End);
                graph[edge.End].Remove(edge.Start);

                Transverse(edge.Start, edge.End);

                if (IsCycle)
                {
                    edgesToRemove.Add(edge);
                }
                else
                {
                    graph[edge.Start].Add(edge.End);
                    graph[edge.End].Add(edge.Start);
                }
            }
        }

        private static void Transverse(string startNode, string endNode)
        {
            if (!visited.Contains(startNode))
            {
                visited.Add(startNode);
                if (startNode == endNode)
                {
                    IsCycle = true;
                    return;
                }

                for (int i = 0; i < graph[startNode].Count; i++)
                {
                    Transverse(graph[startNode][i], endNode);
                }
            }
        }

        private static void ReadGraph()
        {
            while (true)
            {
                string input = Console.ReadLine();
                if (input == string.Empty)
                {
                    break;
                }
                try
                {
                    var splitted = input.Split(' ');
                    var startEdge = splitted[0];
                    var endEdges = splitted.Skip(2).ToArray();
                    graph.Add(startEdge, new List<string>());
                    foreach (var endEdge in endEdges)
                    {
                        graph[startEdge].Add(endEdge);
                        edges.Add(new Edge()
                        {
                            Start = startEdge,
                            End = endEdge
                        });
                    }
                }
                catch (Exception)
                {
                    break;
                }
            }
        }
    }
}
