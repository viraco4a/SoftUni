using System;
using System.Text.RegularExpressions;
using System.Text;

namespace KeyReplacer
{
    class Program
    {
        private static string keyPattern = @"^([A-Za-z]+)[<|\\](.+)[<|\\]([A-Za-z]+)$";

        static void Main()
        {
            string keyString = Console.ReadLine();
            string input = Console.ReadLine();
            Match keyMatch = Regex.Match(keyString, keyPattern);
            string start = keyMatch.Groups[1].Value;
            string end = keyMatch.Groups[3].Value;
            string pattern = $@"{start}(.*?){end}";
            MatchCollection matches = Regex.Matches(input, pattern);
            StringBuilder sb = new StringBuilder();
            foreach (Match match in matches)
            {
                sb.Append(match.Groups[1].Value);
            }

            if (sb.Length == 0)
            {
                Console.WriteLine("Empty result");
            }
            else
            {
                Console.WriteLine(sb.ToString());
            }
        }
    }
}
