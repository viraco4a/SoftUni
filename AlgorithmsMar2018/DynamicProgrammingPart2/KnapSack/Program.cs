using System;
using System.Collections.Generic;
using System.Linq;

namespace KnapSack
{
    class Program
    {

        class Item
        {
            public string Name { get; set; }
            public int Weight { get; set; }
            public int Price { get; set; }
        }

        static void Main()
        {
            int maxCapacity = int.Parse(Console.ReadLine());
            List<Item> allItems = GetAllItems();
            var prices = new int[allItems.Count + 1, maxCapacity + 1];
            var itemsIncluded = new bool[allItems.Count + 1, maxCapacity + 1];

            for (int itemIndex = 0; itemIndex < allItems.Count; itemIndex++)
            {
                var currentItem = allItems[itemIndex];
                var rowIndex = itemIndex + 1;
                for (int capacity = 0; capacity <= maxCapacity; capacity++)
                {
                    if (currentItem.Weight > capacity)
                    {
                        continue;
                    }

                    var excluding = prices[rowIndex - 1, capacity];
                    var including = currentItem.Price + prices[rowIndex - 1, capacity - currentItem.Weight];

                    if (including > excluding)
                    {
                        prices[rowIndex, capacity] = including;
                        itemsIncluded[rowIndex, capacity] = true;
                    }
                    else
                    {
                        prices[rowIndex, capacity] = excluding;
                    }
                }
            }

            var currentCapacity = maxCapacity;
            var result = new List<Item>();

            for (int itemIndex = allItems.Count - 1; itemIndex >= 0; itemIndex--)
            {
                if (itemsIncluded[itemIndex + 1, currentCapacity])
                {
                    var currentItem = allItems[itemIndex];

                    result.Add(currentItem);

                    currentCapacity -= currentItem.Weight;
                }
            }
            Console.WriteLine($"Total Weight: {result.Sum(s => s.Weight)}");

            Console.WriteLine($"Total Value: {prices[allItems.Count, maxCapacity]}");

            foreach (var item in result.OrderBy(s => s.Name))
            {
                Console.WriteLine(item.Name);
            }
        }

        private static List<Item> GetAllItems()
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
