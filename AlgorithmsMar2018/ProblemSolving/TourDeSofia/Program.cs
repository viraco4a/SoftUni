using System;
using System.Collections.Generic;
using System.Linq;

namespace TourDeSofia
{
    class Program
    {
        private static HashSet<int>[] graph;
        private static int[] distTo;
        private static bool[] marked;

        static void Main()
        {
            var nodeCount = int.Parse(Console.ReadLine());
            var streetCount = int.Parse(Console.ReadLine());
            var start = int.Parse(Console.ReadLine());
            distTo = new int[nodeCount];
            marked = new bool[nodeCount];

            graph = new HashSet<int>[nodeCount];
            for (int i = 0; i < nodeCount; i++) //to graph.Length
            {
                graph[i] = new HashSet<int>();
            }

            for (int i = 0; i < streetCount; i++)
            {
                var edge = Console.ReadLine().Split().Select(int.Parse).ToArray();
                graph[edge[0]].Add(edge[1]);
            }

            BFS(start);

            bool found = false;
            int min = int.MaxValue;
            for (int i = 0; i < graph.Length; i++)
            {
                if (graph[i].Contains(start) && marked[i] && distTo[i] + 1 < min)
                {
                    found = true;
                    min = distTo[i] + 1;
                }
            }
            if (found)
            {
                Console.WriteLine(min);
            }
            else
            {
                //Console.WriteLine(distTo.Max() + 1);
                Console.WriteLine(marked.Where(x => x).Count());
            }
        }

        private static void BFS(int source)
        {
            Queue<int> queue = new Queue<int>();

            queue.Enqueue(source);
            distTo[source] = 0;
            marked[source] = true;

            while (queue.Count > 0)
            {
                int current = queue.Dequeue();
                foreach (var child in graph[current])
                {
                    if (!marked[child])
                    {
                        queue.Enqueue(child);
                        marked[child] = true;
                        distTo[child] = distTo[current] + 1;
                    }
                }
            }
        }
    }
}
