﻿using System;
using System.Linq;
using System.Collections.Generic;

namespace MoveDownRight
{
    class Program
    {
        static void Main()
        {
            var rows = int.Parse(Console.ReadLine());
            var cols = int.Parse(Console.ReadLine());
            var numbers = new int[rows, cols];

            for (int i = 0; i < rows; i++)
            {
                var line = Console.ReadLine().Split().Select(s => int.Parse(s)).ToArray();

                for (int j = 0; j < cols; j++)
                {
                    numbers[i, j] = line[j];
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
            
            for (int row = 1; row < rows; row++)
            {
                for (int col = 1; col < cols; col++)
                {
                    sums[row, col] = Math.Max(sums[row - 1, col], sums[row, col - 1]) + numbers[row, col];
                }
            }

            var result = new List<string>();

            result.Add($"[{rows - 1}, {cols - 1}]");

            var currentRow = rows - 1;
            var currentCol = cols - 1;

            while (true)
            {
                if (currentCol == 0 && currentRow == 0)
                {
                    break;
                }
                var top = -1;
                if (currentRow - 1 >= 0)
                {
                    top = sums[currentRow - 1, currentCol];
                }
                var left = -1;
                if (currentCol - 1 >= 0)
                {
                    left = sums[currentRow, currentCol - 1];
                }

                if (top > left)
                {
                    result.Add($"[{currentRow - 1}, {currentCol}]");
                    currentRow -= 1;
                }
                else
                {
                    result.Add($"[{currentRow}, {currentCol - 1}]");
                    currentCol -= 1;
                }
            }

            result.Reverse();
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
