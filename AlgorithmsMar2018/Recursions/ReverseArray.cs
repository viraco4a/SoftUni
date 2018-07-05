using System;
using System.Collections.Generic;
using System.Linq;

namespace ReverseArray
{
    class Program
    {
        static void Main()
        {
            var array = Console.ReadLine().Split(' ').Select(s => int.Parse(s)).ToArray();
            var result = new List<int>(array.Length);
            int n = array.Length - 1;
            GetLast(n, array, result);
        }

        private static void GetLast(int n, int[] array, List<int> result)
        {
            if (n < 0)
            {
                Console.WriteLine(string.Join(" ", result));
            }
            else
            {
                result.Add(array[n]);
                GetLast(n - 1, array, result);
            }
        }

    }
}
