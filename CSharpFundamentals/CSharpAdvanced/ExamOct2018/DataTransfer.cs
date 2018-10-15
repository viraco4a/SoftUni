using System;
using System.Text.RegularExpressions;
using System.Text;

namespace DataTransfer
{
    class DataTransfer
    {
        private static long size = 0;
        private static string digitPattern = @"[0-9]";
        private static string letterPattern = @"[A-Za-z ]";
        static void Main(string[] args)
        {
            string pattern = "^s:([^;]+);r:([^;]+);m--\"([A-Za-z ]+)\"$";
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string line = Console.ReadLine();
                Match match = Regex.Match(line, pattern);
                string sender = match.Groups[1].ToString();
                string receiver = match.Groups[2].ToString();
                string message = match.Groups[3].ToString();

                if (match.ToString() == string.Empty)
                {
                    continue;
                }
                AddSize(sender);
                AddSize(receiver);
                string senderName = GetName(sender);
                string receiverName = GetName(receiver);
                Console.WriteLine($"{senderName} says \"{message}\" to {receiverName}");
            }

            Console.WriteLine($"Total data transferred: {size}MB");
        }

        private static string GetName(string name)
        {
            MatchCollection matches = Regex.Matches(name, letterPattern);
            StringBuilder sb = new StringBuilder();
            foreach (Match match in matches)
            {
                sb.Append(match.ToString());
            }
            return sb.ToString();
        }

        private static void AddSize(string name)
        {
            MatchCollection matches = Regex.Matches(name, digitPattern);
            foreach (Match match in matches)
            {
                size += int.Parse(match.ToString());
            }
        }
    }
}
