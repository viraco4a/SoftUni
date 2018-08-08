using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Mines
{
    class Program
    {
        static void Main()
        {
            string pattern = @"(.*?)(<.{2}>)";
            string input = Console.ReadLine();
            MatchCollection matches = Regex.Matches(input, pattern);
            List<int> bombPowers = new List<int>();
            foreach (Match match in matches)
            {
                string nums = match.Groups[2].Value;
                int bomb = Math.Abs(nums[1] - nums[2]);
                bombPowers.Add(bomb);
            }
            string deletePattern = @"(<[a-zA-Z]{2}>)";
            Regex fuRegex = new Regex(deletePattern);
            input = fuRegex.Replace(input, " ");
            List<string> textToBomb = input.Split(' ').ToList();
            var sb = new StringBuilder();
            for (int i = 1, j = 0; i < textToBomb.Count; i++, j++)
            {
                int currentPower = bombPowers[j];

                string firstParttern = $@"(.*)(.{{{currentPower}}})";
                string secondParttern = $@"(.{{{currentPower}}})(.*)";

                if (i == 1)
                {
                    Regex regexFirst = new Regex(firstParttern);
                    Match match = regexFirst.Match(textToBomb[i - 1]);
                    string replace = match.Groups[1] + new string('_', currentPower);
                    sb.Append(replace);
                }

                Regex regexSecond = new Regex(secondParttern);
                Match matchSecond = regexSecond.Match(textToBomb[i]);
                string replaceSecond = new string('_', currentPower) + "____" + matchSecond.Groups[2];
                textToBomb[i] = replaceSecond;
                sb.Append(replaceSecond);
            }
            Console.WriteLine(sb.ToString());
        }


    }
}
