using System;
using System.Collections.Generic;

namespace PoisonousPlant
{
    class PoisonousPlant
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            string[] plants = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
            Stack<int> indexesStack = new Stack<int>();
            indexesStack.Push(0);

            int[] days = new int[N];

            for (int i = 0; i < N; i++)
            {
                int maxDays = 0;

                while (indexesStack.Count > 0 
                    && int.Parse(plants[indexesStack.Peek()]) >= int.Parse(plants[i]))
                {
                    maxDays = Math.Max(maxDays, days[indexesStack.Pop()]);
                }

                if (indexesStack.Count > 0)
                {
                    days[i] = maxDays + 1;
                }

                indexesStack.Push(i);
            }
            Console.WriteLine(max(days));
        }

        private static int max(int[] days)
        {
            int max = int.MinValue;
            foreach (int day in days)
            {
                if (day > max)
                {
                    max = day;
                }
            }
            return max;
        }
    }
}
