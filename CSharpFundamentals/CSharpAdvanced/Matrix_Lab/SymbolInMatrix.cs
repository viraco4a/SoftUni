using System;

namespace SymbolInMatrix
{
    class SymbolInMatrix
    {
        private static char[,] matrix;
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            matrix = new char[n, n];
            ReadMatrix(n);
            char symbol = char.Parse(Console.ReadLine());
            for (int row = 0; row < n; row++)
            {
                for (int col = 0; col < n; col++)
                {
                    if (matrix[row, col] == symbol)
                    {
                        Console.WriteLine($"({row}, {col})");
                        return;
                    }
                }
            }
            Console.WriteLine($"{symbol} does not occur in the matrix");
        }

        private static void ReadMatrix(int n)
        {
            for (int row = 0; row < n; row++)
            {
                char[] line = Console.ReadLine().ToCharArray();
                for (int col = 0; col < n; col++)
                {
                    matrix[row, col] = line[col];
                }
            }
        }
    }
}
