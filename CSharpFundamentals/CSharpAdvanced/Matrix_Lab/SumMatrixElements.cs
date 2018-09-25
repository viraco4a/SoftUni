using System;
using System.Linq;

namespace SumMatrixElements
{
    class SumMatrixElements
    {
        static void Main(string[] args)
        {
            string[] sizes = Console.ReadLine().Split(", ", StringSplitOptions.RemoveEmptyEntries);
            int rows = int.Parse(sizes[0]);
            int cols = int.Parse(sizes[1]);
            Console.WriteLine(rows);
            Console.WriteLine(cols);
            int[][] matrix = new int[rows][];
            for (int row = 0; row < rows; row++)
            {
                int[] line = Console.ReadLine()
                    .Split(" ", StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                matrix[row] = new int[cols];
                for (int col = 0; col < cols; col++)
                {
                    matrix[row][col] = line[col];
                }
            }
            long sum = 0l;
            foreach (int[] row in matrix)
            {
                sum += row.Sum();
            }
            Console.WriteLine(sum);
        }
    }
}
