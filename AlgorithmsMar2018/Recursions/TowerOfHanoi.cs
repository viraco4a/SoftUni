using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace TowerOfHanoi
{
    class Program
    {
        private static Stack<int> source;
        private static Stack<int> destination = new Stack<int>();
        private static Stack<int> spare = new Stack<int>();
        private static int step = 0;

        static void Main()
        {
            int numberOfDiscs = int.Parse(Console.ReadLine());
            source = new Stack<int>(Enumerable.Range(1, numberOfDiscs).Reverse());
            PrintRods();
            Move(numberOfDiscs, source, destination, spare);
        }

        private static void Move(int bottom, Stack<int> source, Stack<int> destination, Stack<int> spare)
        {
            if (bottom == 1)
            {
                step++;
                destination.Push(source.Pop());
                Console.WriteLine($"Step #{step}: Moved disk");
                PrintRods();
            }
            else
            {
                Move(bottom - 1, source, spare, destination);
                destination.Push(source.Pop());
                step++;
                Console.WriteLine($"Step #{step}: Moved disk");
                PrintRods();
                Move(bottom - 1, spare, destination, source);
            }
        }

        private static void PrintRods()
        {
            Console.WriteLine("Source: {0}", string.Join(", ", source.Reverse()));
            Console.WriteLine("Destination: {0}", string.Join(", ", destination.Reverse()));
            Console.WriteLine("Spare: {0}", string.Join(", ", spare.Reverse()));
            Console.WriteLine();
        }
    }
}
