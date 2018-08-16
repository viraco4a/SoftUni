using System;
using System.Collections.Generic;
using System.Linq;

namespace ShortestPathDijstraPractice
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

            CreateGraph();

            DijkstraAlgorithm(0, cols * rows - 1);

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
            var n = graph.GetLength(0);
            var distances = new int[n];
            for (int i = 0; i < n; i++)
            {
                distances[i] = int.MaxValue;
            }

            distances[sourceNode] = 0;
            var used = new bool[n];
            var prev = new int?[n];

            while (true)
            {
                int minDistance = int.MaxValue;
                int minNode = 0;

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
                    if (graph[minNode, i] != 0) // we have an edge
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

        private static void CreateGraph()
        {
            var directions = new int[] { 0, -1, -1, 0, 0, 1, 1, 0 };
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
