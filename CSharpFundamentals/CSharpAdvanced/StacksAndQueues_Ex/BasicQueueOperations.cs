using System;
using System.Collections.Generic;
using System.Linq;

namespace BasicQueueOperations
{
    class BasicQueueOperations
    {
        private static Queue<int> queue = new Queue<int>();
        static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split();
            int N = int.Parse(tokens[0]);
            int S = int.Parse(tokens[1]);
            int X = int.Parse(tokens[2]);
            int[] nums = Console.ReadLine().Split()
                .Select(int.Parse).ToArray();

            for (int i = 0; i < N; i++)
            {
                queue.Enqueue(nums[i]);
            }
            for (int i = 0; i < S; i++)
            {
                queue.Dequeue();
            }

            if (queue.Contains(X))
            {
                Console.WriteLine("true");
            }
            else if (queue.Count == 0)
            {
                Console.WriteLine(0);
            }
            else
            {
                int min = int.MaxValue;
                while (queue.Count > 0)
                {
                    int num = queue.Dequeue();
                    if (num < min)
                    {
                        min = num;
                    }
                }
                Console.WriteLine(min);
            }
        }
    }
}
