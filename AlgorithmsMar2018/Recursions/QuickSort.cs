using System;
using System.Linq;

namespace QuickSort
{
    class Program
    {
        static void Main()
        {
            var array = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(s => int.Parse(s))
                .ToArray();
            QuickSort(array, 0, array.Length - 1);
            Console.WriteLine(string.Join(" ", array));
        }

        private static void QuickSort(int[] array, int startIndex, int endIndex)
        {
            if (startIndex >= endIndex)
            {
                return;
            }
            int pivot = Partition(array, startIndex, endIndex);
            QuickSort(array, startIndex, pivot - 1);
            QuickSort(array, pivot + 1, endIndex);
        }

        private static int Partition(int[] array, int startIndex, int endIndex)
        {
            int pivot = array[endIndex];
            int i = startIndex - 1;
            for (int j = startIndex; j < endIndex; j++)
            {
                if (array[j] <= pivot)
                {
                    i++;
                    if (i != j)
                    {
                        swap(array, i, j);
                    }
                }
            }
            if (i + 1 != endIndex)
            {
                swap(array, i + 1, endIndex);
            }
            return i + 1;
        }

        private static void swap(int[] array, int i, int j)
        {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
