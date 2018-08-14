using System;
using System.Collections.Generic;

public class ArticulationPoints
{
    private static List<int>[] graph;
    private static bool[] visited;
    private static int[] depths;
    private static int[] lowpoint;
    private static int?[] parents;
    private static List<int> articulationPoints;

    public static List<int> FindArticulationPoints(List<int>[] targetGraph)
    {
        graph = targetGraph;
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

        return articulationPoints;
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
        }
    }
}
