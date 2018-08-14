using System;
using System.Collections.Generic;
using System.Linq;

namespace BreackCyclesOOP
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
        private static bool IsCyclic;

        static void Main()
        {
            graph = new Dictionary<string, List<string>>();
            edges = new List<Edge>();
            edgesToRemove = new List<Edge>();
            GetGraph();

            edges.Sort();
            CheckCyclicity();
            Console.WriteLine($"Edges to remove: {edgesToRemove.Count}");
            foreach (var edge in edgesToRemove)
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
                IsCyclic = false;
                graph[edge.Start].Remove(edge.End);
                graph[edge.End].Remove(edge.Start);

                Transverse(edge.Start, edge.End);

                if (IsCyclic)
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
                    IsCyclic = true;
                    return;
                }
                for (int i = 0; i < graph[startNode].Count; i++)
                {
                    Transverse(graph[startNode][i], endNode);
                }
            }
        }

        private static void GetGraph()
        {
            while (true)
            {
                string input = Console.ReadLine();
                try
                {
                    if (input == string.Empty)
                    {
                        break;
                    }

                    var splitted = input.Split(' ');
                    var edgeStart = splitted[0];
                    var edgeEnds = splitted.Skip(2).ToArray();

                    graph.Add(edgeStart, new List<string>());

                    foreach (var edgeEnd in edgeEnds)
                    {
                        graph[edgeStart].Add(edgeEnd);
                        edges.Add(new Edge()
                        {
                            Start = edgeStart,
                            End = edgeEnd
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
