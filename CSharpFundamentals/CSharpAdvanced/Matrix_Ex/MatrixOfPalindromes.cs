using System;

namespace MatrixOfPalindromes
{
    class MatrixOfPalindromes
    {
        private static string[,] matrix;
        static void Main(string[] args)
        {
            ReadMatrix();
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    Console.Write(matrix[row, col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static void ReadMatrix()
        {
            string[] sizes = Console.ReadLine().Split();
            int rows = int.Parse(sizes[0]);
            int cols = int.Parse(sizes[1]);
            char[] alphabet = "abcdefghijklmnopqrstuvwxyz".ToCharArray();
            matrix = new string[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    char a = alphabet[row];
                    char b = alphabet[row + col];
                    char[] arr = new char[3] { a, b, a };
                    matrix[row, col] = new string(arr);
                }
            }
        }
    }
}
