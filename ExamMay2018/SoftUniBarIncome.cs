using System;
using System.Text.RegularExpressions;

namespace SoftUniBarIncome
{
    class Program
    {
        private static string pattern = @"^([^\|\$\%\.])*?%(?<customer>[A-Z][a-z]+)%([^\|\$\%\.])*?<(?<product>[^\<\>]+)>([^\|\$\%\.])*?\|(?<count>\d+)\|([^\|\$\%\.])*?(?<price>\d+.?\d*)\$([^\|\$\%\.])*?$";

        static void Main()
        {
            double totalIncome = 0;
            string input = Console.ReadLine();
            while (input != "end of shift")
            {
                Match match = Regex.Match(input, pattern);
                if (match.Success)
                {
                    double totalPrice = int.Parse(match.Groups["count"].Value) * double.Parse(match.Groups["price"].Value);
                    Console.WriteLine($"{match.Groups["customer"].Value}: {match.Groups["product"].Value} - {totalPrice:F2}");
                    totalIncome += totalPrice;
                }

                input = Console.ReadLine();
            }
            Console.WriteLine($"Total income: {totalIncome:F2}");
        }
    }
}
