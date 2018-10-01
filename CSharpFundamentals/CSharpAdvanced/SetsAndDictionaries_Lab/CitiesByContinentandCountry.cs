using System;
using System.Collections.Generic;
using System.Linq;

namespace CitiesByContinentandCountry
{
    class CitiesByContinentandCountry
    {
        static void Main(string[] args)
        {
            var countries = new Dictionary<string, Dictionary<string, List<string>>>();
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var splitted = Console.ReadLine()
                    .Split(" ", StringSplitOptions.RemoveEmptyEntries);
                string continent = splitted[0];
                string country = splitted[1];
                string city = splitted[2];
                if (!countries.ContainsKey(continent))
                {
                    countries.Add(continent, new Dictionary<string, List<string>>());
                }

                if (!countries[continent].ContainsKey(country))
                {
                    countries[continent].Add(country, new List<string>());
                }

                countries[continent][country].Add(city);
            }

            countries
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{s.Key}:");
                    s.Value
                    .ToList()
                    .ForEach(v =>
                    {
                        Console.WriteLine($"{v.Key} -> {string.Join(", ", v.Value)}");
                    });
                });
        }
    }
}
