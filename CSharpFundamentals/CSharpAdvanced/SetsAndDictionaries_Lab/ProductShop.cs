using System;
using System.Collections.Generic;
using System.Linq;

namespace ProductShop
{
    class ProductShop
    {
        static void Main(string[] args)
        {
            var shops = new Dictionary<string, Dictionary<string, double>>();
            string input = Console.ReadLine();

            while (input != "Revision")
            {
                var splitted = input
                    .Split(", ", StringSplitOptions.RemoveEmptyEntries);
                string shop = splitted[0];
                string product = splitted[1];
                double price = double.Parse(splitted[2]);
                if (!shops.ContainsKey(shop))
                {
                    shops.Add(shop, new Dictionary<string, double>());
                }

                if (!shops[shop].ContainsKey(product))
                {
                    shops[shop].Add(product, 0);
                }

                shops[shop][product] = price;

                input = Console.ReadLine();
            }

            shops
                .OrderBy(s => s.Key)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{s.Key}->");
                    s.Value
                    .ToList()
                    .ForEach(v =>
                    {
                        Console.WriteLine($"Product: {v.Key}, Price: {v.Value}");
                    });
                });
        }
    }
}
