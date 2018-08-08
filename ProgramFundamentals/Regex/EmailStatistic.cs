using System;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;

namespace EmailStatistic
{
    class Program
    {
        static void Main()
        {
            string pattern = @"^(?<userName>[A-Za-z]{5,})@(?<domain>([a-z]{3,})(\.)(com|org|bg)$)";
            int n = int.Parse(Console.ReadLine());
            var data = new Dictionary<string, List<string>>();

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                Match match = Regex.Match(input, pattern);
                if (!match.Success)
                {
                    continue;
                }
                string domain = match.Groups["domain"].Value;
                string userName = match.Groups["userName"].Value;
                if (!data.ContainsKey(domain))
                {
                    data.Add(domain, new List<string>());
                }
                else
                {
                    if (data[domain].Contains(userName))
                    {
                        continue;
                    }
                }
                data[domain].Add(userName);
            }

            foreach (var domain in data.OrderByDescending(s => s.Value.Count))
            {
                Console.WriteLine($"{domain.Key}:");
                foreach (var user in domain.Value)
                {
                    Console.WriteLine($"### {user}");
                }
            }

        }
    }
}
