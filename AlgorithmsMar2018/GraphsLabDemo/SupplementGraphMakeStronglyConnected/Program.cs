using System;
using System.Collections.Generic;
using System.Linq;

namespace SupplementGraphMakeStronglyConnected
{
    class Program
    {
        private static List<int>[] graph;
        private static List<int> listOfGraphsWithNoExits;
        private static List<int> listOfGraphsWithNoEntrance;
        private static List<List<int>> listOfIsolatedGraphs;
        private static List<List<int>> listOfComplexSubGraphs;

        private static int edgesNeeded;
        private static int neededExits;
        private static int neededEntrances;

        static void Main()
        {
            ReadTheStartingGraph();

            var strConnComp = StronglyConnectedComponents.FindStronglyConnectedComponents(graph);

            //PrintCurrentStronglyConnectedComponents(strConnComp);

            LiftOfNodesNoExitOrEnter();

            IsolatedSubGraph(strConnComp);

            ComplexSubgraphs(strConnComp);

            edgesNeeded = Math.Max(neededEntrances, neededExits) + listOfIsolatedGraphs.Count;

            var result = new Dictionary<int, int>();
            for (int i = 0; i < edgesNeeded; i++)
            {
                foreach (var nodeNoExit in listOfGraphsWithNoExits.ToList())
                {
                    foreach (var nodeNoEntrance in listOfIsolatedGraphs.ToList())
                    {
                        if (!result.ContainsKey(nodeNoExit))
                        {
                            result.Add(nodeNoExit, nodeNoEntrance.First());
                            graph[nodeNoExit].Add(nodeNoEntrance.First());
                            listOfGraphsWithNoExits.Remove(nodeNoExit);
                        }
                    }
                }
                foreach (var nodeNoExit in listOfIsolatedGraphs.ToList())
                {
                    foreach (var nodeNoEntrance in listOfGraphsWithNoEntrance.ToList())
                    {
                        if (!result.ContainsKey(nodeNoExit.Last()))
                        {
                            result.Add(nodeNoExit.Last(), nodeNoEntrance);
                            graph[nodeNoExit.Last()].Add(nodeNoEntrance);
                            listOfIsolatedGraphs.Remove(nodeNoExit);
                            listOfGraphsWithNoEntrance.Remove(nodeNoEntrance);
                        }
                    }
                }

                var nextNodeInput = result.Last().Value;

                var nextInput = graph[nextNodeInput].Last();

                var nextSubGraph = new List<int>();

                foreach (var subGraph in listOfComplexSubGraphs)
                {
                    if (subGraph.Contains(nextInput))
                    {
                        nextSubGraph = subGraph;
                        break;
                    }
                }

                var lastSubGraph = new List<int>();
                
                




                //foreach (var nodeNoExit in listOfGraphsWithNoExits.ToList())
                //{
                //    foreach (var nodeNoEntrance in listOfComplexSubGraphs.ToList())
                //    {
                //        var exitPoints = graph[nodeNoExit];
                //        foreach (var node in exitPoints)
                //        {
                //            if (nodeNoEntrance.Contains(node))
                //            {
                //                var nodeOfInterest = node;
                //                if (!result.ContainsKey(nodeNoExit))
                //                {
                //                    result.Add(nodeNoExit, nodeOfInterest);
                //                    graph[nodeNoExit].Add(nodeOfInterest);
                //                    listOfGraphsWithNoExits.Remove(nodeNoExit);
                //                }
                //            }
                //        }

                //    }
                //}

                //foreach (var nodeNoExit in listOfComplexSubGraphs.ToList())
                //{
                //    foreach (var nodeNoEntrance in listOfGraphsWithNoEntrance.ToList())
                //    {
                //        foreach (var node in nodeNoExit)
                //        {
                //            var interestingNodes = graph[node];
                //            bool internalNode = true;
                //            foreach (var interesting in interestingNodes)
                //            {
                //                if (!nodeNoExit.Contains(interesting))
                //                {
                //                    internalNode = false;
                //                    break;
                //                }
                //            }
                //            if (!result.ContainsKey(node) && !internalNode)
                //            {
                //                result.Add(node, nodeNoEntrance);
                //                graph[node].Add(nodeNoEntrance);
                //                listOfGraphsWithNoEntrance.Remove(nodeNoEntrance);
                //                break;
                //            }
                //        }
                //    }
                //}
            }
            Console.WriteLine($"New edges needed: {edgesNeeded}");
            foreach (var edge in result)
            {
                Console.WriteLine($"{edge.Key} -> {edge.Value}");
            }
        }

