using System;
using System.Collections.Generic;
using System.Linq;

namespace CyclesInGraph
{
    class Program
    {
        private static Dictionary<string, List<string>> graph;

        static void Main()
        {
            ReadGraph();
            //var nodes = new HashSet<string>();
            //HashSet<string> nodesWithIncomingEdges = GetNodes();

            //foreach (var nod in graph.Keys)
            //{
            //    if (!nodesWithIncomingEdges.Contains(nod))
            //    {
            //        nodes.Add(nod);
            //    }
            //}

            var predCount = new Dictionary<string, int>();
            foreach (var node in graph)
            {
                if (!predCount.ContainsKey(node.Key))
                {
                    predCount[node.Key] = 0;
                }

                foreach (var child in node.Value)
                {
                    if (!predCount.ContainsKey(child))
                    {
                        predCount[child] = 0;
                    }

                    predCount[child]++;
                }
            }

            while (true)
            {
                var nodeToRemove = graph.Keys.FirstOrDefault(n => predCount[n] <= 1);
                if (nodeToRemove == null)
                {
                    break;
                }

                foreach (var vertex in graph[nodeToRemove])
                {
                    predCount[vertex]--;
                    graph[vertex].Remove(nodeToRemove);
                }

                graph.Remove(nodeToRemove);

                if (graph.Count > 0)
                {
                    Console.WriteLine("Acyclic: No");
                    return;
                }
                Console.WriteLine("Acyclic: Yes");
            }

            //while (nodes.Count != 0)
            //{
            //    var currentNode = nodes.First();
            //    nodes.Remove(currentNode);

            //    var children = graph[currentNode].ToList();
            //    graph[currentNode] = new List<string>();

            //    var leftNodesWithIncomingEdges = GetNodes();

            //    foreach (var child in children)
            //    {
            //        if (!leftNodesWithIncomingEdges.Contains(child))
            //        {
            //            nodes.Add(child);
            //        }
            //    }
            //}

            //if (graph.SelectMany(s => s.Value).ToList().Any())
            //{
            //    Console.WriteLine("Acyclic: No");
            //}
            //else
            //{
            //    Console.WriteLine("Acyclic: Yes");
            //}
        }

        //private static HashSet<string> GetNodes()
        //{
        //    var nodesWithIncomingEdges = new HashSet<string>();
        //    graph
        //        .SelectMany(s => s.Value)
        //        .ToList()
        //        .ForEach(e => nodesWithIncomingEdges.Add(e));
        //    return nodesWithIncomingEdges;
        //}

        private static void ReadGraph()
        {
            string input = Console.ReadLine();
            graph = new Dictionary<string, List<string>>();
            while (true)
            {
                try
                {
                    var splitted = input.Split(new char[] { '–', '-' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                    if (!graph.ContainsKey(splitted[0]))
                    {
                        graph.Add(splitted[0], new List<string>());
                    }
                    if (!graph.ContainsKey(splitted[1]))
                    {
                        graph.Add(splitted[1], new List<string>());
                    }
                    if (!graph[splitted[0]].Contains(splitted[1]))
                    {
                        graph[splitted[0]].Add(splitted[1]);
                    }
                    if (!graph[splitted[1]].Contains(splitted[0]))
                    {
                        graph[splitted[1]].Add(splitted[0]);
                    }
                }
                catch (Exception)
                {
                    break;
                }


                input = Console.ReadLine();
            }
        }
    }
}
