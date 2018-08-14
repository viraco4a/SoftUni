using System;
using System.Linq;

namespace RodCutting
{
    class Program
    {

        private static int[] bestPrice;
        private static int[] price;
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

        private static int CutRod(int n)
        {
            for (int i = 1; i <= n; i++)
            {
                int currentBest = bestPrice[i];
                for (int j = 1; j <= i; j++)
                {
                    currentBest = Math.Max(bestPrice[i], price[j] + bestPrice[i - j]);
                    if (currentBest > bestPrice[i])
                    {
                        bestPrice[i] = currentBest;
                        bestCombo[i] = j;
                    }
                }
            }
            return bestPrice[n];
        }

        private static void ReconstructSolution(int n)
        {
            while (n - bestCombo[n] != 0)
            {
                Console.Write(bestCombo[n] + " ");
                n = n - bestCombo[n];
            }
            Console.WriteLine(bestCombo[n]);
        }

    }
}
