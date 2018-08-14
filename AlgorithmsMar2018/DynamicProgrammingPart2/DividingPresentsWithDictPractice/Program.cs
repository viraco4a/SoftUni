using System;
using System.Linq;
using System.Collections.Generic;

namespace DividingPresentsWithDictPractice
{
    class Program
    {
        static void Main()
        {
            var numbers = Console.ReadLine()
                .Split()
                .Select(s => int.Parse(s))
                .ToArray();
            var allPossibleSums = new Dictionary<int, int>();
            allPossibleSums.Add(0, 0);
            for (int i = 0; i < numbers.Length; i++)
            {
                var tmpSums = new Dictionary<int, int>();
                foreach (var sum in allPossibleSums.Keys)
                {
                    var newSum = sum + numbers[i];
                    if (!allPossibleSums.ContainsKey(newSum))
                    {
                        tmpSums.Add(newSum, numbers[i]);
                    }
                }

                foreach (var sum in tmpSums)
                {
                    if (!allPossibleSums.ContainsKey(sum.Key))
                    {
                        allPossibleSums.Add(sum.Key, sum.Value);
                    }
                }
            }

            int maxSum = numbers.Sum(s => s);
            int bestSum = 0;
            int minDiff = int.MaxValue;
            foreach (var possibleSum in allPossibleSums)
            {
                if (possibleSum.Key < maxSum)
                {
                    int bob = maxSum - possibleSum.Key;
                    int diff = bob - possibleSum.Key;
                    if (diff >= 0 && diff < minDiff)
                    {
                        minDiff = diff;
                        bestSum = possibleSum.Key;
                    }
                }
            }
            int alanSum = bestSum;
            var alan = new List<int>();
            var currentPresent = allPossibleSums[bestSum];
            while (bestSum > 0)
            {
                alan.Add(currentPresent);
                bestSum -= currentPresent;
                currentPresent = allPossibleSums[bestSum];
            }
            Console.WriteLine($"Difference: {minDiff}");
            Console.WriteLine($"Alan:{alanSum} Bob:{maxSum - alanSum}");
            Console.WriteLine($"Alan takes: {string.Join(" ", alan)}");
            Console.WriteLine($"Bob takes the rest.");
        }
    }
}
