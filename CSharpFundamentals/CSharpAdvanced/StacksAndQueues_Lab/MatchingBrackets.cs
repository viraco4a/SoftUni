using System;
using System.Collections.Generic;
using System.Linq;

namespace MatchingBrackets
{
    class MatchingBrackets
    {
        static void Main(string[] args)
        {
            char[] splitted = Console.ReadLine().ToCharArray();
            Stack<int> stack = new Stack<int>();

            for (int i = 0; i < splitted.Length; i++)
            {
                if (splitted[i] == '(')
                {
                    stack.Push(i);
                }
                if (splitted[i] == ')')
                {
                    int index = stack.Pop();
                    
                    Console.WriteLine(string.Join("", splitted.Skip(index).Take(i - index + 1)));
                }
            }
        }
    }
}
