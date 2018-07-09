using System;
using System.Collections.Generic;
using System.Linq;

namespace needleDict
{
    class Program
    {
        static void Main()
        {
            var limits = GetNumbers(Console.ReadLine());
            var array = GetNumbers(Console.ReadLine());
            var needles = GetNumbers(Console.ReadLine());
            int N = limits[0];
            int C = limits[1];
            var leftPositions = new Dictionary<int, int>(array.Length);
            var positionsArgument = new List<int>(array.Length);

            PopulateCollections(array, N, leftPositions, positionsArgument);

            var result = new List<int>(needles.Length);

            for (int i = 0; i < C; i++)
            {
                int index = positionsArgument.BinarySearch(needles[i]);
                if (index == 0)
                {
                    result.Add(0);
                }
                else if (index >= 0)
                {
                    result.Add(leftPositions[positionsArgument[index - 1]] + 1);
                }
                else
                {
                    index = ~index;
                    if (index == 0)
                    {
                        result.Add(0);
                    }
                    else
                    {
                        result.Add(leftPositions[positionsArgument[index - 1]] + 1);
                    }
                }
            }
            Console.WriteLine(string.Join(" ", result));
        }

        private static void PopulateCollections(int[] array, int N, Dictionary<int, int> leftPositions, List<int> positionsArgument)
        {
            for (int i = 0; i < N; i++)
            {
                if (array[i] != 0)
                {
                    if (!leftPositions.ContainsKey(array[i]))
                    {
                        leftPositions.Add(array[i], i);
                        positionsArgument.Add(array[i]);
                    }
                    else
                    {
                        leftPositions[array[i]] = i;
                    }
                }
            }
        }

        private static int[] GetNumbers(string input)
        {
            return input
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(s => int.Parse(s))
                .ToArray();
        }

    }
}
