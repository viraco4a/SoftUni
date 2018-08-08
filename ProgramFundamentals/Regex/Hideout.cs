using System;
using System.Text.RegularExpressions;

namespace Hideout
{
    class Program
    {
        static void Main()
        {
            string map = Console.ReadLine();
            while (true)
            {
                string clue = Console.ReadLine();
                char hideout = clue[0];
                int min = int.Parse(clue.Split()[1]);
                string pattern = $@"(.*?)(\{hideout}{{{min},}})";
                Match match = Regex.Match(map, pattern);
                if (match.Success)
                {
                    int index = match.Groups[1].Value.Length;
                    int length = match.Groups[2].Value.Length;
                    Console.WriteLine($"Hideout found at index {index} and it is with size {length}!");
                    return;
                }
            }
        }
    }
}
