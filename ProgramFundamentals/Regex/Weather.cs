using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace Weather
{
    class Program
    {
        private static string pattern = @"(?<city>[A-Z]{2})(?<temp>\d+\.\d+)(?<weather>[A-Za-z]+)\|";
        private static Dictionary<string, Dictionary<double, string>> forecast = new Dictionary<string, Dictionary<double, string>>();

        static void Main()
        {
            string input = Console.ReadLine();

            while (input != "end")
            {
                Match match = Regex.Match(input, pattern);
                if (!match.Success)
                {
                    input = Console.ReadLine();
                    continue;
                }
                string town = match.Groups["city"].Value;
                double temp = double.Parse(match.Groups["temp"].Value);
                string weather = match.Groups["weather"].Value;
                if (!forecast.ContainsKey(town))
                {
                    forecast.Add(town, new Dictionary<double, string>());
                }
                else
                {
                    forecast[town].Clear();
                }

                forecast[town].Add(temp, weather);

                input = Console.ReadLine();
            }

            foreach (var town in forecast.OrderBy(s => s.Value.FirstOrDefault().Key))
            {
                Console.WriteLine($"{town.Key} => {town.Value.FirstOrDefault().Key:F2} => {town.Value.FirstOrDefault().Value}");
            }
        }
    }
}
