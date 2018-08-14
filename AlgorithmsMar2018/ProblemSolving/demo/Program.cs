using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ShootingRange
{
    class ShootingRange
    {
        private static int[] values;
        private static bool[] visited;
        private static int target;

        static void Main()
        {
            values = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            visited = new bool[values.Length];
            target = int.Parse(Console.ReadLine());

            Permute(0);
        }

        private static void Permute(int index)
        {
            int score = GetScores();

            if (score == target)
            {
                Print();
            }

            if (index > values.Length || score >= target)
            {
                return;
            }

            HashSet<int> swapped = new HashSet<int>();

            for (int i = index; i < values.Length; i++)
            {
                if (!swapped.Contains(values[i]))
                {
                    Swap(index, i);
                    visited[index] = true;

                    Permute(index + 1);

                    Swap(index, i);
                    visited[index] = false;

                    swapped.Add(values[i]);
                }
            }
        }

        private static int GetScores()
        {
            var multiplier = 0;
            var sum = 0;
            for (int i = 0; i < values.Length; i++)
            {
                if (visited[i])
                {
                    sum +=values[i] * ++multiplier;
                }
            }

            return sum;
        }

        private static void Swap(int index, int i)
        {
            int temp = values[index];
            values[index] = values[i];
            values[i] = temp;
        }

        private static void Print()
        {
            var sb = new StringBuilder();
            for (int j = 0; j < values.Length; j++)
            {
                if (visited[j])
                {
                    sb.Append(values[j] + " ");
                }
            }
            Console.WriteLine(sb.ToString().Trim());
        }
    }
}
