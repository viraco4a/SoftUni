using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace MatchNumbers
{
    class Program
    {
        static void Main()
        {
            string pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";
            string input = Console.ReadLine();
            var list = new List<string>();
            MatchCollection matches = Regex.Matches(input, pattern);
            foreach (Match match in matches)
            {
                list.Add(match.Value);
            }
            Console.WriteLine(string.Join(" ", list));
        }
    }
}
