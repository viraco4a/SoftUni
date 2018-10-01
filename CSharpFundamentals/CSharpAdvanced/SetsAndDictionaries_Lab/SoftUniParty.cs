using System;
using System.Collections.Generic;
using System.Linq;

namespace SoftUniParty
{
    class SoftUniParty
    {
        static void Main(string[] args)
        {
            var vipSet = new HashSet<string>();
            var set = new HashSet<string>();

            string guest = Console.ReadLine();
            while (guest != "PARTY")
            {
                if (char.IsDigit(guest[0]))
                {
                    vipSet.Add(guest);
                }
                else
                {
                    set.Add(guest);
                }

                guest = Console.ReadLine();
            }

            string coming = Console.ReadLine();
            while (coming != "END")
            {
                if (vipSet.Contains(coming))
                {
                    vipSet.Remove(coming);
                }
                else if (set.Contains(coming))
                {
                    set.Remove(coming);
                }

                coming = Console.ReadLine();
            }

            Console.WriteLine(set.Count + vipSet.Count);
            vipSet.ToList().ForEach(s => { Console.WriteLine(s); });
            set.ToList().ForEach(s => { Console.WriteLine(s); });
        }
    }
}
