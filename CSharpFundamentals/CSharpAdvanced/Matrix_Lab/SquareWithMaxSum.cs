using System;
using System.Linq;

namespace SquareWithMaxSum
{
    class SquareWithMaxSum
    {
        private static int[,] matrix;
        static void Main(string[] args)
        {
            ReadMatrix();
            int max = int.MinValue;
            int maxRow = 0;
            int maxCol = 0;
            for (int row = 0; row < matrix.GetLength(0) - 1; row++)
            {
                for (int col = 0; col < matrix.GetLength(1) - 1; col++)
                {
                    int sum = CheckLocalMatrix(row, col);
                    if (sum > max)
                    {
                        max = sum;
                        maxRow = row;
                        maxCol = col;
                    }
                }
            }
            Console.WriteLine($"{matrix[maxRow, maxCol]} {matrix[maxRow, maxCol + 1]}");
            Console.WriteLine($"{matrix[maxRow + 1, maxCol]} {matrix[maxRow + 1, maxCol + 1]}");
            Console.WriteLine(max);
        }

        private static int CheckLocalMatrix(int row, int col)
        {
            int sum = 0;
            for (int i = row; i < row + 2; i++)
            {
                for (int j = col; j < col + 2; j++)
                {
                    sum += matrix[i, j];
                }
            }
            return sum;
        }

        private static void ReadMatrix()
        {
            int[] line = ReadLine();
            int rows = line[0];
            int cols = line[1];
            matrix = new int[rows, cols];

            for (int row = 0; row < rows; row++)
            {
                line = ReadLine();
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = line[col];
                }
            }
        }

        private static int[] ReadLine()
        {
            return Console.ReadLine()
                            .Split(", ", StringSplitOptions.RemoveEmptyEntries)
                            .Select(s => int.Parse(s))
                            .ToArray();
        }
    }
}
