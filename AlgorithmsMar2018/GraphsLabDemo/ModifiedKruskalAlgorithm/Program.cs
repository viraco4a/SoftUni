using System;
using System.Linq;
using System.Collections.Generic;

namespace ModifiedKruskalAlgorithm
{
    class Node
    {
        public Node(int id)
        {
            this.Id = id;
            this.Parent = id;
            this.Children = new HashSet<int>();
        }

        public int Id { get; set; }

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
            int weightCompared = this.Weight.CompareTo(other.Weight);
            return weightCompared;
        }

        //public override string ToString()
        //{
        //    return $"({this.StartNode} {this.EndNode}) -> {this.Weight}";
        //}
    }

    class KruskalAlgorithm
    {
        public static List<Edge> Kruskal(Dictionary<int, Node> nodes, List<Edge> edges)
        {
            edges.Sort();
            var spanningTree = new List<Edge>();
            foreach (var edge in edges)
            {
                Node rootStartNode = FindRoot(edge.StartNode, nodes);
                Node rootEndNode = FindRoot(edge.EndNode, nodes);
                if (rootStartNode.Id != rootEndNode.Id)
                {
                    spanningTree.Add(edge);
                    rootStartNode.Parent = rootEndNode.Parent;
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
            var nodeCount = int.Parse(Console.ReadLine().Split(' ')[1]);
            var edgeCount = int.Parse(Console.ReadLine().Split(' ')[1]);

            var edges = new List<Edge>();
            var nodes = new Dictionary<int, Node>();

            for (int i = 0; i < edgeCount; i++)
            {
                var edgeParts = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
                edges.Add(new Edge
                {
                    StartNode = edgeParts[0],
                    EndNode = edgeParts[1],
                    Weight = edgeParts[2]
                });

                if (!nodes.ContainsKey(edgeParts[0]))
                {
                    nodes.Add(edgeParts[0], new Node(edgeParts[0]));
                }

                if (!nodes.ContainsKey(edgeParts[1]))
                {
                    nodes.Add(edgeParts[1], new Node(edgeParts[1]));
                }
            }

            var minimumSpanningForrest = KruskalAlgorithm.Kruskal(nodes, edges);
            Console.WriteLine($"Minimum spanning forest weight: {minimumSpanningForrest.Sum(s => s.Weight)}");

            //foreach (var edge in minimumSpanningForrest)
            //{
            //    Console.WriteLine(edge);
            //}
        }
    }
}
