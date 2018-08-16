using System;
using System.Text;

namespace Parentheses
{
    class Program
    {
        private static int N;
        private static int opening = 0;
        private static int closing = 0;
        private static char[] parenthesis;
        private static StringBuilder result;

        static void Main()
        {
            N = int.Parse(Console.ReadLine());
            result = new StringBuilder();
            parenthesis = new char[2 * N];
            parenthesis[0] = '(';
            opening++;

            CalculateComb(1);
            Console.WriteLine(result);
        }

        private static void CalculateComb(int index)
        {
            if (index == 2 * N)
            {
                result.AppendLine(string.Join("", parenthesis));
                return;
            }
            if (opening < N)
            {
                parenthesis[index] = '(';
                opening++;
                CalculateComb(index + 1);
                opening--;
            }
            if (closing < opening)
            {
                parenthesis[index] = ')';
                closing++;
                CalculateComb(index + 1);
                closing--;
            }
        }
    }
}
