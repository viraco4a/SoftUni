using System;
using System.Collections.Generic;
using System.Linq;

namespace GreatestStrategy
{
    class Program
    {
        private static Dictionary<int, HashSet<int>> graph = new Dictionary<int, HashSet<int>>();
        private static Dictionary<int, HashSet<int>> disconnected = new Dictionary<int, HashSet<int>>();

        private static HashSet<int> visited;

        static void Main()
        {
            var input = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var nodeCount = input[0];
            var edgeCount = input[1];
            var startEdge = input[2];
            visited = new HashSet<int>();
            for (int i = 0; i < nodeCount; i++)
            {
                graph[i + 1] = new HashSet<int>();
                disconnected[i + 1] = new HashSet<int>();
            }

            for (int i = 0; i < edgeCount; i++)
            {
                var edgeInput = Console.ReadLine().Split().Select(int.Parse).ToArray();
                var from = edgeInput[0];
                var to = edgeInput[1];

                graph[from].Add(to);
                graph[to].Add(from);

                disconnected[from].Add(to);
                disconnected[to].Add(from);
            }
            var even = Dfs(startEdge, startEdge);

            var max = 0;
            foreach (var node in disconnected.Keys)
            {
                var current = GetValue(node, node, new HashSet<int>());
                if (current > max)
                {
                    max = current;
                }
            }
            Console.WriteLine(max);
        }

        private static int GetValue(int node, int parent, HashSet<int> marked)
        {
            marked.Add(node);

            var value = node;

            foreach (var child in disconnected[node])
            {
                if (!marked.Contains(child) && child != parent)
                {
                    var subValue = GetValue(child, node, new HashSet<int>());
                    value += subValue;
                }
            }
            return value;
        }

        private static int Dfs(int node, int parent)
        {
            visited.Add(node);

            var totalNodes = 1;

            foreach (var child in graph[node])
            {
                if (!visited.Contains(child) && child != parent)
                {
                    var subTreeNodes = Dfs(child, node);
                    if (subTreeNodes % 2 == 0)
                    {
                        disconnected[node].Remove(child);
                        disconnected[child].Remove(node);
                    }
                    totalNodes += subTreeNodes;
                }
            }
            return totalNodes;
        }
    }
}
