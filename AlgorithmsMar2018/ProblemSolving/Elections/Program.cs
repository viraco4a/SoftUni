using System;
using System.Collections.Generic;
using System.Linq;

namespace Elections
{
    class Program
    {
        private static int numberOfComb;
        private static int neededSeats;


        static void Main()
        {
            neededSeats = int.Parse(Console.ReadLine());
            int numberOfParties = int.Parse(Console.ReadLine());
            var ListOfParties = new int[numberOfParties];

            for (int i = 0; i < numberOfParties; i++)
            {
                ListOfParties[i] = int.Parse(Console.ReadLine());
            }
            numberOfComb = 0;
            var sums = IsSubsetSum(ListOfParties, numberOfParties, neededSeats);

            Console.WriteLine(numberOfComb);
        }

        private static bool IsSubsetSum(int[] set, int n, int sum)
        {
            bool[,] subset = new bool[sum + 1, n + 1];

            for (int i = 0; i <= n; i++)
            {
                subset[0, i] = true;
            }

            for (int i = 0; i <= sum; i++)
            {
                subset[i, 0] = false;
            }

            for (int i = 1; i <= sum; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    subset[i, j] = subset[i, j - 1];
                    if (i >= set[j - 1])
                    {
                        subset[i, j] = subset[i, j] ||  subset[i - set[j - 1], j - 1];
                    }
                }
            }
            return subset[sum, n];
        }
    }
}
