using System;
using System.Collections.Generic;
using System.Linq;

namespace Wardrobe
{
    class Wardrobe
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var clothes = new Dictionary<string, Dictionary<string, int>>();
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(new string[] { " -> ", "," },
                    StringSplitOptions.RemoveEmptyEntries);
                string color = input[0];
                var list = input.Skip(1).ToList();

                if (!clothes.ContainsKey(color))
                {
                    clothes.Add(color, new Dictionary<string, int>());
                }

                list.ForEach(e =>
                {
                    if (!clothes[color].ContainsKey(e))
                    {
                        clothes[color].Add(e, 0);
                    }
                    clothes[color][e]++;
                });
            }
            var seeked = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);

            clothes
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{s.Key} clothes:");
                    s.Value.ToList().ForEach(e =>
                    {
                        Console.Write($"* {e.Key} - {e.Value}");
                        if (s.Key == seeked[0] && e.Key == seeked[1])
                        {
                            Console.Write(" (found!)");
                        }
                        Console.WriteLine();
                    });
                });
        }
    }
}
