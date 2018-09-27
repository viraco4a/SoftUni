using System;
using System.Linq;

namespace Crossfire
{
    class Crossfire
    {
        private static long[][] matrix;

        static void Main(string[] args)
        {
            CreateMatrix();
            string command = Console.ReadLine();

            while (command != "Nuke it from orbit")
            {
                int[] hit = ReadLine(command);
                int row = hit[0];
                int col  = hit[1];
                int radius = hit[2];
                MarkTarget(row, col, radius);
                DestroyCells();
                command = Console.ReadLine();
            }
            PrintMatrix();
        }

        private static void PrintMatrix()
        {
            for (int row = 0; row < matrix.Length; row++)
            {
                for (int col = 0; col < matrix[0].Length; col++)
                {
                    if (matrix[row][col] == 0)
                    {
                        continue;
                    }
                    Console.Write(matrix[row][col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static void DestroyCells()
        {
            for (int row = 0; row < matrix.Length; row++)
            {
                for (int col = 0; col < matrix[0].Length - 1; col++)
                {
                    if (matrix[row][col] == 0 && matrix[row][col + 1] != 0)
                    {
                        MoveLeft(row, col);
                    }
                }
            }
        }

        private static void MoveLeft(int row, int col)
        {
            while (col >= 0)
            {
                if (matrix[row][col] == 0)
                {
                    long tmp = matrix[row][col + 1];
                    matrix[row][col + 1] = matrix[row][col];
                    matrix[row][col] = tmp;
                    col--;
                }
                else
                {
                    return;
                }
            }
        }

        private static void MarkTarget(int rowBlast, int colBlast, int radius)
        {
            if (!ValidIndex(rowBlast, colBlast))
            {
                return;
            }
            int leftIndex = Math.Max(0, rowBlast - radius);
            int rightIndex = Math.Min(matrix.Length - 1, rowBlast + radius);
            int upIndex = Math.Max(0, colBlast - radius);
            int downIndex = Math.Min(matrix[0].Length - 1, colBlast + radius);
            for (int row = leftIndex; row <= rightIndex; row++)
            {
                matrix[row][colBlast] = 0;
            }
            for (int col = upIndex; col <= downIndex; col++)
            {
                matrix[rowBlast][col] = 0;
            }
        }

        private static bool ValidIndex(int rowBlast, int colBlast)
        {
            return (rowBlast >= 0 && colBlast >= 0 &&
                rowBlast < matrix.Length && colBlast < matrix[0].Length);
        }

        private static void CreateMatrix()
        {
            int[] dimentions = ReadLine(Console.ReadLine());
            int rows = dimentions[0];
            int cols = dimentions[1];
            matrix = new long[rows][];
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = new long[cols];
                for (int col = 0; col < cols; col++)
                {
                    matrix[row][col] = row * cols + col + 1;
                }
            }
        }

        private static int[] ReadLine(string input)
        {
            return input
                            .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                            .Select(int.Parse)
                            .ToArray();
        }
    }
}
