using System;
using System.Collections.Generic;
using System.Linq;

class SimpleCalculator
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split();
        Stack<string> stack = new Stack<string>();

        for (int i = 0; i < input.Length; i++)
        {
            try
            {
                int num = int.Parse(input[i]);
                stack.Push(num)
            }
            catch (Exception)
            {

                throw;
            }
        }

    }
}
