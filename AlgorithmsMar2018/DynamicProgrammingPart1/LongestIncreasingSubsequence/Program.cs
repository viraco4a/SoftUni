using System;
using System.Collections.Generic;
using System.Linq;

namespace LongestIncreasingSubsequence
{
    class Program
    {
        static void Main()
        {
            var numbers = Console.ReadLine().Split().Select(s => int.Parse(s)).ToArray();
            var lis = new int[numbers.Length];
            var prev = new int[numbers.Length];
            var maxSolution = 0;
            var maxSolutionIndex = 0;

            for (int currentIndex = 0; currentIndex < numbers.Length; currentIndex++)
            {
                var solution = 1;
                var prevIndex = -1;
                for (int solutionIndex = 0; solutionIndex < currentIndex; solutionIndex++)
                {
                    if (numbers[currentIndex] > numbers[solutionIndex] && lis[solutionIndex] + 1 > solution)
                    {
                        solution = lis[solutionIndex] + 1;
                        prevIndex = solutionIndex;
                    }
                }
                lis[currentIndex] = solution;
                prev[currentIndex] = prevIndex;

                if (solution > maxSolution)
                {
                    maxSolution = solution;
                    maxSolutionIndex = currentIndex;
                }
            }

            var index = maxSolutionIndex;
            var result = new List<int>();

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
