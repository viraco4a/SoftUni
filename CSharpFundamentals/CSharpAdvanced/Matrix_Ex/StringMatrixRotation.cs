using System;
using System.Collections.Generic;
using System.Linq;

namespace StringMatrixRotation
{
    class StringMatrixRotation
    {
        private static char[][] matrix;
        private static int degree;
        static void Main(string[] args)
        {
            ReadMatrix();
            switch (degree)
            {
                case 90:
                    PrintNinety();
                    break;
                case 180:
                    PrintSix();
                    break;
                case 270:
                    PrintLast();
                    break;
                default:
                    PrintZero();
                    break;
            }
        }

        private static void PrintLast()
        {
            for (int col = matrix[0].Length - 1; col >= 0; col--)
            {
                for (int row = 0; row < matrix.Length; row++)
                {
                    Console.Write(matrix[row][col]);
                }
                Console.WriteLine();
            }
        }

        private static void PrintSix()
        {
            for (int row = matrix.Length - 1; row >= 0; row--)
            {
                for (int col = matrix[row].Length - 1; col >= 0; col--)
                {
                    Console.Write(matrix[row][col]);
                }
                Console.WriteLine();
            }
        }

        private static void PrintNinety()
        {
            for (int col = 0; col < matrix[0].Length; col++)
            {
                for (int row = matrix.Length - 1; row >= 0; row--)
                {
                    Console.Write(matrix[row][col]);
                }
                Console.WriteLine();
            }
        }

        private static void PrintZero()
        {
            for (int row = 0; row < matrix.Length; row++)
            {
                for (int col = 0; col < matrix[row].Length; col++)
                {
                    Console.Write(matrix[row][col]);
                }
                Console.WriteLine();
            }
        }

        private static void ReadMatrix()
        {
            string[] rotation = Console.ReadLine()
                .Split(new char[] { '(', ')' }, StringSplitOptions.RemoveEmptyEntries);
            degree = int.Parse(rotation[1]) % 360;

            List<char[]> list = new List<char[]>();

            string input = Console.ReadLine();

            int rows = 0;
            int cols = 0;

            while (input != "END")
            {
                rows++;

                list.Add(input.ToCharArray());

                if (input.Length > cols)
                {
                    cols = input.Length;
                }

                input = Console.ReadLine();
            }

            matrix = new char[rows][];
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = new char[cols];
                for (int col = 0; col < cols; col++)
                {
                    if (col >= list[row].Length)
                    {
                        matrix[row][col] = ' ';

                    }
                    else
                    {
                        matrix[row][col] = list[row][col];
                    }
                }
            }
        }
    }
}
