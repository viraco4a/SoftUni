using System;
using System.Collections.Generic;
using System.Linq;

namespace GroupNumbers
{
    class GroupNumbers
    {
        private static int[][] matrix;
        private static int[] array;

        static void Main(string[] args)
        {
            array = Console.ReadLine()
                .Split(", ", StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            matrix = new int[3][];
            List<int> zeroesIndex = new List<int>();
            List<int> oneIndex = new List<int>();
            List<int> twoIndex = new List<int>();

            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] % 3 == 0)
                {
                    zeroesIndex.Add(i);
                }
                else if (Math.Abs(array[i] % 3) == 1)
                {
                    oneIndex.Add(i);
                }
                else
                {
                    twoIndex.Add(i);
                }
            }
            matrix[0] = new int[zeroesIndex.Count];
            matrix[1] = new int[oneIndex.Count];
            matrix[2] = new int[twoIndex.Count];

            calc(0, zeroesIndex);
            calc(1, oneIndex);
            calc(2, twoIndex);

            for (int row = 0; row < 3; row++)
            {
                Console.WriteLine(string.Join(" ", matrix[row]));
            }
        }

        private static void calc(int row, List<int> zeroesIndex)
        {
            for (int col = 0; col < zeroesIndex.Count; col++)
            {
                matrix[row][col] = array[zeroesIndex[col]];
            }
        }
    }
}
