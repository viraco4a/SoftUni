using System;
using System.Linq;

namespace RecursionsDemo
{
    class Program
    {
        static int Sum(int[] arr, int index)
        {
            if (index == arr.Length)
            {
                return 0;
            }

            return arr[index] + Sum(arr, index + 1);
        }

        static void Main()
        {
            var numbers = Console.ReadLine().Split(' ').Select(s => int.Parse(s)).ToArray();
            var sum = Sum(numbers, 0);
            Console.WriteLine(sum);
        }
    }
}
