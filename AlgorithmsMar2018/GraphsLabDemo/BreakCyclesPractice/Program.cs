using System;
using System.Collections.Generic;
using System.Linq;

namespace BreakCycles
{

    class Edge : IComparable<Edge>
    {
        public string Start { get; set; }

        public string End { get; set; }

        public int CompareTo(Edge other)
        {
            int comparer = string.Compare(this.Start, other.Start, StringComparison.Ordinal);
            if (comparer == 0)
            {
                return string.Compare(this.End, other.End, StringComparison.Ordinal);
            }

            return comparer;
        }

        //public override string ToString()
        //{
        //    return string.Format("{0} - {1}", this.Start, this.End);
        //}

    }

    class Program
    {
        private static Dictionary<string, List<string>> graph;
        private static List<Edge> edges;
        private static List<Edge> edgesToRemove;
        private static HashSet<string> visited;
        private static bool isCyclic;

        static void Main()
        {
            edges = new List<Edge>();
            graph = new Dictionary<string, List<string>>();
            edgesToRemove = new List<Edge>();

            GetInput();
            edges.Sort();

            CheckCyclicality();
            Print();

        }

        private static void Print()
        {
            Console.WriteLine($"Edges to remove: {edgesToRemove.Count}");
            foreach (var edge in edgesToRemove)
            {
                Console.WriteLine($"{edge.Start} - {edge.End}");
            }
        }

        private static void CheckCyclicality()
        {
            foreach (Edge edge in edges)
            {
                if (!graph[edge.Start].Contains(edge.End) || !graph[edge.End].Contains(edge.Start))
                {
                    continue;
                }
                graph[edge.Start].Remove(edge.End);
                graph[edge.End].Remove(edge.Start);

                visited = new HashSet<string>();
                isCyclic = false;
                Transverse(edge.Start, edge.End);

                if (isCyclic)
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
                if (startNode == endNode)
                {
                    isCyclic = true;
                }

                visited.Add(startNode);

                for (int i = 0; i < graph[startNode].Count; i++)
                {
                    Transverse(graph[startNode][i], endNode);
                }
            }
        }

        private static void GetInput()
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
                    var splitted = input.Split(' ').ToArray();
                    var nodeStart = splitted[0];
                    var nodeEnds = splitted.Skip(2).ToArray();

                    if (!graph.ContainsKey(nodeStart))
                    {
                        graph.Add(nodeStart, new List<string>());
                    }

                    foreach (var nodeEnd in nodeEnds)
                    {
                        edges.Add(new Edge()
                        {
                            Start = nodeStart,
                            End = nodeEnd
                        });
                        graph[nodeStart].Add(nodeEnd);
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
