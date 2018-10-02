using System;
using System.Collections.Generic;
using System.Linq;

namespace PeriodicTable
{
    class PeriodicTable
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var compounds = new SortedSet<string>();
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                input.ToList().ForEach(s =>
                {
                    compounds.Add(s);
                });
            }
            Console.WriteLine(string.Join(' ', compounds));
        }
    }
}