        private static void ComplexSubgraphs(List<List<int>> strConnComp)
        {
            listOfComplexSubGraphs = new List<List<int>>();
            foreach (var subgraph in strConnComp)
            {
                if (!listOfIsolatedGraphs.Contains(subgraph))
                {
                    bool isComplex = true;
                    foreach (var node in listOfGraphsWithNoEntrance)
                    {
                        if (subgraph.Contains(node))
                        {
                            isComplex = false;
                            break;
                        }
                    }
                    if (isComplex)
                    {
                        foreach (var node in listOfGraphsWithNoExits)
                        {
                            if (subgraph.Contains(node))
                            {
                                isComplex = false;
                                break;
                            }
                        }
                    }
                    if (isComplex)
                    {
                        listOfComplexSubGraphs.Add(subgraph);
                    }
                }
            }
        }

        private static void IsolatedSubGraph(List<List<int>> strConnComp)
        {
            listOfIsolatedGraphs = new List<List<int>>();
            //TODO: find isolated strongly connected subGraph
            listOfIsolatedGraphs.Add(strConnComp[2]);
        }

        private static void LiftOfNodesNoExitOrEnter()
        {
            listOfGraphsWithNoExits = new List<int>();
            listOfGraphsWithNoEntrance = new List<int>();

            for (int i = 0; i < graph.Length; i++)
            {
                if (graph[i].Count == 0)
                {
                    listOfGraphsWithNoExits.Add(i);
                    neededExits++;
                    continue;
                }
                bool hasEntrance = false;
                foreach (var node in graph)
                {
                    if (node.Contains(i))
                    {
                        hasEntrance = true;
                        break;
                    }
                }
                if (!hasEntrance)
                {
                    listOfGraphsWithNoEntrance.Add(i);
                    neededEntrances++;
                    continue;
                }
            }
        }

        private static void ReadTheStartingGraph()
        {
            int nodeCount = int.Parse(Console.ReadLine().Split(' ')[1]);
            int edgeCount = int.Parse(Console.ReadLine().Split(' ')[1]);
            graph = new List<int>[nodeCount];

            for (int i = 0; i < nodeCount; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < edgeCount; i++)
            {
                var input = Console.ReadLine().Split(' ');
                if (input[0] == input[2])
                {
                    continue;
                }
                graph[int.Parse(input[0])].Add(int.Parse(input[2]));
            }
        }

        private static void PrintCurrentStronglyConnectedComponents(List<List<int>> result)
        {
            Console.WriteLine("Strongly Connected Components:");
            foreach (var component in result)
            {
                Console.WriteLine("{{{0}}}", string.Join(", ", component));
            }
        }
    }

    public class StronglyConnectedComponents
    {
        private static List<int>[] graph;
        private static List<int>[] reversedGraph;
        private static bool[] visited;

        private static Stack<int> stack = new Stack<int>();

        private static List<List<int>> stronglyConnectedComponents;

        public static List<List<int>> FindStronglyConnectedComponents(List<int>[] targetGraph)
        {
            graph = targetGraph;
            visited = new bool[graph.Length];
            BuildReverseGraph();

            for (int node = 0; node < graph.Length; node++)
            {
                if (!visited[node])
                {
                    Dfs(node);
                }
            }

            stronglyConnectedComponents = new List<List<int>>();

            visited = new bool[graph.Length];

            while (stack.Count > 0)
            {
                var node = stack.Pop();
                if (!visited[node])
                {
                    stronglyConnectedComponents.Add(new List<int>());
                    ReverseDfs(node);
                }
            }

            return stronglyConnectedComponents;
        }

        private static void BuildReverseGraph()
        {
            reversedGraph = new List<int>[graph.Length];

            for (int node = 0; node < reversedGraph.Length; node++)
            {
                reversedGraph[node] = new List<int>();
            }

            for (int node = 0; node < graph.Length; node++)
            {
                foreach (var child in graph[node])
                {
                    reversedGraph[child].Add(node);
                }
            }
        }

        private static void ReverseDfs(int node)
        {
            if (!visited[node])
            {
                visited[node] = true;
                stronglyConnectedComponents.Last().Add(node);

                foreach (var child in reversedGraph[node])
                {
                    ReverseDfs(child);
                }
            }
        }

        private static void Dfs(int node)
        {
            if (!visited[node])
            {
                visited[node] = true;

                foreach (var child in graph[node])
                {
                    Dfs(child);
                }

                stack.Push(node);
            }
        }
    }
}
