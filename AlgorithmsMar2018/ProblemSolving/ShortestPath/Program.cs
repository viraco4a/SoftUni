using System;
using System.Collections.Generic;
using System.Linq;

namespace ShortestPath
{
    class Program
    {
        private static int[][] graph;

        private static int[,] minPath;

        private static bool[,] visited;

        //private static int[,] prev;

        static void Main()
        {
            int numberOfRows = int.Parse(Console.ReadLine());
            int numberOfColumns = int.Parse(Console.ReadLine());
            graph = new int[numberOfRows][];

            for (int row = 0; row < numberOfRows; row++)
            {
                graph[row] = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            }

            minPath = new int[numberOfRows, numberOfColumns];

            for (int row = 0; row < numberOfRows; row++)
            {
                for (int col = 0; col < numberOfColumns; col++)
                {
                    minPath[row, col] = int.MaxValue;
                }
            }

            minPath[0, 0] = graph[0][0];

            visited = new bool[numberOfRows, numberOfColumns];

            //prev = new int[numberOfRows, numberOfColumns];

            while (true)
            {
                int[] currentCell = FindSmallestCell();

                if (currentCell == null || (currentCell[0] == numberOfRows - 1 && currentCell[1] == numberOfColumns - 1))
                {
                    break;
                }

                int row = currentCell[0];
                int col = currentCell[1];
                visited[row, col] = true;

                if (IsInRange(row - 1, col, numberOfRows, numberOfColumns) 
                    && !visited[row - 1, col]
                    && minPath[row, col] + graph[row - 1][col] < minPath[row - 1, col])
                {
                    minPath[row - 1, col] = minPath[row, col] + graph[row - 1][col];
                }

                if (IsInRange(row, col + 1, numberOfRows, numberOfColumns)
                    && !visited[row, col + 1]
                    && minPath[row, col] + graph[row][col + 1] < minPath[row, col + 1])
                {
                    minPath[row, col + 1] = minPath[row, col] + graph[row][col + 1];
                }

                if (IsInRange(row + 1, col, numberOfRows, numberOfColumns)
                    && !visited[row + 1, col]
                    && minPath[row, col] + graph[row + 1][col] < minPath[row + 1, col])
                {
                    minPath[row + 1, col] = minPath[row, col] + graph[row + 1][col];
                }

                if (IsInRange(row, col - 1, numberOfRows, numberOfColumns)
                    && !visited[row, col - 1]
                    && minPath[row, col] + graph[row][col - 1] < minPath[row, col - 1])
                {
                    minPath[row, col - 1] = minPath[row, col] + graph[row][col - 1];
                }
            }
            List<int> path = RecoverMinPath();
            Console.WriteLine($"Length: {path.Sum(s => s)}");
            Console.WriteLine($"Path: {string.Join(" ", path)}");
        }

        private static List<int> RecoverMinPath()
        {
            var path = new List<int>();
            int rows = graph.Length;
            int cols = graph[0].Length;
            int currentRow = graph.Length - 1;
            int currentCol = graph[0].Length - 1;

            while (currentRow >= 0 && currentCol >= 0)
            {
                path.Add(graph[currentRow][currentCol]);
                if (currentRow == 0 && currentCol == 0)
                {
                    break;
                }

                int currentSum = minPath[currentRow, currentCol] - graph[currentRow][currentCol];

                if (IsInRange(currentRow - 1, currentCol, rows, cols) && currentSum == minPath[currentRow - 1, currentCol])
                {
                    currentRow--;
                }
                else if (IsInRange(currentRow, currentCol + 1, rows, cols) && currentSum == minPath[currentRow, currentCol + 1])
                {
                    currentCol++;
                }
                else if (IsInRange(currentRow + 1, currentCol, rows, cols) && currentSum == minPath[currentRow + 1, currentCol])
                {
                    currentRow++;
                }
                else if (IsInRange(currentRow, currentCol - 1, rows, cols) && currentSum == minPath[currentRow, currentCol - 1])
                {
                    currentCol--;
                }
            }

            path.Reverse();
            return path;
        }

        public static int[] FindSmallestCell()
        {
            int min = int.MaxValue;
            int bestRow = -1;
            int bestCol = -1;

            for (int row = 0; row < minPath.GetLength(0); row++)
            {
                for (int col = 0; col < minPath.GetLength(1); col++)
                {
                    if (!visited[row, col] && minPath[row, col] < min)
                    {
                        min = minPath[row, col];
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }

            if (min != int.MaxValue)
            {
                return new int[] { bestRow, bestCol };
            }

            return null;
        }

        public static bool IsInRange(int row, int col, int rows, int cols)
        {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }
}
