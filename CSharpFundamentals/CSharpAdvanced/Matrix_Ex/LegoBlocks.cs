using System;
using System.Linq;
using System.Text;

namespace LegoBlocks
{
    class LegoBlocks
    {
        private static int[][] firstMatrix;
        private static int[][] secondMatrix;
        private static int[][] rotated;
        private static int cols = 0;

        static void Main(string[] args)
        {
            ReadInput();
            cols = firstMatrix[0].Length + secondMatrix[0].Length;
            for (int row = 1; row < firstMatrix.Length; row++)
            {
                if (firstMatrix[row].Length + secondMatrix[row].Length != cols)
                {
                    PrintNo();
                    return;
                }
            }
            //for (int i = 0; i < firstMatrix.Length; i++)
            //{
            //    Console.WriteLine($"[{string.Join(", ", firstMatrix[i].Concat(secondMatrix[i].Reverse()))}]");
            //}
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < firstMatrix.Length; row++)
            {
                sb.Append("[");
                sb.Append(string.Join(", ", firstMatrix[row]));
                sb.Append(", ");
                sb.Append(string.Join(", ", secondMatrix[row].Reverse()));
                sb.Append("]");
                Console.WriteLine(sb.ToString());
                sb.Clear();
            }
        }

        private static void PrintNo()
        {
            int sum = 0;
            for (int row = 0; row < firstMatrix.Length; row++)
            {
                sum += firstMatrix[row].Length;
                sum += secondMatrix[row].Length;
            }
            Console.WriteLine($"The total number of cells is: {sum}");
        }

        private static void ReadInput()
        {
            int n = int.Parse(Console.ReadLine());
            firstMatrix = new int[n][];
            secondMatrix = new int[n][];
            for (int row = 0; row < n; row++)
            {
                firstMatrix[row] = ReadLine();
            }
            for (int row = 0; row < n; row++)
            {
                secondMatrix[row] = ReadLine();
            }
        }

        private static int[] ReadLine()
        {
            return Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
        }
    }
}
