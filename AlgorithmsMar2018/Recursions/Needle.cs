using System;
using System.Linq;

namespace Needle
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
            RemoveZeroes(array, N);
            var result = new int[C];
            for (int i = 0; i < C; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (needles[i] > array[N - 1])
                    {
                        result[i] = N;
                        break;
                    }
                    if (needles[i] <= array[j])
                    {
                        result[i] = j;
                        break;
                    }
                }
            }
            Console.WriteLine(string.Join(" ", result));
        }

        private static void RemoveZeroes(int[] array, int N)
        {
            int local = 0;
            int specialIndex = -1;
            for (int i = N - 2; i >= 0; i--)
            {
                if (array[i] != 0 && local == 0)
                {
                    local = array[i];
                    specialIndex = i;
                }
                else if (array[i] == 0 && array[i + 1] != 0)
                {
                    local = array[i + 1];
                }
                if (array[i] == 0 && local != 0)
                {
                    array[i] = local;
                }
            }
            if (specialIndex < N && specialIndex >= 0)
            {
                for (int i = specialIndex + 1; i < N; i++)
                {
                    array[i] = array[specialIndex];
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
