using System;
using System.Collections.Generic;
using System.Linq;

namespace CountSymbol
{
    class CountSymbol
    {
        static void Main(string[] args)
        {
            var letters = new SortedDictionary<char, int>();
            char[] text = Console.ReadLine().ToCharArray();

            for (int i = 0; i < text.Length; i++)
            {
                if (!letters.ContainsKey(text[i]))
                {
                    letters.Add(text[i], 0);
                }
                letters[text[i]]++;
            }

            letters.ToList().ForEach(s =>
            {
                Console.WriteLine($"{s.Key}: {s.Value} time/s");
            });
        }
    }
}
