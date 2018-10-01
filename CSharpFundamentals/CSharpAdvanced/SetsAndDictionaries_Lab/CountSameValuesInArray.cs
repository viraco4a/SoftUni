using System;
using System.Linq;
using System.Collections.Generic;

namespace CountSameValuesInArray
{
    class CountSameValuesInArray
    {
        static void Main(string[] args)
        {
            Dictionary<double, int> data = new Dictionary<double, int>();
            double[] input = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(double.Parse)
                .ToArray();

            foreach (double item in input)
            {
                if (!data.ContainsKey(item))
                {
                    data.Add(item, 0);
                }
                data[item]++;
            }

            foreach (var kvp in data)
            {
                Console.WriteLine($"{kvp.Key} - {kvp.Value} times");
            }
        }
    }
}
