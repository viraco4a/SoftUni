using System;
using System.Collections.Generic;

namespace BalancedParenthesis
{
    class BalancedParenthesis
    {
        private static Stack<char> stack = new Stack<char>();
        private static char[] parentheses;
        static void Main(string[] args)
        {
            parentheses = Console.ReadLine().ToCharArray();
            if (AlgoBalancedParentheses())
            {
                Console.WriteLine("YES");
            }
            else
            {
                Console.WriteLine("NO");
            }
        }

        private static bool AlgoBalancedParentheses()
        {
            foreach (char symbol in parentheses)
            {
                if (isOpen(symbol))
                {
                    stack.Push(symbol);
                }
                else
                {
                    if (stack.Count == 0)
                    {
                        return false;
                    }
                    if (!checkMatch(stack.Pop(), symbol))
                    {
                        return false;
                    }
                }
            }

            return stack.Count == 0;
        }

        private static bool checkMatch(char pop, char symbol)
        {
            return (pop == '{' && symbol == '}')
                || (pop == '[' && symbol == ']')
                || (pop == '(' && symbol == ')');
        }

        private static bool isOpen(char c)
        {
            return c == '{' || c == '[' || c == '(';
        }
    }
}
