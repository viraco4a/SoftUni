using System;
using System.Collections.Generic;
using System.Linq;

namespace ModifiedKruksal
{
    class Node
    {
        public Node(int id)
        {
            this.id = id;
            this.Parent = id;
            this.Children = new HashSet<int>();
        }

        public int id { get; set; }

        public int Parent { get; set; }

        public HashSet<int> Children { get; set; }

    }

    class Edge : IComparable<Edge>
    {
        public int StartNode { get; set; }

        public int EndNode { get; set; }

        public int Weight { get; set; }

        public int CompareTo(Edge other)
        {
            var comparator = this.Weight.CompareTo(other.Weight);
            return comparator;
        }
    }

    class KruksalAlgorithm
    {
        public static List<Edge> Kruksal(Dictionary<int, Node> nodes, List<Edge> edges)
        {
            edges.Sort();
            var spanningTree = new List<Edge>();
            foreach (var edge in edges)
            {
                Node firstRoot = FindRoot(edge.StartNode, nodes);
                Node secondRoot = FindRoot(edge.EndNode, nodes);

                if (firstRoot.id != secondRoot.id)
                {
                    spanningTree.Add(edge);
                    firstRoot.Parent = secondRoot.Parent;
                }
            }

            return spanningTree;
        }

        private static Node FindRoot(int node, Dictionary<int, Node> nodes)
        {
            int root = node;
            while (nodes[root].Parent != root)
            {
                root = nodes[root].Parent;
            }

            while (node != root)
            {
                int oldParent = nodes[node].Parent;
                nodes[node].Parent = root;
                node = oldParent;
            }

            return nodes[root];
        }
    }

    class Program
    {
        static void Main()
        {
            var nodeCount = int.Parse(Console.ReadLine().Split()[1]);
            var edgeCount = int.Parse(Console.ReadLine().Split()[1]);
            var nodes = new Dictionary<int, Node>();
            var edges = new List<Edge>();
            for (int i = 0; i < edgeCount; i++)
            {
                var input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                edges.Add(new Edge
                {
                    StartNode = input[0],
                    EndNode = input[1],
                    Weight = input[2]
                });

                if (!nodes.ContainsKey(input[0]))
                {
                    nodes[input[0]] = new Node(input[0]);
                }

                if (!nodes.ContainsKey(input[1]))
                {
                    nodes[input[1]] = new Node(input[1]);
                }
            }

            var minSpanForrest = KruksalAlgorithm.Kruksal(nodes, edges);
            Console.WriteLine($"Minimum spanning forest weight: {minSpanForrest.Sum(s => s.Weight)}");
        }
    }
}
