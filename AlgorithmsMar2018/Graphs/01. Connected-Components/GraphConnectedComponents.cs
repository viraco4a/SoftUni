using System;
using System.Collections.Generic;
using System.Linq;

public class GraphConnectedComponents
{

    private static bool[] visited;

    static List<int>[] graph;

    public static void Main()
    {
        graph = ReadGraph();
        
        FindGraphConnectedComponents();
    }

    private static List<int>[] ReadGraph()
    {
        int n = int.Parse(Console.ReadLine());
        var graph = new List<int>[n];
        for (int i = 0; i < n; i++)
        {
            graph[i] = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToList();
        }
        return graph;
    }

    private static void DFS(int node)
    {
        if (!visited[node])
        {
            visited[node] = true;
            foreach (var child in graph[node])
            {
                DFS(child);
            }
            Console.Write($" {node}");
        }
    }

    private static void FindGraphConnectedComponents()
    {
        visited = new bool[graph.Length];

        for (int startNode = 0; startNode < visited.Length; startNode++)
        {
            if (!visited[startNode])
            {
                Console.Write("Connected component:");
                DFS(startNode);
                Console.WriteLine();
            }
        }
    }
}
