using System;

namespace StackFibonacci
{
    class StackFibonacci
    {
        private static long[] lookupTable;

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            lookupTable = new long[n];
            Console.WriteLine(getFibonacci(n - 1));
        }

        private static long getFibonacci(int n)
        {
            if (n == 1 || n == 0)
            {
                return 1;
            }
            if (lookupTable[n - 1] != 0)
            {
                return lookupTable[n - 1];
            }
            long x = getFibonacci(n - 1) + getFibonacci(n - 2);
            lookupTable[n - 1] = x;
            return x;
        }
    }
}
