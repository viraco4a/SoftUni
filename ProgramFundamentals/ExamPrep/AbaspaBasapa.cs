using System;
using System.Text;

namespace AbaspaBasapa
{
    class Program
    {
        static void Main()
        {
            var first = Console.ReadLine();
            var second = Console.ReadLine();
            var lcs = new int[first.Length, second.Length];

            var max = 0;
            var maxI = 0;
            var maxJ = 0;

            for (int i = 0; i < first.Length; i++)
            {
                for (int j = 0; j < second.Length; j++)
                {
                    if (first[i] == second[j])
                    {
                        var result = 1;
                        if (i - 1 >= 0 && j - 1 >= 0)
                        {
                            result = lcs[i - 1, j - 1] + 1;
                        }
                        lcs[i, j] = result;
                    }
                    else
                    {
                        lcs[i, j] = 0;
                    }
                    if (lcs[i, j] > max)
                    {
                        max = lcs[i, j];
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
            var sb = new StringBuilder();
            for (int i = max - 1; i >= 0; i--)
            {
                sb.Append(first[maxI - i]);
            }
            Console.WriteLine(sb.ToString());
            
        }
    }
}
