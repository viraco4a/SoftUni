using System;
using System.Linq;

namespace MaximalSum
{
    class MaximalSum
    {
        private static int[,] matrix;
        private static int max;
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);
            int rows = int.Parse(input[0]);
            int cols = int.Parse(input[1]);
            ReadMatrix(rows, cols);
            int maxRow = 0;
            int maxCol = 0;
            for (int row = 0; row < rows - 2; row++)
            {
                for (int col = 0; col < cols - 2; col++)
                {
                    int sum = CalcSum(row, col);
                    if (sum > max)
                    {
                        maxRow = row;
                        maxCol = col;
                        max = sum;
                    }
                }
            }
            Console.WriteLine($"Sum = {max}");
            for (int row = maxRow; row < maxRow + 3; row++)
            {
                for (int col = maxCol; col < maxCol + 3; col++)
                {
                    Console.Write(matrix[row, col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static int CalcSum(int row, int col)
        {
            int sum = 0;
            for (int i = row; i < row + 3; i++)
            {
                for (int j = col; j < col + 3; j++)
                {
                    sum += matrix[i, j];
                }
            }
            return sum;
        }

        private static void ReadMatrix(int rows, int cols)
        {
            max = int.MinValue;
            matrix = new int[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                int[] line = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = line[col];
                }
            }
        }
    }
}
