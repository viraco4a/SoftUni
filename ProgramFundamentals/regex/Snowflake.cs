using System;
using System.Text.RegularExpressions;

namespace Snowflake
{
    class Program
    {
        private static string surface = @"(?<surface>[^A-Za-z0-9]+)$";
        private static string mantle = @"(?<mantle>[0-9_]+)$";
        private static string core = @"([^A-Za-z0-9]+)([0-9_]+)(?<core>[A-Za-z]+)([0-9_]+)([^A-Za-z0-9]+)$";
        private static int size;

        static void Main()
        {
            for (int i = 1; i <= 5; i++)
            {
                string input = Console.ReadLine();
                if (i == 1 || i == 5)
                {
                    Match match = Regex.Match(input, surface);
                    if (!match.Success)
                    {
                        Console.WriteLine("Invalid");
                        return;
                    }
                }
                else if (i % 2 == 0)
                {
                    Match match = Regex.Match(input, mantle);
                    if (!match.Success)
                    {
                        Console.WriteLine("Invalid");
                        return;
                    }
                }
                else
                {
                    Match match = Regex.Match(input, core);
                    if (!match.Success)
                    {
                        Console.WriteLine("Invalid");
                        return;
                    }
                    size = match.Groups["core"].Value.Length;
                }
            }
            Console.WriteLine("Valid");
            Console.WriteLine(size);
        }
    }
}
