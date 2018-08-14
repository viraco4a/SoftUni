using System;
using System.Linq;

namespace _05.Permutations_With_Repetition
{
    class PermutationsWithRepetitions
    {
        static int count = 0;
        static void Main()
        {
            var arr = Console.ReadLine().Split(' ').Select(s => int.Parse(s)).ToArray();

            Array.Sort(arr);
            PermuteRep(arr, 0, arr.Length - 1);
            Console.WriteLine($"Total number of permutations: {count}");
        }

        static void PermuteRep(int[] arr, int start, int end)
        {
            Print(arr);

            for (int left = end - 1; left >= start; left--)
            {
                for (int right = left + 1; right <= end; right++)
                {
                    if (arr[left] == arr[right]) continue; // skip over the code below and continue the for loop

                    Swap(ref arr[left], ref arr[right]);
                    PermuteRep(arr, left + 1, end);
                }

                // Undo all modifications done by the
                // previous recursive calls and swaps
                var firstElement = arr[left];
                for (var i = left; i <= end - 1; i++)
                {
                    arr[i] = arr[i + 1];
                }
                arr[end] = firstElement;
            }
        }

        static void Print<T>(T[] arr)
        {
            count++;
            Console.WriteLine("(" + string.Join(", ", arr) + ")");
        }

        static void Swap<T>(ref T first, ref T second)
        {
            var oldFirst = first;
            first = second;
            second = oldFirst;
        }
    }
}