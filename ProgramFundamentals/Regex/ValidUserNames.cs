using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace ValidUserNames
{
    class Program
    {
        private static string pattern = @"^[A-Za-z][A-Za-z0-9_]{2,24}$";

        static void Main()
        {
            var input = Console.ReadLine().Split(new char[] { ' ', '/', '\\', '(', ')' }, StringSplitOptions.RemoveEmptyEntries);
            var list = new List<string>();
            foreach (var user in input)
            {
                Match match = Regex.Match(user, pattern);
                if (match.Success)
                {
                    list.Add(match.Value);
                }
            }
            int maxSum = 0;
            int start = 0;
            int end = 0;
            for (int i = 1; i < list.Count; i++)
            {
                int sum = list[i - 1].Length + list[i].Length;
                if (sum > maxSum)
                {
                    maxSum = sum;
                    start = i - 1;
                    end = i;
                }
            }

            Console.WriteLine(list[start] + "\n" + list[end]);
        }
    }
}
