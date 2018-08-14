using System;
using System.Collections.Generic;
using System.Linq;

namespace ZigZagMatrix
{
    class Program
    {
        private static int[][] matrix;
        private static int[,] max;
        private static int[,] prevRow;
        private static List<int> path;
        private static int numberOfRows;
        private static int numberOfColumns;

        static void Main()
        {
            ReadInput();

            DynamicProgAlgo();

            ReconstructPath();

            path.Reverse();
            Console.WriteLine($"{path.Sum(s => s)} = {string.Join(" + ", path)}");
        }

        private static void ReconstructPath()
        {
            int globalMax = int.MinValue;
            int rowIndex = -1;
            int colIndex = numberOfColumns - 1;
            for (int row = 0; row < numberOfRows; row++)
            {
                if (max[row, colIndex] > globalMax)
                {
                    globalMax = max[row, colIndex];
                    rowIndex = row;
                }
            }

            while (colIndex >= 0)
            {
                path.Add(matrix[rowIndex][colIndex]);
                rowIndex = prevRow[rowIndex, colIndex];
                colIndex--;
            }
        }

        private static void DynamicProgAlgo()
        {
            for (int row = 0; row < numberOfRows; row++)
            {
                max[row, 0] = matrix[row][0];
            }

            for (int col = 1; col < numberOfColumns; col++)
            {
                for (int row = 0; row < numberOfRows; row++)
                {
                    int prevMax = 0;

                    if (col % 2 != 0)
                    {
                        for (int i = row + 1; i < numberOfRows; i++)
                        {
                            if (max[i, col - 1] > prevMax)
                            {
                                prevMax = max[i, col - 1];
                                prevRow[row, col] = i;
                            }
                        }
                    }
                    else
                    {
                        for (int i = 0; i <= row - 1; i++)
                        {
                            if (max[i, col - 1] > prevMax)
                            {
                                prevMax = max[i, col - 1];
                                prevRow[row, col] = i;
                            }
                        }
                    }

                    max[row, col] = prevMax + matrix[row][col];
                }
            }
        }

        private static void ReadInput()
        {
            numberOfRows = int.Parse(Console.ReadLine());
            numberOfColumns = int.Parse(Console.ReadLine());
            matrix = new int[numberOfRows][];
            max = new int[numberOfRows, numberOfColumns];
            prevRow = new int[numberOfRows, numberOfColumns];
            path = new List<int>(numberOfColumns);

            for (int row = 0; row < numberOfRows; row++)
            {
                matrix[row] = Console.ReadLine().Split(',').Select(int.Parse).ToArray();
            }
        }
    }
}
