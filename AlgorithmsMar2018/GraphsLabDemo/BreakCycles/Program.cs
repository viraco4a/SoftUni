using System;
using System.Collections.Generic;
using System.Linq;

namespace BreakCycles
{
    class Program
    {
        private static SortedDictionary<string, List<string>> graph;
        private static Dictionary<string, string> edgesToRemove;
        private static Dictionary<string, bool> visited;

        static void Main()
        {
            graph = new SortedDictionary<string, List<string>>();
            edgesToRemove = new Dictionary<string, string>();

            while (true)
            {
                string input = Console.ReadLine();
                if (input == string.Empty)
                {
                    break;
                }
                var splitted = input.Split(' ').ToArray();
                var node = splitted[0];
                if (!graph.ContainsKey(node))
                {
                    graph.Add(node, splitted.Skip(2).ToList());
                }
            }

            visited = new Dictionary<string, bool>();

            foreach (var node in graph.ToArray())
            {
                var buffer = graph[node.Key];
                graph.Remove(node.Key);
                BFS(node.Key);
                if (graph.Count )
                {

                }

            }

        }

        private static void BFS(string node)
        {
            if (visited[node])
            {
                return;
            }
            
            var queue = new Queue<string>();
            queue.Enqueue(node);
            visited[node] = true;

            while (queue.Count != 0)
            {
                var currentNode = queue.Dequeue();
                
                foreach (var child in graph[currentNode])
                {
                    if (!visited[child])
                    {
                        queue.Enqueue(child);
                        visited[child] = true;
                    }
                }
            }
        }
    }
}
