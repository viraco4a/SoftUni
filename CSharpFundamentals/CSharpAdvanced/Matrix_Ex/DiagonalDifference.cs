using System;
using System.Linq;

namespace DiagonalDifference
{
    class DiagonalDifference
    {
        private static int[,] matrix;
        private static int n;
        static void Main(string[] args)
        {
            ReadMatrix();
            int firstDiagonal = CalcFirstDiagonal();
            int secondDiagonal = CalcSecondDiagonal();
            Console.WriteLine(Math.Abs(firstDiagonal - secondDiagonal));
        }

        private static int CalcSecondDiagonal()
        {
            int sum = 0;
            for (int row = 0; row < n; row++)
            {
                sum += matrix[row, n - row - 1];
            }
            return sum;
        }

        private static int CalcFirstDiagonal()
        {
            int sum = 0;
            for (int row = 0; row < n; row++)
            {
                sum += matrix[row, row];
            }
            return sum;
        }

        private static void ReadMatrix()
        {
            n = int.Parse(Console.ReadLine());
            matrix = new int[n, n];
            for (int row = 0; row < n; row++)
            {
                int[] line = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                for (int col = 0; col < n; col++)
                {
                    matrix[row, col] = line[col];
                }
            }
        }
    }
}
