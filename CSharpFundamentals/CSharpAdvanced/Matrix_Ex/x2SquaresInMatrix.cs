using System;
using System.Linq;

namespace x2SquaresInMatrix
{
    class x2SquaresInMatrix
    {
        private static char[,] matrix;
        private static int counter;

        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);
            int rows = int.Parse(input[0]);
            int cols = int.Parse(input[1]);
            matrix = new char[rows, cols];
            ReadTheMatrix(rows, cols);
            for (int row = 0; row < rows - 1; row++)
            {
                for (int col = 0; col < cols - 1; col++)
                {
                    if (isMatrix(row, col))
                    {
                        counter++;
                    }
                }
            }
            Console.WriteLine(counter);
        }

        private static bool isMatrix(int row, int col)
        {
            char symbol = matrix[row, col];
            for (int i = row; i < row + 2; i++)
            {
                for (int j = col; j < col + 2; j++)
                {
                    if (matrix[i, j] != symbol)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        private static void ReadTheMatrix(int rows, int cols)
        {
            counter = 0;
            for (int row = 0; row < rows; row++)
            {
                char[] line = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                    .Select(char.Parse)
                    .ToArray();
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = line[col];
                }
            }
        }
    }
}
