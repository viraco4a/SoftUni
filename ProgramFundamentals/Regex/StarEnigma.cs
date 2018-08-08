using System;
using System.Text.RegularExpressions;
using System.Text;
using System.Collections.Generic;
using System.Linq;

namespace StarEnigma
{
    class Program
    {
        private static string starPattern = @"[s,t,a,r,S,T,A,R]";
        private static string pattern = @"([^@\-!:>]*)@(?<planet>[A-Za-z]+)([^@\-!:>]*):(\d+)!(?<type>[AD])!([^@\-!:>]*)->(\d+)([^@\-!:>]*)";

        private static int decryptionKey;
        private static List<string> attacked = new List<string>();
        private static List<string> destroyed = new List<string>();

        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();
                decryptionKey = GetKey(input);
                string decryptedInput = Decrypt(input);
                Fight(decryptedInput);
            }

            Print();
        }

        private static void Fight(string decryptedInput)
        {
            Match match = Regex.Match(decryptedInput, pattern);
            string status = match.Groups["type"].Value;
            string name = match.Groups["planet"].Value;
            if (status == "A" && match.Success)
            {
                attacked.Add(name);
            }
            else if (status == "D" && match.Success)
            {
                destroyed.Add(name);
            }
        }

        private static void Print()
        {
            int attack = attacked.Count;
            int destroy = destroyed.Count;
            Console.WriteLine($"Attacked planets: {attack}");
            if (attack > 0)
            {
                foreach (var planet in attacked.OrderBy(s => s))
                {
                    Console.WriteLine($"-> {planet}");
                }
            }
            Console.WriteLine($"Destroyed planets: {destroy}");
            if (destroy > 0)
            {
                foreach (var planet in destroyed.OrderBy(s => s))
                {
                    Console.WriteLine($"-> {planet}");
                }
            }
        }

        private static string Decrypt(string input)
        {
            var sb = new StringBuilder();
            for (int i = 0; i < input.Length; i++)
            {
                char local = (char)(input[i] - decryptionKey);
                sb.Append(local.ToString());
            }
            return sb.ToString();
        }

        private static int GetKey(string input)
        {
            MatchCollection matches = Regex.Matches(input, starPattern);
            return matches.Count;
        }
    }
}
