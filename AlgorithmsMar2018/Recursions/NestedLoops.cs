using System;

namespace NestedLoops
{
    class Program
    {
        static void Main()
        {
            int totalLoops = int.Parse(Console.ReadLine());
            int[] array = new int[totalLoops];
            Loop(totalLoops, 0, array);
        }

        private static void Loop(int totalLoops, int index, int[] array)
        {
            if (index == totalLoops)
            {
                Console.WriteLine(string.Join(" ", array));
                return;
            }
            else
            {
                for (int i = 1; i <= totalLoops; i++)
                {
                    array[index] = i;
                    Loop(totalLoops, index + 1, array);
                }
            }
        }

    }
}
