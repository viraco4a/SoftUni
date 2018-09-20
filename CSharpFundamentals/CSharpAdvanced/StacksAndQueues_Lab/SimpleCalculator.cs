using System;
using System.Collections.Generic;
using System.Linq;

class SimpleCalculator
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split();
        Stack<string> stack = new Stack<string>(input.Reverse());
        while (stack.Count > 1)
        {
            int first = int.Parse(stack.Pop());
            string op = stack.Pop();
            int second = int.Parse(stack.Pop());
            switch (op)
            {
                case "+":
                    stack.Push((first + second).ToString());
                    break;
                case "-":
                    stack.Push((first - second).ToString());
                    break;
            }

        }
        Console.WriteLine(stack.Pop());
    }
}
