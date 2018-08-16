using System;
using System.Collections.Generic;
using System.Linq;

namespace KnapSackPractice
{

    class Item
    {
        public string Name { get; set; }
        public int Weight { get; set; }
        public int Price { get; set; }
    }

    class Program
    {
        static void Main()
        {
            int maxCapacity = int.Parse(Console.ReadLine());
            List<Item> allItems = GenerateItems();
            var prices = new int[allItems.Count + 1, maxCapacity + 1];
            var takenItems = new bool[allItems.Count + 1, maxCapacity + 1];

            for (int i = 0; i < allItems.Count; i++)
            {
                var currentItem = allItems[i];
                var rowIndex = i + 1;
                for (int j = 0; j <= maxCapacity; j++)
                {
                    if (currentItem.Weight > j)
                    {
                        continue;
                    }

                    var excluded = prices[rowIndex - 1, j];
                    var included = currentItem.Price + prices[rowIndex - 1, j - currentItem.Weight];

                    if (included > excluded)
                    {
                        prices[rowIndex, j] = included;
                        takenItems[rowIndex, j] = true;
                    }
                    else
                    {
                        prices[rowIndex, j] = excluded;
                    }
                }
            }

            var result = new List<Item>();
            var capacity = maxCapacity;

            for (int i = allItems.Count - 1; i >= 0; i--)
            {
                if (takenItems[i + 1, capacity])
                {
                    var currentItem = allItems[i];

                    result.Add(currentItem);

                    capacity -= currentItem.Weight;
                }
            }

            Console.WriteLine($"Total Weight: {result.Sum(s => s.Weight)}");

            Console.WriteLine($"Total Value: {prices[allItems.Count, maxCapacity]}");

            foreach (var item in result.OrderBy(s => s.Name))
            {
                Console.WriteLine(item.Name);
            }
        }

        private static List<Item> GenerateItems()
        {
            var allItems = new List<Item>();
            string input = Console.ReadLine();
            while (input != "end")
            {
                var splitted = input.Split();
                var newItem = new Item()
                {
                    Name = splitted[0],
                    Weight = int.Parse(splitted[1]),
                    Price = int.Parse(splitted[2])
                };
                allItems.Add(newItem);
                input = Console.ReadLine();
            }
            allItems = allItems.OrderBy(s => s.Name).ToList();
            return allItems;
        }

    }
}
