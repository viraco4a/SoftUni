using System;
using System.Collections.Generic;
using System.Linq;

namespace Snowwhite
{
    class Dwarf
    {
        public string Name { get; set; }
        public string Color { get; set; }
        public int Physics { get; set; }
    }
    class Program
    {
        static void Main()
        {
            var dwarves = new List<Dwarf>();
            string input = Console.ReadLine();
            while (input != "Once upon a time")
            {
                var splitted = input.Split(new string[] { " <:> " }, StringSplitOptions.RemoveEmptyEntries);
                var dwarf = new Dwarf
                {
                    Name = splitted[0],
                    Color = splitted[1],
                    Physics = int.Parse(splitted[2])
                };
                var repeatedDwarf = dwarves.Find(s => (s.Name == dwarf.Name && s.Color == dwarf.Color));
                if (repeatedDwarf == null)
                {
                    dwarves.Add(dwarf);
                }
                else
                {
                    repeatedDwarf.Physics = Math.Max(repeatedDwarf.Physics, dwarf.Physics);
                }

                input = Console.ReadLine();
            }
            foreach (var dwarf in dwarves
                .OrderByDescending(s => s.Physics)
                .ThenByDescending(s => dwarves.Count(x => x.Color == s.Color)))
            {
                Console.WriteLine($"({dwarf.Color}) {dwarf.Name} <-> {dwarf.Physics}");
            }
        }
    }
}
