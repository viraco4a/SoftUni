using System;
using System.Linq;

namespace TargetPractice
{
    class TargetPractice
    {
        private static char[,] matrix;

        static void Main(string[] args)
        {
            SnakeAttack();
            ShootAtSnakes();
            ApplyGravitationalPull();
            Print();
        }

        private static void Print()
        {
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    Console.Write(matrix[row, col]);
                }
                Console.WriteLine();
            }
        }

        private static void ApplyGravitationalPull()
        {
            int cols = matrix.GetLength(1);
            int rows = matrix.GetLength(0);
            for (int col = 0; col < cols; col++)
            {
                for (int row = rows - 1; row > 0; row--)
                {
                    if (matrix[row, col] == ' ' && matrix[row - 1, col] != ' ')
                    {
                        MoveDown(col, row);
                    }
                }
            }
        }

        private static void MoveDown(int col, int row)
        {
            while (row < matrix.GetLength(0))
            {
                if (matrix[row, col] == ' ')
                {
                    char tmp = matrix[row - 1, col];
                    matrix[row - 1, col] = matrix[row, col];
                    matrix[row, col] = tmp;
                    row++;
                }
                else
                {
                    return;
                }
            }
        }

        private static void ShootAtSnakes()
        {
            int[] shot = ReadTokens();
            int rowHit = shot[0];
            int colHit = shot[1];
            int blastRadius = shot[2];
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    if (outsideBlastRadius(row, col, blastRadius, rowHit, colHit))
                    {
                        continue;
                    }
                    matrix[row, col] = ' ';
                }
            }
        }

        private static bool outsideBlastRadius(int row, int col, int blastRadius, int rowHit, int colHit)
        {
            double distance = Math.Sqrt(
                Math.Pow(
                    Math.Abs(row - rowHit), 2) +
                Math.Pow(
                    Math.Abs(col - colHit), 2));
            return distance > blastRadius;
        }

        private static void SnakeAttack()
        {
            int[] tokens = ReadTokens();
            int rows = tokens[0];
            int cols = tokens[1];
            char[] letters = DefineSnake(rows, cols);
            matrix = new char[rows, cols];
            int lineChecker = 1;
            int counter = 0;
            for (int row = rows - 1; row >= 0; row--)
            {
                if (lineChecker % 2 != 0)
                {
                    for (int col = cols - 1; col >= 0; col--)
                    {
                        matrix[row, col] = letters[counter];
                        counter++;
                    }
                }
                else
                {
                    for (int col = 0; col < cols; col++)
                    {
                        matrix[row, col] = letters[counter];
                        counter++;
                    }
                }
                lineChecker++;
            }
        }

        private static char[] DefineSnake(int rows, int cols)
        {
            string code = Console.ReadLine();
            char[] letters = new char[rows * cols];
            for (int i = 0; i < letters.Length; i++)
            {
                letters[i] = code[i % code.Length];
            }

            return letters;
        }

        private static int[] ReadTokens()
        {
            return Console.ReadLine()
                            .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                            .Select(int.Parse)
                            .ToArray();
        }
    }
}
