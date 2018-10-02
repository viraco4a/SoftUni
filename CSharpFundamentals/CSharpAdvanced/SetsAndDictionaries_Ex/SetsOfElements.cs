using System;
using System.Collections.Generic;
using System.Linq;

namespace SetsOfElements
{
    class SetsOfElements
    {
        static void Main(string[] args)
        {
            int[] dimensions = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int n = dimensions[0];
            int m = dimensions[1];
            var first = new HashSet<int>();
            var second = new HashSet<int>();

            for (int i = 0; i < n; i++)
            {
                first.Add(int.Parse(Console.ReadLine()));
            }
            for (int i = 0; i < m; i++)
            {
                second.Add(int.Parse(Console.ReadLine()));
            }

            first
                .ToList()
                .ForEach(s =>
                {
                    if (!second.Contains(s))
                    {
                        first.Remove(s);
                    }
                });
            Console.WriteLine(string.Join(' ', first));
        }
    }
}
