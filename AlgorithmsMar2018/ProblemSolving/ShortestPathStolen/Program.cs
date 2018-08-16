using System;
using System.Collections.Generic;
using System.Linq;

class ShortestPathInMatrix
{
    static void Main()
    {
        int rows = int.Parse(Console.ReadLine());
        int cols = int.Parse(Console.ReadLine());
        int[,] matrix = new int[rows, cols];
        for (int i = 0; i < rows; i++)
        {
            var values = Console.ReadLine().Split().Select(int.Parse).ToArray();
            for (int j = 0; j < values.Length; j++)
            {
                matrix[i, j] = values[j];
            }
        }
        var graph = BuildGraphAdjacencyMatrix(matrix);
        var nodesPath = DijkstraAlgorithm(graph, 0, matrix.GetLength(0) * matrix.GetLength(1) - 1);

        var result = (from n in nodesPath
                      let row = n / matrix.GetLength(1)
                      let col = n % matrix.GetLength(1)
                      select matrix[row, col]).ToList();
        Console.WriteLine("Length: {0}", result.Sum());
        Console.WriteLine("Path: {0}", String.Join(" ", result));
    }

    private static int[,] BuildGraphAdjacencyMatrix(int[,] matrix)
    {
        int rows = matrix.GetLength(0);
        int cols = matrix.GetLength(1);
        int[] directions = { 0, -1, -1, 0, 0, 1, 1, 0 };
        var graph = new int[rows * cols, rows * cols];
        for (int row = 0; row < matrix.GetLength(0); row++)
        {
            for (int col = 0; col < matrix.GetLength(1); col++)
            {

                for (int k = 0; k < directions.Length; k += 2)
                {
                    int childRow = row + directions[k];
                    int childCol = col + directions[k + 1];

                    if (childRow >= 0 && childRow < rows && childCol >= 0 && childCol < cols)
                    {
                        var parentNode = row * matrix.GetLength(1) + col;
                        var childNode = childRow * matrix.GetLength(1) + childCol;
                        graph[parentNode, childNode] = matrix[childRow, childCol];
                        graph[parentNode, parentNode] = 0;
                    }
                }
            }
        }

        return graph;
    }

    private static List<int> DijkstraAlgorithm(int[,] graph, int sourceNode, int destinationNode)
    {
        int n = graph.GetLength(0);
        int[] distance = new int[n];
        for (int i = 0; i < distance.Length; i++)
        {
            distance[i] = int.MaxValue;
        }
        distance[sourceNode] = 0;

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

        if (distance[destinationNode] == int.MaxValue)
        {
            return null;
        }

        var path = new Stack<int>();
        int? currentNode = destinationNode;
        while (currentNode != null)
        {
            path.Push(currentNode.Value);
            currentNode = previous[currentNode.Value];
        }
        return path.ToList();
    }
}