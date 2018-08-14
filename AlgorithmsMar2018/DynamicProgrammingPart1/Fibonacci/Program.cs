using System;
using System.Linq;
using System.Collections.Generic;

namespace LongestIncrSubseq
{
    class Program
    {
        static void Main()
        {
            var numbers = Console.ReadLine()
                .Split()
                .Select(s => int.Parse(s))
                .ToArray();
            var lis = new int[numbers.Length];
            var prev = new int[numbers.Length];
            var maxIndex = 0;
            var maxLength = 0;

            for (int currentIndex = 0; currentIndex < numbers.Length; currentIndex++)
            {
                var currentNumber = numbers[currentIndex];
                var solution = 1;
                var prevIndex = -1;
                for (int solutionIndex = 0; solutionIndex < currentIndex; solutionIndex++)
                {
                    var prevNumber = numbers[solutionIndex];
                    if (currentNumber > prevNumber && lis[solutionIndex] + 1 > solution)
                    {
                        solution = lis[solutionIndex] + 1;
                        prevIndex = solutionIndex;
                    }
                }
                lis[currentIndex] = solution;
                prev[currentIndex] = prevIndex;

                if (solution > maxLength)
                {
                    maxLength = solution;
                    maxIndex = currentIndex;
                }
            }

            var result = new List<int>();
            var index = maxIndex;

            while (index != -1)
            {
                result.Add(numbers[index]);
                index = prev[index];
            }
            result.Reverse();
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
