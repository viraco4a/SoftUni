using System;
using System.Collections.Generic;
using System.Text;

namespace SimpleTextEditor
{
    class SimpleTextEditor
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            Stack<string> stackTmp = new Stack<string>();
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < N; i++)
            {
                string[] command = Console.ReadLine().Split(' ', StringSplitOptions.RemoveEmptyEntries);
                int index = int.Parse(command[0]);
                switch (index)
                {
                    case 1:
                        stackTmp.Push(text.ToString());
                        text.Append(command[1]);
                        break;
                    case 2:
                        stackTmp.Push(text.ToString());
                        int count = int.Parse(command[1]);
                        int test = text.Length;
                        text.Remove(Math.Max(0, text.Length - count), Math.Min(text.Length, count));
                        break;
                    case 3:
                        int showIndex = int.Parse(command[1]);
                        Console.WriteLine(text.ToString()[showIndex - 1]);
                        break;
                    case 4:
                        text.Clear();
                        text.Append(stackTmp.Pop());
                        break;
                    default:
                        break;                            
                }
            }
        }
    }
}
