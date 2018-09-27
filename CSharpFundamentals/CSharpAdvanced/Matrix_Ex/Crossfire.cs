using System;
using System.Collections.Generic;
using System.Linq;

namespace Crossfire
{
    class Crossfire
    {
        private static List<List<int>> matrix = new List<List<int>>();
        static void Main(string[] args)
        {            
            int[] dimensions = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int rows = dimensions[0];
            int cols = dimensions[1];

            GetMatrix(rows, cols);

            string input = Console.ReadLine();

            while (input != "Nuke it from orbit")
            {
                int[] coordinates = input.Split().Select(int.Parse).ToArray();

                int row = coordinates[0];
                int col = coordinates[1];
                int radius = coordinates[2];

                Attack(row, col, radius);

                input = Console.ReadLine();
            }

            Print();
        }

        private static void Attack(int targetRow, int targetCol, int radius)
        {
            for (int row = targetRow - radius; row <= targetRow + radius; row++)
            {
                if (IsInside(row, targetCol))
                {
                    matrix[row][targetCol] = 0;
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++)
            {
                if (IsInside(targetRow, col))
                {
                    matrix[targetRow][col] = 0;
                }
            }

            for (int row = 0; row < matrix.Count; row++)
            {
                matrix[row].RemoveAll(s => s == 0);

                if (matrix[row].Count == 0)
                {
                    matrix.RemoveAt(row--);
                }
            }
        }

        private static bool IsInside(int row, int col)
        {
            return row >= 0 && row < matrix.Count && col >= 0 && col < matrix[row].Count;
        }

        private static void Print()
        {
            foreach (var row in matrix)
            {
                Console.WriteLine(string.Join(" ", row));
            }
        }

        private static void GetMatrix(int rows, int cols)
        {
            int counter = 1;

            for (int row = 0; row < rows; row++)
            {
                List<int> currentNumbers = new List<int>();

                for (int col = 0; col < cols; col++)
                {
                    currentNumbers.Add(counter++);
                }

                matrix.Add(currentNumbers);
            }
        }
    }
}
