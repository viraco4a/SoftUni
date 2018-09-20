using System;
using System.Collections.Generic;
using System.Text;

class ReverseStrings
{    static void Main()
    {
        string input = Console.ReadLine();
        Stack<string> stack = new Stack<string>();
        for (int i = 0; i < input.Length; i++)
        {
            stack.Push(input[i].ToString());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.Length; i++)
        {
            sb.Append(stack.Pop());
        }
        Console.WriteLine(sb.ToString());
    }
}