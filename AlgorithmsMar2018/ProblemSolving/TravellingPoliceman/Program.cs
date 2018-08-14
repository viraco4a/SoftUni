using System;
using System.Collections.Generic;
using System.Linq;

namespace TravellingPoliceman
{
    class Item
    {
        public string Name { get; set; }
        public int WeightStreetLength { get; set; }
        public int Price { get; set; }
        public int CarDamage { get; set; }
        public int Pokemon { get; set; }

        public void CalcPrice()
        {
            this.Price = Pokemon * 10 - CarDamage;
        }
    }

    class Program
    {
        static void Main()
        {
            var maxCapacityFuel = int.Parse(Console.ReadLine());
            List<Item> allItems = GetAllItems();
            var profit = new int[allItems.Count + 1, maxCapacityFuel + 1];
            var isItemTaken = new bool[allItems.Count + 1, maxCapacityFuel + 1];

            for (int itemIndex = 0; itemIndex < allItems.Count; itemIndex++)
            {
                var currentItem = allItems[itemIndex];
                var rowIndex = itemIndex + 1;
                for (int capacity = 0; capacity <= maxCapacityFuel; capacity++)
                {
                    var excluded = profit[rowIndex - 1, capacity];
                    var included = 0;
                    if (currentItem.WeightStreetLength <= capacity)
                    {
                        included = profit[rowIndex - 1, capacity - currentItem.WeightStreetLength] + currentItem.Price;
                        //continue;
                    }

                    if (included > excluded)
                    {
                        profit[rowIndex, capacity] = included;
                        isItemTaken[rowIndex, capacity] = true;
                    }
                    else
                    {
                        profit[rowIndex, capacity] = excluded;
                    }
                }
            }

            var result = new List<Item>();
            var currentCapacity = maxCapacityFuel;

            for (int i = allItems.Count - 1; i >= 0; i--)
            {
                if (isItemTaken[i + 1, currentCapacity])
                {
                    result.Add(allItems[i]);
                    currentCapacity -= allItems[i].WeightStreetLength;
                }
            }
            result.Reverse();
            var streets = new string[result.Count];
            for (int i = 0; i < result.Count; i++)
            {
                streets[i] = result[i].Name;
            }
            Console.WriteLine(string.Join(" -> ", streets));
            Console.WriteLine($"Total pokemons caught -> {result.Sum(s => s.Pokemon)}");
            Console.WriteLine($"Total car damage -> {result.Sum(s => s.CarDamage)}");
            Console.WriteLine($"Fuel Left -> {currentCapacity}");
        }

        private static List<Item> GetAllItems()
        {
            var allItems = new List<Item>();
            string input = Console.ReadLine();
            while (input != "End")
            {
                var splitted = input.Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries).ToArray();
                var newItem = new Item()
                {
                    Name = splitted[0],
                    WeightStreetLength = int.Parse(splitted[3]),
                    Pokemon = int.Parse(splitted[2]),
                    CarDamage = int.Parse(splitted[1])
                };
                newItem.CalcPrice();
                if (newItem.Price > 0)
                {
                    allItems.Add(newItem);
                }
                input = Console.ReadLine();
            }
            //allItems = allItems.OrderBy(s => s.Name).ToList();
            return allItems;
        }
    }
}
