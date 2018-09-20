using System;
using System.Collections.Generic;

namespace MaximumElement
{
    class MaximumElement
    {
        private static Stack<int> stack = new Stack<int>();
        private static Stack<int> maxStack = new Stack<int>();
        private static int max;

        static void Main(string[] args)
        {
            max = int.MinValue;
            int N = int.Parse(Console.ReadLine());
            for (int i = 0; i < N; i++)
            {
                string[] command = Console.ReadLine().Split();
                switch (int.Parse(command[0]))
                {
                    case 1:
                        int num = int.Parse(command[1]);
                        stack.Push(num);
                        if (num > max)
                        {
                            max = num;
                            maxStack.Push(num);
                        }
                        break;
                    case 2:
                        int popped = stack.Pop();
                        if (popped == max)
                        {
                            maxStack.Pop();
                            if (maxStack.Count == 0)
                            {
                                max = int.MinValue;
                            }
                            else
                            {
                                max = maxStack.Peek();
                            }
                        }
                        break;
                    case 3:
                        Console.WriteLine(max);
                        break;
                }
            }
        }
    }
}
