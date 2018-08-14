using System;
using System.Collections.Generic;
using System.Linq;

namespace ShortestPathDijkstra
{
    class Program
    {
        private static int[,] matrix;
        private static int[,] graph;
        private static List<int> path;
        private static int rows;
        private static int cols;

        static void Main()
        {
            ReadInput();

            BuildGraph(rows, cols);

            DijkstraAlgo(0, cols * rows - 1);

            var result = new List<int>();
            foreach (var item in path)
            {
                var row = item / cols;
                var col = item % cols;
                result.Add(matrix[row, col]);
            }

            Console.WriteLine("Length: {0}", result.Sum());
            Console.WriteLine("Path: {0}", string.Join(" ", result));
        }

        private static void DijkstraAlgo(int source, int destination)
        {
            int n = graph.GetLength(0);
            int[] distance = new int[n];
            for (int i = 0; i < n; i++)
            {
                distance[i] = int.MaxValue;
            }

            distance[source] = 0;
            var used = new bool[n];
            var previous = new int?[n];

            while (true)
            {
                int minDistance = int.MaxValue;
                int minNode = 0;

                for (int node = 0; node < n; node++)
                {
                    if (!used[node] && distance[node] < minDistance)
                    {
                        minDistance = distance[node];
                        minNode = node;
                    }
                }

                if (minDistance == int.MaxValue)
                {
                    break;
                }

                used[minNode] = true;

                for (int i = 0; i < n; i++)
                {
                    if (graph[minNode, i] != 0)
                    {
                        int newDistance = distance[minNode] + graph[minNode, i];
                        if (newDistance < distance[i])
                        {
                            distance[i] = newDistance;
                            previous[i] = minNode;
                        }
                    }
                }
            }

            var pathStack = new Stack<int>();
            int? currentNode = destination;
            while (currentNode != null)
            {
                pathStack.Push(currentNode.Value);
                currentNode = previous[currentNode.Value];
            }

            path = pathStack.ToList();
        }

        private static void ReadInput()
        {
            rows = int.Parse(Console.ReadLine());
            cols = int.Parse(Console.ReadLine());
            matrix = new int[rows, cols];
            path = new List<int>(cols);
            for (int row = 0; row < rows; row++)
            {
                var input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = input[col];
                }
            }
        }

        private static void BuildGraph(int rows, int cols)
        {
            int[] directions = { 0, -1, -1, 0, 0, 1, 1, 0 };
            graph = new int[rows * cols, rows * cols];

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    for (int i = 0; i < directions.Length; i += 2)
                    {
                        int childRow = row + directions[i];
                        int childCol = col + directions[i + 1];

                        if (childRow >= 0 && childRow < rows && childCol >= 0 && childCol < cols)
                        {
                            var parentNode = row * cols + col;
                            var childNode = childRow * cols + childCol;

                            graph[parentNode, childNode] = matrix[childRow, childCol];
                            graph[parentNode, parentNode] = 0;
                        }
                    }
                }
            }
        }

    }
}
