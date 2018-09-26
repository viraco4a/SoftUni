using System;
using System.Linq;

namespace RubiksMatrix
{
    class RubiksMatrix
    {
        private static int[,] matrix;

        static void Main(string[] args)
        {
            ReadMatrix();
            MoveRubicElements();
            int counter = 1;
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    if (matrix[row, col] == counter)
                    {
                        Console.WriteLine("No swap required");
                    }
                    else
                    {
                        Swap(row, col, counter);
                    }
                    counter++;
                }
            }
        }

        private static void Swap(int row, int col, int value)
        {
            for (int r = row; r < matrix.GetLength(0); r++)
            {
                for (int c = 0; c < matrix.GetLength(1); c++)
                {
                    if (matrix[r, c] == value)
                    {
                        int tmp = matrix[row, col];
                        matrix[row, col] = matrix[r, c];
                        matrix[r, c] = tmp;
                        Console.WriteLine($"Swap ({row}, {col}) with ({r}, {c})");
                        return;
                    }
                }
            }
        }

        private static void MoveRubicElements()
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] command = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                int index = int.Parse(command[0]);
                string direction = command[1];
                int moves = int.Parse(command[2]);
                switch (direction)
                {
                    case "left":
                        MoveLeft(index, moves);
                        break;
                    case "right":
                        MoveRight(index, moves);
                        break;
                    case "up":
                        MoveUp(index, moves);
                        break;
                    case "down":
                        MoveDown(index, moves);
                        break;
                    default:
                        break;
                }
            }
        }

        private static void MoveDown(int index, int moves)
        {
            int col = index;
            for (int i = 0; i < moves; i++)
            {
                int tmp = matrix[matrix.GetLength(0) - 1, col];
                for (int row = matrix.GetLength(0) - 1; row > 0; row--)
                {
                    matrix[row, col] = matrix[row - 1, col];
                }
                matrix[0, col] = tmp;
            }
        }

        private static void MoveUp(int index, int moves)
        {
            int col = index;
            for (int i = 0; i < moves; i++)
            {
                int tmp = matrix[0, col];
                for (int row = 0; row < matrix.GetLength(0) - 1; row++)
                {
                    matrix[row, col] = matrix[row + 1, col];
                }
                matrix[matrix.GetLength(0) - 1, col] = tmp;
            }
        }

        private static void MoveLeft(int index, int moves)
        {
            int row = index;
            for (int i = 0; i < moves; i++)
            {
                int tmp = matrix[row, 0];
                for (int col = 0; col < matrix.GetLength(1) - 1; col++)
                {
                    matrix[row, col] = matrix[row, col + 1];
                }
                matrix[row, matrix.GetLength(1) - 1] = tmp;
            }
        }

        private static void MoveRight(int index, int moves)
        {
            int row = index;
            for (int i = 0; i < moves; i++)
            {
                int tmp = matrix[row, matrix.GetLength(1) - 1];
                for (int col = matrix.GetLength(1) - 1; col > 0; col--)
                {
                    matrix[row, col] = matrix[row, col - 1];
                }
                matrix[row, 0] = tmp;
            }
        }

        private static void ReadMatrix()
        {
            int[] sizes = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int rows = sizes[0];
            int cols = sizes[1];
            matrix = new int[rows, cols];
            int counter = 0;
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = ++counter;
                }
            }
        }
    }
}
