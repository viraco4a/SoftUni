using System;
using System.Collections.Generic;

namespace LCSpractice
{
    class Program
    {
        static void Main()
        {
            string first = Console.ReadLine();
            string second = Console.ReadLine();
            var lcs = new int[first.Length + 1, second.Length + 1];
            for (int row = 1; row <= first.Length; row++)
            {
                for (int col = 1; col <= second.Length; col++)
                {
                    var up = lcs[row - 1, col];
                    var left = lcs[row, col - 1];

                    var result = Math.Max(up, left);

                    if (first[row - 1] == second[col - 1])
                    {
                        result = Math.Max(1 + lcs[row - 1, col - 1], result);
                    }

                    lcs[row, col] = result;
                }
            }
            Console.WriteLine(lcs[first.Length, second.Length]);
        }
    }
}
