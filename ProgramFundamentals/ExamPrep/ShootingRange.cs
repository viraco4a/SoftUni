using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ShootingRange
{
    class Program
    {
        private static int[] values;
        private static bool[] visited;

        static void Main()
        {
            values = Console.ReadLine().Split().Select(int.Parse).ToArray();
            visited = new bool[values.Length];
            var target = int.Parse(Console.ReadLine());

            GeneratePermutaions(0, target);
        }

        private static void GeneratePermutaions(int index, int target)
        {
            if (index == target)
            {
                Print();
                return;
            }

            if (index >= values.Length)
            {
                Print();
            }
            else
            {
                HashSet<int> swapped = new HashSet<int>();

                for (int i = 0; i < values.Length; i++)
                {
                    if (!swapped.Contains(i))
                    {
                        Swap(index, i);
                        visited[index] = true;

                        GeneratePermutaions(index + 1, target);

                        Swap(index, i);
                        visited[index] = false;

                        swapped.Add(index);
                    }
                }
            }
        }

        private static void Swap(int index, int i)
        {
            int temp = values[index];
            values[index] = values[i];
            values[i] = temp;
        }

        private static void Print()
        {
            //var sb = new StringBuilder();
            //for (int i = 0; i < values.Length; i++)
            //{
            //    sb.Append(values[i] + " ");
            //}
            //Console.WriteLine(sb.ToString().Trim());
            Console.WriteLine(string.Join("", values));
        }
    }
}
