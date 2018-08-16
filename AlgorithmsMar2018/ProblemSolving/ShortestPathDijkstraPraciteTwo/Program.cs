using System;
using System.Collections.Generic;
using System.Linq;

namespace ShortestPathDijkstraPraciteTwo
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

            CreatGraph();

            DijkstraAlgorithm(0, rows * cols - 1);

            var result = new List<int>();
            foreach (var item in path)
            {
                var row = item / cols;
                var col = item % cols;
                result.Add(matrix[row, col]);
            }
            Console.WriteLine($"Length: {result.Sum()}");
            Console.WriteLine($"Path: {string.Join(" ", result)}");
        }

        private static void DijkstraAlgorithm(int sourceNode, int destinationNode)
        {
            int n = graph.GetLength(0);
            var distances = new int[n];
            var prev = new int?[n];
            var used = new bool[n];

            for (int i = 0; i < n; i++)
            {
                distances[i] = int.MaxValue;
            }
            distances[sourceNode] = 0;

            while (true)
            {
                var minDistance = int.MaxValue;
                var minNode = 0;
                for (int node = 0; node < n; node++)
                {
                    if (!used[node] && distances[node] < minDistance)
                    {
                        minDistance = distances[node];
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
                        int newDistance = distances[minNode] + graph[minNode, i];
                        if (newDistance < distances[i])
                        {
                            distances[i] = newDistance;
                            prev[i] = minNode;
                        }
                    }
                }

            }

            var pathStack = new Stack<int>();
            int? currentNode = destinationNode;
            while (currentNode != null)
            {
                pathStack.Push(currentNode.Value);
                currentNode = prev[currentNode.Value];
            }

            path = pathStack.ToList();
        }

        private static void CreatGraph()
        {
            graph = new int[rows * cols, rows * cols];
            var directions = new int[] { 0, -1, -1, 0, 0, 1, 1, 0 };

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    for (int i = 0; i < directions.Length; i += 2)
                    {
                        var childRow = row + directions[i];
                        var childCol = col + directions[i + 1];

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

        private static void ReadInput()
        {
            rows = int.Parse(Console.ReadLine());
            cols = int.Parse(Console.ReadLine());
            matrix = new int[rows, cols];
            path = new List<int>();

            for (int row = 0; row < rows; row++)
            {
                var input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = input[col];
                }
            }
        }
    }
}
