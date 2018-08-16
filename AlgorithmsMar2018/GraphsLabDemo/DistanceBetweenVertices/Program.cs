using System;
using System.Linq;
using System.Collections.Generic;

namespace DistanceBetweenVertices
{
    class Program
    {

        private static List<int>[] graph;
        private static bool[] visited;
        private static Dictionary<int, int> dictForNodes;
        private static List<int[]> listOfPairs;
        private static int[] levels;


        static void Main()
        {
            int nodeCount = int.Parse(Console.ReadLine());
            int pairsCount = int.Parse(Console.ReadLine());

            dictForNodes = new Dictionary<int, int>();
            listOfPairs = new List<int[]>();
            graph = new List<int>[nodeCount];

            for (int i = 0; i < nodeCount; i++)
            {
                var input = Console.ReadLine().Split(':').ToArray();
                dictForNodes.Add(int.Parse(input[0]), i);
                if (input[1] == string.Empty)
                {
                    graph[i] = new List<int>() { };
                    continue;
                }
                graph[i] = input[1].Split(' ').Select(int.Parse).ToList();
            }

            for (int i = 0; i < pairsCount; i++)
            {
                var input = Console.ReadLine().Split('-').Select(int.Parse).ToArray();
                listOfPairs.Add(input);
            }

            foreach (var pair in listOfPairs)
            {
                Console.Write("{" + $"{pair[0]}, {pair[1]}" + "} -> ");
                visited = new bool[graph.Length];
                levels = new int[graph.Length];
                BFS(pair[0], pair[1]);
            }
        }

        private static void BFS(int node, int target)
        {
            node = dictForNodes[node];
            target = dictForNodes[target];
            levels[node] = 0;
            visited[node] = true;
            var queue = new Queue<int>();
            queue.Enqueue(node);
            
            while (queue.Count != 0)
            {
                var currentNode = queue.Dequeue();
                
                foreach (var child in graph[currentNode])
                {
                    var realChild = dictForNodes[child];
                    if (!visited[realChild])
                    {
                        levels[realChild] = levels[currentNode] + 1;
                        queue.Enqueue(realChild);
                        visited[realChild] = true;
                        if (realChild == target)
                        {
                            Console.Write(levels[target]);
                            Console.WriteLine();
                            return;
                        }
                    }
                }
            }

            Console.Write(-1);
            Console.WriteLine();
        }
    }
}
