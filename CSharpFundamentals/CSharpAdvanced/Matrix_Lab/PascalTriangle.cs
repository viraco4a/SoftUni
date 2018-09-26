using System;

namespace PascalTriangle
{
    class PascalTriangle
    {
        private static long[,] matrix;
        private static long[][] resultMatrix;
        private static int n;

        static void Main(string[] args)
        {
            CreateTriangle();
            CreateResult();
            Print();
        }

        private static void Print()
        {
            for (int row = 0; row < n; row++)
            {
                Console.WriteLine(string.Join(" ", resultMatrix[row]));
            }
        }

        private static void CreateResult()
        {
            resultMatrix = new long[n][];
            for (int row = 0; row < n; row++)
            {
                resultMatrix[row] = new long[row + 1];
                for (int col = 0; col < row + 1; col++)
                {
                    resultMatrix[row][col] = matrix[row, col];
                }
            }
        }

        private static void CreateTriangle()
        {
            n = int.Parse(Console.ReadLine());
            matrix = new long[n, n];
            for (int row = 0; row < n; row++)
            {
                matrix[row, 0] = 1;
            }
            for (int row = 1; row < n; row++)
            {
                for (int col = 1; col < n; col++)
                {
                    matrix[row, col] = matrix[row - 1, col - 1] + matrix[row - 1, col];
                }
            }
        }
    }
}
