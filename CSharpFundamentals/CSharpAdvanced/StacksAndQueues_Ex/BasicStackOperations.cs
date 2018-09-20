using System;
using System.Collections.Generic;

namespace BasicStackOperations
{
    class BasicStackOperations
    {
        private static Stack<int> stack = new Stack<int>();
        static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split();
            int N = int.Parse(tokens[0]);
            int S = int.Parse(tokens[1]);
            int X = int.Parse(tokens[2]);
            string[] nums = Console.ReadLine().Split();
            for (int i = 0; i < N; i++)
            {
                stack.Push(int.Parse(nums[i]));
            }
            for (int i = 0; i < S; i++)
            {
                stack.Pop();
            }
            if (stack.Contains(X))
            {
                Console.WriteLine("true");
            }
            else
            {
                int min = int.MaxValue;
                if (stack.Count == 0)
                {
                    min = 0;
                }
                while (stack.Count > 0)
                {
                    int local = stack.Pop();
                    if (local < min)
                    {
                        min = local;
                    }
                }
                Console.WriteLine(min);
            }
        }
    }
}
