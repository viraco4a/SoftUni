using System;
using System.Text.RegularExpressions;
using System.Text;
using System.Collections.Generic;

namespace OnlyLetters
{
    class Program
    {
        static void Main()
        {
            string pattern = @"(.*?)(\d+)(.{0,1})";
            string patternTwo = @"(.*?)(\d+)(.{0,1})([A-Za-z]*?$)";
            string input = Console.ReadLine();
            var sb = new StringBuilder();
            MatchCollection matches = Regex.Matches(input, pattern);
            Match matchShit = Regex.Match(input, patternTwo);

            foreach (Match match in matches)
            {
                sb.Append(match.Groups[1].Value);
                if (match.Groups[3].Value == string.Empty)
                {
                    sb.Append(match.Groups[2].Value);
                    continue;
                }
                sb.Append(match.Groups[3].Value);
                sb.Append(match.Groups[3].Value);
            }
            sb.Append(matchShit.Groups[4].Value);
            Console.WriteLine(sb.ToString());

        }
    }
}
