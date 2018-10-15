using System;
using System.Collections.Generic;
using System.Linq;

namespace CupsAndBottles
{
    class CupsAndBottles
    {
        private static Queue<int> queueOfCups = new Queue<int>();
        private static Stack<int> stackOfBottles = new Stack<int>();
        private static long wastedWater = 0;
        private static int bottleCount = 0;
        private static int cupCount = 0;
        private static int cup = 0;
        static void Main(string[] args)
        {
            ReadInput();
            while (stackOfBottles.Count != 0 && queueOfCups.Count != 0)
            {
                int water = stackOfBottles.Peek();
                if (cup == 0)
                {
                    cup = queueOfCups.Peek();
                }
                if (water >= cup)
                {
                    queueOfCups.Dequeue();
                    cupCount--;
                    stackOfBottles.Pop();
                    bottleCount--;
                    wastedWater += water - cup;
                    cup = 0;
                }
                else
                {
                    cup -= water;
                    stackOfBottles.Pop();
                    bottleCount--;
                }
            }

            if (stackOfBottles.Count == 0)
            {
                Console.WriteLine($"Cups: {string.Join(" ", queueOfCups.ToList())}");
            }
            else if (queueOfCups.Count == 0)
            {
                Console.WriteLine($"Bottles: {string.Join(" ", stackOfBottles.ToList())}");
            }
            Console.WriteLine($"Wasted litters of water: {wastedWater}");
        }

        private static void ReadInput()
        {
            int[] cupInput = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int[] bottleInput = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            foreach (var item in cupInput)
            {
                queueOfCups.Enqueue(item);
            }
            foreach (var item in bottleInput)
            {
                stackOfBottles.Push(item);
            }
            bottleCount = stackOfBottles.Count;
            cupCount = queueOfCups.Count;
        }
    }
}
