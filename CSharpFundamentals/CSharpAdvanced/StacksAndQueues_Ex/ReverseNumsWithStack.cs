using System;
using System.Collections.Generic;

namespace ReverseNumsWithStack
{
    class ReverseNumsWithStack
    {
        static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);
            Stack<int> stack = new Stack<int>();
            foreach (var token in tokens)
            {
                stack.Push(int.Parse(token));
            }
            for (int i = 0; i < tokens.Length; i++)
            {
                Console.Write(stack.Pop() + " ");
            }
        }
    }
}
