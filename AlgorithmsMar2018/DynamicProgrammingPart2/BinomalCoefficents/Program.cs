using System;
using System.Collections.Generic;

namespace BinomialCoefficients
{
    class Program
    {

        private static Dictionary<string, double> allBinoms;

        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());
            allBinoms = new Dictionary<string, double>();
            double result = Binom(n, k);
            Console.WriteLine(result);
        }

        private static double Binom(int n, int k)
        {
            if (allBinoms.ContainsKey(n + " " + k))
            {
                return allBinoms[n + " " + k];
            }
            if (k > n)
            {
                allBinoms[n + " " + k] = 0;
                return 0;
            }
            if (k == 0 || k == n)
            {
                allBinoms[n + " " + k] = 1;
                return 1;
            }
            allBinoms[n + " " + k] = Binom(n - 1, k - 1) + Binom(n - 1, k);
            return allBinoms[n + " " + k];
        }

    }
}
