using System;
using System.Linq;
using System.Collections.Generic;

namespace DividingPresentsWithDict
{
    class Program
    {
        static void Main()
        {
            var numbers = Console.ReadLine()
                .Split()
                .Select(s => int.Parse(s))
                .ToArray();
            //var numbers = new int[] { 5, 10, 15, 9 };
            var allPossibleUniqueSums = new Dictionary<int, int>(); //collection of all sums, keys = sums, values = original value from numbers[]

            // filling of all possible sums into the collection:
            allPossibleUniqueSums.Add(0, 0);
            for (int i = 0; i < numbers.Length; i++)
            {
                var newSums = new Dictionary<int, int>();
                foreach (var sum in allPossibleUniqueSums.Keys)
                {
                    int newSum = sum + numbers[i];
                    if (!allPossibleUniqueSums.ContainsKey(newSum))
                    {
                        newSums.Add(newSum, numbers[i]);
                    }
                }

                foreach (var kvp in newSums)
                {
                    if (!allPossibleUniqueSums.ContainsKey(kvp.Key))
                    {
                        allPossibleUniqueSums.Add(kvp.Key, kvp.Value);
                    }
                }
            }

            //finding of minDiff and best sum for Alan:
            int maxSum = numbers.Sum(s => s);
            int minDiff = int.MaxValue;
            int bestSum = 0;
            foreach (var possibleSum in allPossibleUniqueSums)
            {
                if (possibleSum.Key < maxSum)
                {
                    var bob = maxSum - possibleSum.Key;
                    var diff = bob - possibleSum.Key;
                    if (diff < minDiff && diff >= 0)
                    {
                        minDiff = diff;
                        bestSum = possibleSum.Key;
                    }
                }
            }
            int alanSum = bestSum;

            var alanPresents = new List<int>();
            int currentPresent = allPossibleUniqueSums[bestSum];
            while (bestSum > 0)
            {
                alanPresents.Add(currentPresent);
                bestSum -= currentPresent;
                currentPresent = allPossibleUniqueSums[bestSum];
            }

            //print
            Console.WriteLine("Difference: {0}", minDiff);
            Console.WriteLine($"Alan:{alanSum} Bob:{maxSum - alanSum}");
            Console.WriteLine("Alan takes: {0}", string.Join(" ", alanPresents));
            Console.WriteLine("Bob takes the rest.");
        }
    }
}
