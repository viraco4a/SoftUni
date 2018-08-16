using System;
using System.Collections.Generic;
using System.Linq;

public class TopologicalSorter
{

    //private Dictionary<string, int> predecessorCount;

    private HashSet<string> visited;
    private Dictionary<string, List<string>> graph;
    private LinkedList<string> result;
    private HashSet<string> cycleNodes;

    public TopologicalSorter(Dictionary<string, List<string>> graph)
    {
        this.graph = graph;
    }

    public ICollection<string> TopSort()
    {
        //GetPredecessorCount(graph);
        //while (true)
        //{
        //    var nodeToRemove = graph
        //        .Keys
        //        .Where(e => predecessorCount[e] == 0)
        //        .FirstOrDefault();
        //    if (nodeToRemove == null)
        //    {
        //        break;
        //    }

        //    foreach (var child in graph[nodeToRemove])
        //    {
        //        predecessorCount[child]--;
        //    }

        //    graph.Remove(nodeToRemove);
        //    sorted.Add(nodeToRemove);

        //}
        result = new LinkedList<string>();
        visited = new HashSet<string>();
        cycleNodes = new HashSet<string>();

        foreach (var node in graph.Keys)
        {
            DFS(node);
        }

        //TODO ADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
        //if (graph.Count > 0)
        //{
        //    throw new InvalidOperationException();
        //}

        return result;
    }

    private void DFS(string node)
    {
        if (cycleNodes.Contains(node))
        {
            throw new InvalidOperationException("Cycle detected.");
        }
        if (!visited.Contains(node))
        {
            visited.Add(node);
            cycleNodes.Add(node);
            foreach (var child in graph[node])
            {
                DFS(child);
            }
            cycleNodes.Remove(node);
            result.AddFirst(node);
        }
    }

    //private void GetPredecessorCount(Dictionary<string, List<string>> graph)
    //{
    //    predecessorCount = new Dictionary<string, int>();

    //    foreach (var node in graph)
    //    {
    //        if (!predecessorCount.ContainsKey(node.Key))
    //        {
    //            predecessorCount[node.Key] = 0;
    //        }

    //        foreach (var child in node.Value)
    //        {
    //            if (!predecessorCount.ContainsKey(child))
    //            {
    //                predecessorCount[child] = 0;
    //            }

    //            predecessorCount[child]++;
    //        }
    //    }
    //}

}
