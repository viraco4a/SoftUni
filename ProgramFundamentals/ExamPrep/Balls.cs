using System;
using System.Collections.Generic;
using System.Text;

namespace Balls
{
    class Program
    {
        private static int[] elements;
        private static int capacity;
        private static StringBuilder sb = new StringBuilder();

        static void Main()
        {
            int poketCount = int.Parse(Console.ReadLine());
            int totalBalls = int.Parse(Console.ReadLine());
            capacity = int.Parse(Console.ReadLine());
            elements = new int[poketCount];

            GenBalls(0, totalBalls);
            Console.WriteLine(sb.ToString().Trim());
        }

        private static void GenBalls(int index, int ballsLeft)
        {
            if (index >= elements.Length)
            {
                Print();
            }
            else
            {
                if (index == elements.Length - 1)
                {
                    if (ballsLeft <= capacity)
                    {
                        elements[index] = ballsLeft;
                        Print();
                    }
                }
                else
                {
                    var balls = Math.Min(capacity, ballsLeft - (elements.Length - index - 1));
                    for (int i = balls; i > 0; i--)
                    {
                        elements[index] = i;
                        GenBalls(index + 1, ballsLeft - i);
                    }
                }
            }
        }

        private static void Print()
        {
            sb.AppendLine(string.Join(", ", elements));
        }
    }
}
