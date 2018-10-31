using System;
using System.Linq;

namespace P03_JediGalaxy
{
    class JediGalaxy
    {
        private static int[,] matrix;
        static void Main()
        {
            GetMatrix();

            string command = Console.ReadLine();
            long sum = 0;
            while (command != "Let the Force be with you")
            {
                int[] ivoStartCoordinates = ReadData(command);
                int[] evilStartCoordinates = ReadData(Console.ReadLine());

                ApplyEvilForce(evilStartCoordinates);

                sum = CollectPower(sum, ivoStartCoordinates);

                command = Console.ReadLine();
            }

            Console.WriteLine(sum);
        }

        private static long CollectPower(long sum, int[] ivoStartCoordinates)
        {
            int ivoStartRow = ivoStartCoordinates[0];
            int ivoStartCol = ivoStartCoordinates[1];

            while (ivoStartRow >= 0 && ivoStartCol < matrix.GetLength(1))
            {
                if (IsValid(ivoStartRow, ivoStartCol))
                {
                    sum += matrix[ivoStartRow, ivoStartCol];
                }

                ivoStartCol++;
                ivoStartRow--;
            }

            return sum;
        }

        private static void ApplyEvilForce(int[] evilStartCoordinates)
        {
            int evilStartRow = evilStartCoordinates[0];
            int evilStartCol = evilStartCoordinates[1];

            while (evilStartRow >= 0 && evilStartCol >= 0)
            {
                if (IsValid(evilStartRow, evilStartCol))
                {
                    matrix[evilStartRow, evilStartCol] = 0;
                }
                evilStartRow--;
                evilStartCol--;
            }
        }

        private static void GetMatrix()
        {
            int[] dimestions = ReadData(Console.ReadLine());
            int rows = dimestions[0];
            int cols = dimestions[1];

            matrix = new int[rows, cols];

            int value = 0;
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = value++;
                }
            }
        }

        private static bool IsValid(int row, int col)
        {
            return 
                row >= 0 &&
                row < matrix.GetLength(0) &&
                col >= 0 &&
                col < matrix.GetLength(1);
        }

        private static int[] ReadData(string command)
        {
            return command
                .Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
        }
    }
}
