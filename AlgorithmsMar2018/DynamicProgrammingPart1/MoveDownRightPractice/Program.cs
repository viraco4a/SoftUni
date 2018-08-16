using System;
using System.Linq;
using System.Collections.Generic;

namespace MoveDownRightPractice
{
    class Program
    {
        static void Main()
        {
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());
            var numbers = new int[rows, cols];

            for (int i = 0; i < rows; i++)
            {
                var line = Console.ReadLine().Split();
                for (int j = 0; j < cols; j++)
                {
                    numbers[i, j] = int.Parse(line[j]);
                }
            }

            var sums = new int[rows, cols];
            sums[0, 0] = numbers[0, 0];
            for (int i = 1; i < rows; i++)
            {
                sums[i, 0] = sums[i - 1, 0] + numbers[i, 0];
            }
            for (int i = 1; i < cols; i++)
            {
                sums[0, i] = sums[0, i - 1] + numbers[0, i];
            }

            for (int i = 1; i < rows; i++)
            {
                for (int j = 1; j < cols; j++)
                {
                    sums[i, j] = Math.Max(sums[i - 1, j], sums[i, j - 1]) + numbers[i, j];
                }
            }

            var currentRow = rows - 1;
            var currentCol = cols - 1;

            var result = new List<string>();
            result.Add($"[{currentRow}, {currentCol}]");

            while (true)
            {
                if (currentRow == 0 && currentCol == 0)
                {
                    break;
                }
                var top = -1;
                var left = -1;
                if (currentRow - 1 >= 0)
                {
                    top = sums[currentRow - 1, currentCol];
                }
                if (currentCol - 1 >= 0)
                {
                    left = sums[currentRow, currentCol - 1];
                }
                if (top > left)
                {
                    result.Add($"[{currentRow - 1}, {currentCol}]");
                    currentRow--;
                }
                else
                {
                    result.Add($"[{currentRow}, {currentCol - 1}]");
                    currentCol--;
                }
            }
            result.Reverse();

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
