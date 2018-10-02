using System;
using System.Linq;
using System.Collections.Generic;

namespace UniqueUsernames
{
    class UniqueUsernames
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var set = new HashSet<string>();
            for (int i = 0; i < n; i++)
            {
                set.Add(Console.ReadLine());
            }
            set.ToList().ForEach(s => { Console.WriteLine(s); });
        }
    }
}
