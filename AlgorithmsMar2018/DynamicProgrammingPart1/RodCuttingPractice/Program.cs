using System;
using System.Linq;

namespace RodCuttingPractice
{
    class Program
    {

        private static int[] price;
        private static int[] bestPrice;
        private static int[] bestCombo;


        static void Main()
        {
            price = Console.ReadLine().Split().Select(s => int.Parse(s)).ToArray();
            int n = int.Parse(Console.ReadLine());
            bestPrice = new int[n + 1];
            bestCombo = new int[n + 1];
            CutRod(n);
            Console.WriteLine(bestPrice[n]);
            ReconstructSolution(n);
        }

        private static void ReconstructSolution(int n)
        {
            while (n - bestCombo[n] != 0)
            {
                Console.Write(bestCombo[n] + " ");
                n -= bestCombo[n];
            }
            Console.WriteLine(bestCombo[n]);
        }

        private static void CutRod(int n)
        {
            for (int i = 1; i <= n; i++)
            {
                var currentPrice = bestPrice[i];
                for (int j = 1; j <= i; j++)
                {
                    currentPrice = Math.Max(bestPrice[i], price[j] + bestPrice[i - j]);
                    if (currentPrice > bestPrice[i])
                    {
                        bestPrice[i] = currentPrice;
                        bestCombo[i] = j;
                    }
                }
            }
        }
    }
}
