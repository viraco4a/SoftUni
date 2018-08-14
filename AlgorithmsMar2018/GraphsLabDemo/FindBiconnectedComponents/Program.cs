using System;
using System.Collections.Generic;
using System.Linq;

namespace FindBiconnectedComponents
{
    class Program
    {
        private static List<int>[] graph;
        private static bool[] visited;
        private static int[] depths;
        private static int[] lowpoint;
        private static int?[] parents;
        private static List<int> articulationPoints;
        private static int biConnectedCompCount;

        static void Main()
        {
            int nodeCount = int.Parse(Console.ReadLine().Split()[1]);
            int edgeCount = int.Parse(Console.ReadLine().Split()[1]);

            graph = new List<int>[nodeCount];

            for (int i = 0; i < nodeCount; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < edgeCount; i++)
            {
                var input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                graph[input[0]].Add(input[1]);
                graph[input[1]].Add(input[0]);
            }

            visited = new bool[graph.Length];
            depths = new int[graph.Length];
            lowpoint = new int[graph.Length];
            parents = new int?[graph.Length];
            articulationPoints = new List<int>();

            for (int node = 0; node < graph.Length; node++)
            {
                if (!visited[node])
                {
                    FindArticulationPoints(node, 1);
                }
            }

            for (int node = 0; node < graph.Length; node++)
            {
                if (articulationPoints.Contains(node))
                {
                    foreach (var child in graph[node])
                    {

                        biConnectedCompCount++;
                        break;
                    }
                }
            }

            if (articulationPoints.Count != 0)
            {
                biConnectedCompCount--;
            }
            else
            {
                biConnectedCompCount = 1;
            }

            Console.WriteLine($"Number of bi-connected components: {biConnectedCompCount}");
        }

        private static void FindArticulationPoints(int node, int depth)
        {
            visited[node] = true;
            depths[node] = depth;
            lowpoint[node] = depth;

            int childCount = 0;
            bool isArticulation = false;

            foreach (var child in graph[node])
            {
                if (!visited[child])
                {
                    parents[child] = node;
                    FindArticulationPoints(child, depth + 1);
                    childCount++;

                    if (lowpoint[child] >= depths[node])
                    {
                        isArticulation = true;
                    }

                    lowpoint[node] = Math.Min(lowpoint[node], lowpoint[child]);
                }
                else if (child != parents[node])
                {
                    lowpoint[node] = Math.Min(lowpoint[node], depths[child]);
                }
            }

            if ((parents[node] == null && childCount > 1)
                || (parents[node] != null && isArticulation))
            {
                articulationPoints.Add(node);
                biConnectedCompCount++;
            }
        }
    }
}
